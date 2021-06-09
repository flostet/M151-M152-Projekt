package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Wallet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WalletRepo extends CrudRepository<Wallet, Long> {
    @Query(value = "select * from Wallet where user_id = ?1", nativeQuery = true)
    List<Wallet> getByUser(final long id);
}