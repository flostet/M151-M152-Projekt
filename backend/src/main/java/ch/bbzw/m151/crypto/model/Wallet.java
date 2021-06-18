package ch.bbzw.m151.crypto.model;

import javax.persistence.*;

@Entity
public class Wallet {
    @Id
    @SequenceGenerator(name = "wallet_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Coin coin;

    @Column(columnDefinition = "bigint default 0")
    private long coinamount;

    @Column(columnDefinition = "bigint default 0")
    private long investedamount;

    public long getId() {
        return id;
    }
    public User getUser() { return user; }
    public void setUser(User user) {
        this.user = user;
    }
    public Coin getCoin() { return coin; }
    public void setCoin(Coin coin) {
        this.coin = coin;
    }
    public long getCoinamount() { return coinamount; }
    public void setCoinamount(long amount) {this.coinamount = amount; }
    public long getInvestedamount() { return investedamount; }
    public void setInvestedamount(long amount) { this.investedamount = amount; }
}