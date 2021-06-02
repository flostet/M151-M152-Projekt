package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;

public class CoinDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final String name;
    private final long totalAmount;
    private final String coingeckoID;

    private CoinDto(String name, long totalAmount, String coingeckoID){
        this.name = name;
        this.totalAmount = totalAmount;
        this.coingeckoID = coingeckoID;
    }

    public String getName() { return name; }
    public long getTotalAmount() { return totalAmount; }
    public String getCoingeckoID() { return coingeckoID; }
}
