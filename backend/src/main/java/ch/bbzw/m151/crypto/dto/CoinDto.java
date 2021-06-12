package ch.bbzw.m151.crypto.dto;

import java.io.Serializable;

public class CoinDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private final String name;
    private final String coingeckoID;
    private final String shortname;

    private CoinDto(String name, String coingeckoID, String shortname){
        this.name = name;
        this.coingeckoID = coingeckoID;
        this.shortname = shortname;
    }

    public String getName() { return name; }
    public String getCoingeckoID() { return coingeckoID; }
    public String getShortname() { return shortname; }
}
