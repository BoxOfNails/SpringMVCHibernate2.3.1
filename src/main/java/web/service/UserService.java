package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
