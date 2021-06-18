package ch.bbzw.m151.crypto.service;

import ch.bbzw.m151.crypto.dto.CoinDto;
import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.repository.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CoinService {
    private final CoinRepo coinRepo;

    @Autowired
    public CoinService(CoinRepo coinRepo){
        this.coinRepo = coinRepo;
    }

    @Transactional
    public Coin add(final CoinDto coinDto){
        Coin coin = new Coin(coinDto.getName(), coinDto.getCoingeckoID(), coinDto.getShortname());
        return coinRepo.save(coin);
    }

    @Transactional
    public void delete(final String name) { coinRepo.deleteByName(name); }

    @Transactional(readOnly = true)
    public Optional<Coin> getbyId(final long id) { return coinRepo.findById(id);}

    @Transactional(readOnly = true)
    public List<Coin> getAll() {
        Iterable<Coin> coins = coinRepo.findAll();
        return StreamSupport
                .stream(coins.spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public long getIDByName(final String coingeckoid) { return coinRepo.getIDByName(coingeckoid); }
}