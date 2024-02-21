package web.servise;

import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    public void addUser(User user);

    void deleteUser(Long id);

    @Transactional
    User getUserById(Long id);

    void updateUser(User user);
}
