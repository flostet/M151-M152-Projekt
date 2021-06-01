package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String name, String password);
}