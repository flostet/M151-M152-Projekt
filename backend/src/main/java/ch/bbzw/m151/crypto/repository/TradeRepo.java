package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Trade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TradeRepo extends CrudRepository<Trade, Long> {
    @Query(value = "select * from Trade where wallet_id = ?1", nativeQuery = true)
    List<Trade> findTradesByWallet(long wallet_id);
}