package ch.bbzw.m151.crypto.service;

import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.model.Wallet;
import ch.bbzw.m151.crypto.dto.WalletDto;
import ch.bbzw.m151.crypto.repository.WalletRepo;
import ch.bbzw.m151.crypto.repository.CoinRepo;
import ch.bbzw.m151.crypto.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class WalletService {
    private final UserRepo userRepo;
    private final WalletRepo walletRepo;
    private final CoinRepo coinRepo;

    @Autowired
    public WalletService(UserRepo userRepo, WalletRepo walletRepo, CoinRepo coinRepo){
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
        this.coinRepo = coinRepo;
    }

    @Transactional
    public Wallet add(final WalletDto walletDto){
        Wallet wallet = new Wallet();
        wallet.setCoin(coinRepo.findById(walletDto.getCoinId()).orElseThrow());
        wallet.setUser(userRepo.findById(walletDto.getUserId()).orElseThrow());
        return walletRepo.save(wallet);
    }

    @Transactional
    public void delete(final long id) { walletRepo.deleteById(id); }

    @Transactional(readOnly = true)
    public Optional<Wallet> getbyId(final long id) { return walletRepo.findById(id);}

    @Transactional(readOnly = true)
    public List<Wallet> getAll() {
        Iterable<Wallet> wallets = walletRepo.findAll();
        return StreamSupport
                .stream(wallets.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Wallet> getByUser(final String name) { return walletRepo.getByUser(name); }
}