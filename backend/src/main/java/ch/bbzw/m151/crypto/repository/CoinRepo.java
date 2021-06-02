package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Coin;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CoinRepo extends CrudRepository<Coin, Long> {
    public List<Coin> searchByName(String s);
}
