package kg.megacom.apiadminservice.microservices.login_service;

import kg.megacom.apiadminservice.models.SessionInfo;
import kg.megacom.apiadminservice.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(url = "${microservice.login-service-url}", value = "${microservice.login-service-name}")
public interface LoginServiceProxy {

    @GetMapping("/v1/session/auth")
    SessionInfo auth(@RequestParam String login, @RequestParam String password);

    @PostMapping("/v1/user/save")
    User save(@RequestParam Long naviUser, @RequestBody User userDto);

    @GetMapping("/v1/session/check")
    User checkSession(@RequestParam String token);

    @PutMapping("/v1/user/update")
    User update(@RequestParam Long naviUser, @RequestBody User user);

    @DeleteMapping("/v1/user/delete/{id}")
    boolean delete(@RequestParam Long naviUser, @PathVariable Long id);

    @GetMapping("/v1/user/find/{id}")
    User getById(@RequestParam Long naviUser, @PathVariable Long id);

    @GetMapping("/v1/user/all")
    List<User> findAllUsers(@RequestParam Long naviUser);

    @GetMapping("/v1/session/out")
    boolean logOut(@RequestHeader("auth") String auth);
}