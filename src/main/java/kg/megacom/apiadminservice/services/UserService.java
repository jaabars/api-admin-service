package kg.megacom.apiadminservice.services;

import kg.megacom.apiadminservice.models.User;

import java.util.List;

public interface UserService {

    User saveUser(String token, User user);
    User updateUser(String token, User user);
    boolean deleteUser(String token,Long id);
    User getUserById(String token, Long id);
    List<User> getAllUsers(String token, Long id);
}
