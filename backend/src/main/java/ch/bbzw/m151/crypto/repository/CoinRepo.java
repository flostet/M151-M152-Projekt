package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoinRepo extends CrudRepository<Coin, Long> {
    @Query(value = "DELETE FROM coin WHERE shortname = ?1", nativeQuery = true)
    Coin deleteByName(String name);
}
