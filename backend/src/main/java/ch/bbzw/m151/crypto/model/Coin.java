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

    @Column()
    private String name;

    @Column()
    private String coingeckoID;

    @Column()
    private String shortname;

    protected Coin(){}

    public Coin(final String name, final String coingeckoID, final String shortname){
        this.name = name;
        this.coingeckoID = coingeckoID;
        this.shortname = shortname;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCoingeckoID() { return coingeckoID; }
    public void setCoingeckoID(String coingeckoID) { this.coingeckoID = coingeckoID; }
    public String getShortname() { return shortname; }
    public void setShortname(String shortname) { this.shortname = shortname; }

}