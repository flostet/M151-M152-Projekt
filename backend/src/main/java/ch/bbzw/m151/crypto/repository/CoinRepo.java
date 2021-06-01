package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepo extends CrudRepository<Coin, Long> {
}
