package crypto.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class UsersController extends ControllerBase {
    @GetMapping("/login")
    public String login() {
        return "Hello World";
    }

}
