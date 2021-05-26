package ch.bbzw.m151.crypto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_sequence")
    @SequenceGenerator(allocationSize = 1, name = "wallet_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long walletId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coin_id")
    private Coin coin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false)
    private long amount;

    protected Wallet() {
    }

    public Wallet(final Coin coin, final long amount, final User user) {
        this.coin = coin;
        this.amount = amount;
        this.user = user;
    }

    public long getWalletId() { return walletId; }

    public Coin getCoin() {
        return coin;
    }

    public User getUser() {
        return user;
    }

    public long getAmount() { return amount; }
}
