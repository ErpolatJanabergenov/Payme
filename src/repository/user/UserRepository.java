package repository.user;

import model.User;
import repository.BaseRepository;

public interface UserRepository extends BaseRepository<User> {

    int save(User user);
}
