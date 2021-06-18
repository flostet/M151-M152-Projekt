package ch.bbzw.m151.crypto.controller;

import ch.bbzw.m151.crypto.auth.PgAuthenticationProvider;
import ch.bbzw.m151.crypto.dto.UserDto;
import ch.bbzw.m151.crypto.model.User;
import ch.bbzw.m151.crypto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private final UserService userService;
    private final PgAuthenticationProvider authenticationProvider;

    @Autowired
    public AuthController(UserService userService, PgAuthenticationProvider authenticationProvider) {
        this.userService = userService;
        this.authenticationProvider = authenticationProvider;
    }

    @PostMapping("/register")
    public User register(@RequestBody final User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public void login(@RequestBody final UserDto loginRequest){
        final Authentication authentication = authenticationProvider.login(loginRequest);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }


    @GetMapping("/info")
    public Authentication getInfo() {
        final SecurityContext context = SecurityContextHolder.getContext();
        return context.getAuthentication();
    }
}