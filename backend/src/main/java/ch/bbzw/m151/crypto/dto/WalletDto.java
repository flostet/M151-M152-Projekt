package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;
import java.util.List;

public class WalletDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final long id;
    private final long coinId;
    private final long userId;
    private final long amount;

    public WalletDto(long id, long coin, long user, long amount){
        this.id = id;
        this.coinId = coin;
        this.userId = user;
        this.amount = amount;
    }

    public long getId() { return id; }
    public long getCoinId() { return coinId; }
    public long getUserId() { return userId; }
    public long getAmount() { return amount; }
}
