package crypto.controller;

import crypto.entity.Users;
import org.springframework.web.bind.annotation.GetMapping;

public class UsersController extends ControllerBase {
    @GetMapping("/login")
    public Users login() {
        return null;
    }

}
