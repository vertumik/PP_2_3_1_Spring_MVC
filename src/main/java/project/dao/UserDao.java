package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(Long id);
    User getUserById(Long id);
    List<User> listUsers();
}
