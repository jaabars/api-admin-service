package kg.megacom.apiadminservice.services.impl;

import kg.megacom.apiadminservice.microservices.login_service.LoginServiceProxy;
import kg.megacom.apiadminservice.models.SessionInfo;
import kg.megacom.apiadminservice.models.User;
import kg.megacom.apiadminservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {

    @Autowired
    private LoginServiceProxy loginServiceProxy;

    @Override
    public SessionInfo auth(String login, String password) {
        return loginServiceProxy.auth(login,password);
    }

    @Override
    public User getUserByToken(String token) {
        return loginServiceProxy.checkSession(token);
    }

    @Override
    public boolean logOut(String token) {
        return loginServiceProxy.logOut(token);
    }
}
