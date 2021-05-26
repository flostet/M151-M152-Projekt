package ch.bbzw.m151.crypto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Trades {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trade_sequence")
    @SequenceGenerator(allocationSize = 1, name = "trade_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long tradeId;

    @Column(nullable = false)
    private long fiatAmount;

    @Column(nullable = false)
    private long tokenAmount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coin_id")
    private Coin coin;

    protected Trades() {
    }

    public Trades(final long fiatAmount, final long tokenAmount, final Wallet wallet, final Coin coin) {
        this.fiatAmount = fiatAmount;
        this.tokenAmount = tokenAmount;
        this.wallet = wallet;
        this.coin = coin;
    }

    public long getTradeId() { return tradeId; }

    public long getFiatAmount() {
        return fiatAmount;
    }

    public long getTokenAmount() {
        return tokenAmount;
    }

    public Wallet getWallet() { return wallet; }

    public Coin getCoin() { return coin; }
}
