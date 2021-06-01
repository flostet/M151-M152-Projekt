package ch.bbzw.m151.crypto.model;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Wallet {
    @Id
    @SequenceGenerator(name = "wallet_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "wallet_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(nullable = false)
    private long amount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "wallet")
    private List<Trade> trades;

    @ManyToOne(optional = false)
    private User user;

    @ManyToOne(optional = false)
    private Coin coin;
}