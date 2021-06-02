package ch.bbzw.m151.crypto.service;

import ch.bbzw.m151.crypto.model.Coin;
import ch.bbzw.m151.crypto.model.Trade;
import ch.bbzw.m151.crypto.dto.TradeDto;
import ch.bbzw.m151.crypto.repository.TradeRepo;
import ch.bbzw.m151.crypto.repository.WalletRepo;
import ch.bbzw.m151.crypto.repository.CoinRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TradeService {
    private final TradeRepo tradeRepo;
    private final WalletRepo walletRepo;
    private final CoinRepo coinRepo;

    @Autowired
    public TradeService(TradeRepo tradeRepo, WalletRepo walletRepo, CoinRepo coinRepo){
        this.tradeRepo = tradeRepo;
        this.walletRepo = walletRepo;
        this.coinRepo = coinRepo;
    }

    @Transactional
    public Trade add(final TradeDto tradeDto){
        Trade trade = new Trade();
        trade.setFiatAmount(tradeDto.getFiatAmount());
        trade.setTokenAmount(tradeDto.getTokenAmount());
        trade.setWallet(walletRepo.findById(tradeDto.getWalletId()).orElseThrow());
        trade.setCoin(coinRepo.findById(tradeDto.getCoinId()).orElseThrow());
        return tradeRepo.save(trade);
    }

    @Transactional
    public void delete(final long id) { tradeRepo.deleteById(id); }

    @Transactional(readOnly = true)
    public Optional<Trade> getbyId(final long id) { return tradeRepo.findById(id);}
}