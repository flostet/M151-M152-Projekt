package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.User;
import ch.bbzw.m151.crypto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public User getByName(@PathVariable final String name) { return userService.getByName(name); }

    @GetMapping("/id/{name}")
    public long getIdByName(@PathVariable final String name) { return userService.getIdByName(name); }
}