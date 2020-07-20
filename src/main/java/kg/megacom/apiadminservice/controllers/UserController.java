package kg.megacom.apiadminservice.controllers;

import kg.megacom.apiadminservice.models.User;
import kg.megacom.apiadminservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User saveUser(@RequestHeader String auth, @RequestBody User user){
        return userService.saveUser(auth,user);
    }

    @PutMapping("/update")
    public User update(@RequestHeader String auth,@RequestBody User user){
        return userService.updateUser(auth,user);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@RequestHeader String auth,@PathVariable Long id){
        return userService.deleteUser(auth,id);
    }

    @GetMapping("/find/{id}")
    public User getById(@RequestHeader String auth, @PathVariable Long id){
        return userService.getUserById(auth, id);
    }
    @GetMapping("/all")
    public List<User> findAllUsers(@RequestHeader String auth,@RequestParam Long naviUser){
        return userService.getAllUsers(auth,naviUser);
    }
}
