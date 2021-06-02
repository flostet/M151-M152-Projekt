package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;

public class TradeDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final long fiatAmount;
    private final long tokenAmount;
    private final long walletId;
    private final long coinId;

    private TradeDto(long fiatAmount, long tokenAmount, long walletId, long coinId){
        this.fiatAmount = fiatAmount;
        this.tokenAmount = tokenAmount;
        this.walletId = walletId;
        this.coinId = coinId;
    }

    public long getFiatAmount() { return fiatAmount; }
    public long getTokenAmount() { return tokenAmount; }
    public long getWalletId() { return walletId; }
    public long getCoinId() { return coinId; }
}