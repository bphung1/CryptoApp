package crypto.controller;

import crypto.dto.LoginParam;
import crypto.entity.User;
import org.springframework.web.bind.annotation.*;

public class UsersController extends ControllerBase {

    @PostMapping("/login")
    public User login(@RequestBody LoginParam param) {
        return null;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return null;
    }

    @PutMapping("/user/update/{userId}")
    public User updateUser(@PathVariable int userId, @RequestBody LoginParam param) {
        return null;
    }

    @DeleteMapping("/user/delete/{userId}")
    public User deleteUser(@PathVariable int userId) {
        return null;
    }

}
