package service.user;

import com.google.gson.reflect.TypeToken;
import model.User;
import repository.user.UserRepositoryImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class UserServiceImpl implements UserService {

    private static final UserServiceImpl instance = new UserServiceImpl();

    public static UserServiceImpl getInstance() {
        return instance;
    }

    private UserServiceImpl() {
    }

    UserRepositoryImpl userRepository = UserRepositoryImpl.getInstance();

    @Override
    public int add(User user) {
        int save = userRepository.save(user);
        if (save == 1) {
            return 1;
        }
        return -1;
    }


    @Override
    public User signIn(String username, String password) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(userPath))) {
            ArrayList<User> users = gson.fromJson(bufferedReader, new TypeToken<>() {
            });
            for (User user1 : users) {
                if (Objects.equals(user1.getUsername(), username)
                        && Objects.equals(user1.getPassword(), password)) {
                    return user1;
                }
            }
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
