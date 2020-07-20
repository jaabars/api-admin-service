package kg.megacom.apiadminservice.services;

import kg.megacom.apiadminservice.models.SessionInfo;
import kg.megacom.apiadminservice.models.User;

public interface SessionService {
    SessionInfo auth (String login, String password);
    User getUserByToken(String token);
    boolean logOut(String token);
}
