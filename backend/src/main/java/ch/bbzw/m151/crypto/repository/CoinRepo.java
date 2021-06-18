package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Coin;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepo extends CrudRepository<Coin, Long> {
    @Modifying
    @Query(value = "DELETE FROM coin WHERE shortname = ?1", nativeQuery = true)
    void deleteByName(String shortname);

    @Query(value = "SELECT id FROM coin WHERE coingeckoid = ?1", nativeQuery = true)
    long getIDByName(String coingeckoID);

    @Query(value = "SELECT * FROM coin WHERE id = ?1", nativeQuery = true)
    Coin getById(long id);
}
