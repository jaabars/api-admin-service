package kg.megacom.apiadminservice.controllers;

import kg.megacom.apiadminservice.models.SessionInfo;
import kg.megacom.apiadminservice.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class LoginController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/login")
    public SessionInfo auth (@RequestParam String login, @RequestParam String password){
        return sessionService.auth(login,password);
    }

    @GetMapping("/out")
    public boolean logOut(@RequestHeader("auth") String auth){
        return sessionService.logOut(auth);
    }

}
