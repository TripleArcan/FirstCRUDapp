package web.servise;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    public void addUser(User user);

}
