package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Wallet;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WalletRepo extends CrudRepository<Wallet, Long> {
    @Query(value = "SELECT * FROM Wallet WHERE user_id = (SELECT id FROM crypto_user WHERE name = :name )", nativeQuery = true)
    public List<Wallet> getByUser(@Param("name") final String name);

    @Modifying
    @Query(value = "DELETE FROM Wallet WHERE coin_id = ?1", nativeQuery = true)
    void deleteWithId(long coinid);
}