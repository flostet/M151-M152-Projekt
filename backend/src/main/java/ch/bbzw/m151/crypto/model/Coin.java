package ch.bbzw.m151.crypto.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Coin {
    @Id
    @SequenceGenerator(name = "coin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "coin_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private long totalAmount;

    @Column(nullable = false)
    private String coingeckoID;

    protected Coin(){}

    public Coin(final String name, final long totalAmount, final String coingeckoID){
        this.name = name;
        this.totalAmount = totalAmount;
        this.coingeckoID = coingeckoID;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public long getTotalAmount() { return totalAmount; }
    public void setTotalAmount(long totalAmount) { this.totalAmount = totalAmount; }
    public String getCoingeckoID() { return coingeckoID; }
    public void setCoingeckoID(String coingeckoID) { this.coingeckoID = coingeckoID; }

}