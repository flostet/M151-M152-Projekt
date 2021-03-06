package ch.bbzw.m151.crypto.service;

import ch.bbzw.m151.crypto.model.UserGroup;
import ch.bbzw.m151.crypto.model.User;
import ch.bbzw.m151.crypto.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Transactional(readOnly = true)
    public Optional<UserGroup> login(final String name, final String password) {
        User user = userRepo.checkPassword(name, password);
        return Optional.of(user.getUserGroup());
    }

    @Transactional
    public User register(final User user) {
        user.setUserGroup(UserGroup.USER);
        return userRepo.save(user);
    }

    public User getByName(final String name) { return userRepo.getByName(name); }

    public long getIdByName(final String name) { return userRepo.getIdByName(name); }
}
