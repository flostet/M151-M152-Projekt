package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.model.User;
import ch.bbzw.m151.crypto.dto.UserDto;
import ch.bbzw.m151.crypto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
//@PreAuthorize("hasAuthority('USER') or hasAuthority('ADMIN')")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{name}")
    public User getByName(@PathVariable final String name) { return userService.getByName(name); }
}