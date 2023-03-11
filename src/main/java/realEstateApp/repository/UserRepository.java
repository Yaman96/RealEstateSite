package realEstateApp.repository;

import realEstateApp.model.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();
    User findById(long id);
    void save(User user);
    void delete(User user);

}
