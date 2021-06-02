package ch.bbzw.m151.crypto.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Trade {
    @Id
    @SequenceGenerator(name = "trade_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private long fiatAmount;

    @Column(nullable = false)
    private long tokenAmount;

    @ManyToOne(optional = false)
    private Wallet wallet;

    @ManyToOne(optional = false)
    private Coin coin;

    public long getFiatAmount() { return fiatAmount; }
    public void setFiatAmount(long fiatAmount) { this.fiatAmount = fiatAmount; }
    public long getTokenAmount() { return tokenAmount; }
    public void setTokenAmount(long tokenAmount) { this.tokenAmount = tokenAmount; }
    public Wallet getWallet() { return wallet; }
    public void setWallet(Wallet wallet) { this.wallet = wallet; }
    public Coin getCoin() { return coin; }
    public void setCoin(Coin coin) { this.coin = coin; }
}