package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User checkPassword(String name, String password);

    @Query(value = "SELECT * FROM crypto_user WHERE name = ?1", nativeQuery = true)
    User getByName(String name);

    @Query(value = "SELECT * FROM crypto_user WHERE id = ?1", nativeQuery = true)
    User getById(long id);

    @Query(value = "SELECT id FROM crypto_user WHERE name = ?1", nativeQuery = true)
    long getIdByName(String name);
}