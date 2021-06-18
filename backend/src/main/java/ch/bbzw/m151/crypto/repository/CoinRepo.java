package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CoinRepo extends CrudRepository<Coin, Long> {
    @Modifying
    @Query(value = "DELETE FROM coin WHERE shortname = ?1", nativeQuery = true)
    void deleteByName(String shortname);

    @Query(value = "SELECT id FROM coin WHERE coingeckoid = ?1", nativeQuery = true)
    long getIDByName(String coingeckoID);
}
