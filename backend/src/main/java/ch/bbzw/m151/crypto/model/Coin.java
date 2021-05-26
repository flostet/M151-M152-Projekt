package ch.bbzw.m151.crypto.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Coin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coin_sequence")
    @SequenceGenerator(allocationSize = 1, name = "coin_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private long coinId;

    @Column(nullable = false, unique = true)
    private String coinName;

    @Column(nullable = false)
    private int totalAmount;

    protected Coin() {
    }

    public Coin(final String coinName, final int totalAmount) {
        this.coinName = coinName;
        this.totalAmount = totalAmount;
    }

    public long getId() {
        return coinId;
    }

    public String getCoinName() {
        return coinName;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
