package kg.megacom.apiadminservice.services.impl;

import kg.megacom.apiadminservice.exceptions.NotAdmin;
import kg.megacom.apiadminservice.exceptions.UserNotFound;
import kg.megacom.apiadminservice.microservices.login_service.LoginServiceProxy;
import kg.megacom.apiadminservice.models.User;
import kg.megacom.apiadminservice.services.SessionService;
import kg.megacom.apiadminservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SessionService sessionService;

    @Autowired
    private LoginServiceProxy loginServiceProxy;

    @Override
    public User saveUser(String token, User user) {

        User naviUser = sessionService.getUserByToken(token);

        if(naviUser.equals(null)) throw new UserNotFound("Пользователь не найден");
        if (naviUser.getRole().getId()!=1) throw new NotAdmin("Ограничено в доступе");

        user = loginServiceProxy.save(naviUser.getId(),user);
        return user;
    }

    @Override
    public User updateUser(String token, User user) {
        User naviUser = sessionService.getUserByToken(token);
        if(naviUser.equals(null)) throw new UserNotFound("Пользователь не найден");
        if (naviUser.getRole().getId()!=1) throw new NotAdmin("Ограничено в доступе");
        user = loginServiceProxy.update(naviUser.getId(),user);
        return user;
    }

    @Override
    public boolean deleteUser(String token, Long id) {
        User naviUser = sessionService.getUserByToken(token);
        if(naviUser.equals(null)) throw new UserNotFound("Пользователь не найден");
        if (naviUser.getRole().getId()!=1) throw new NotAdmin("Ограничено в доступе");
        return loginServiceProxy.delete(naviUser.getId(),id);
    }

    @Override
    public User getUserById(String token, Long id) {
        User naviUser = sessionService.getUserByToken(token);
        if(naviUser.equals(null)) throw new UserNotFound("Пользователь не найден");
        if (naviUser.getRole().getId()!=1) throw new NotAdmin("Ограничено в доступе");
        return loginServiceProxy.getById(naviUser.getId(),id);
    }

    @Override
    public List<User> getAllUsers(String token, Long id) {
        User naviUser = sessionService.getUserByToken(token);
        if(naviUser.equals(null)) throw new UserNotFound("Пользователь не найден");
        if (naviUser.getRole().getId()!=1) throw new NotAdmin("Ограничено в доступе");
        return loginServiceProxy.findAllUsers(id);
    }
}
