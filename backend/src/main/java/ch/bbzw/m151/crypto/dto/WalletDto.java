package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;

public class WalletDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final long id;
    private final long coinId;
    private final long userId;
    private final long coinamount;
    private final long investedamount;

    public WalletDto(long id, long coin, long user, long coinamount, long investedamount){
        this.id = id;
        this.coinamount = coinamount;
        this.coinId = coin;
        this.userId = user;
        this.investedamount = investedamount;
    }

    public long getId() { return id; }
    public long getCoinId() { return coinId; }
    public long getUserId() { return userId; }
    public long getInvestedamountmount() { return investedamount; }
    public long getCoinamount() { return coinamount; }
}
