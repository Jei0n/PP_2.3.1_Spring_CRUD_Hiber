package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    void delete(int id);

    //void edit(User user);
    User findUser(int id);
    public void updateUser(User user);
}
