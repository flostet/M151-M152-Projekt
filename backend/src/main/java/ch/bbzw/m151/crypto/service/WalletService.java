package ch.bbzw.m151.crypto.service;

import ch.bbzw.m151.crypto.model.User;
import ch.bbzw.m151.crypto.model.Wallet;
import ch.bbzw.m151.crypto.repository.WalletRepo;
import ch.bbzw.m151.crypto.repository.UserRepo;
import ch.bbzw.m151.crypto.repository.CoinRepo;
import ch.bbzw.m151.crypto.dto.WalletDto;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
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
        wallet.setAmount(walletDto.getAmount());
        wallet.setCoin(coinRepo.findById(walletDto.getCoinId()).orElseThrow());
        wallet.setUser(userRepo.findById(walletDto.getUserId()).orElseThrow());
        return walletRepo.save(wallet);
    }

    @Transactional
    public void delete(final long id) { walletRepo.deleteById(id); }

    @Transactional(readOnly = true)
    public Optional<Wallet> getById(final long id) { return walletRepo.findById(id);}

}