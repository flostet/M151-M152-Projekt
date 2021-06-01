package ch.bbzw.m151.crypto.repository;

import ch.bbzw.m151.crypto.model.Wallet;
import org.springframework.data.repository.CrudRepository;

public interface WalletRepo extends CrudRepository<Wallet, Long> {
}
