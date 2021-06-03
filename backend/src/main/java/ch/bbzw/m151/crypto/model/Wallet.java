package ch.bbzw.m151.crypto.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
public class Wallet {
    @Id
    @SequenceGenerator(name = "wallet_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column(nullable = false)
    private long amount;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Coin coin;

    public long getId() {
        return id;
    }
    public long getAmount() { return amount; }
    public void setAmount(long amount) {
        this.amount = amount;
    }
    public User getUser() { return user; }
    public void setUser(User user) {
        this.user = user;
    }
    public Coin getCoin() { return coin; }
    public void setCoin(Coin coin) {
        this.coin = coin;
    }
}