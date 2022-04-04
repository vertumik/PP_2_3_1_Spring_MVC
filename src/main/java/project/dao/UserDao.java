package project.dao;

import project.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(User user);
    void removeUser(User user);
    User getUserById(int id);
    List<User> listUser();
}
