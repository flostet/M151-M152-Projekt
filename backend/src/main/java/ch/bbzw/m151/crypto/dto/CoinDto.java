package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;

public class CoinDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int totalAmount;
    private final String coingeckoID;

    private CoinDto(String name, int totalAmount, String coingeckoID){
        this.name = name;
        this.totalAmount = totalAmount;
        this.coingeckoID = coingeckoID;
    }

    public String getName() { return name; }
    public int getTotalAmount() { return totalAmount; }
    public String getCoingeckoID() { return coingeckoID; }
}
