package repository.user;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User;
import repository.BaseRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class UserRepositoryImpl implements UserRepository {

   private static final UserRepositoryImpl instance = new UserRepositoryImpl();

   Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static UserRepositoryImpl getInstance() {
        return instance;
    }

    private UserRepositoryImpl() {
    }

    String usersPath = "C:\\Users\\User\\IdeaProjects\\Payme\\src\\recurse\\User.json";

    @Override
    public int save(User user) {
        ArrayList<User> users;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(usersPath))){
             users = gson.fromJson(bufferedReader, new TypeToken<>(){});
            for (User user1 : users) {
                if (Objects.equals(user1.getUsername(),user.getUsername())){
                  return -1;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        users.add(user);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(usersPath))){
            gson.toJson(users, bufferedWriter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

}
