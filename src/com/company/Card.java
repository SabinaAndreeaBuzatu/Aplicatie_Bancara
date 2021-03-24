package com.company;

public class Card {
    protected String NrCard;
    protected int Pin;
    protected int CVV;
    protected String DataExp;
    static protected int nrc;

    public Card (String NrCard, int Pin , int CVV, String DataExp)
    {   nrc+=1;
        this.NrCard=NrCard;
        this.Pin=Pin;
        this.CVV=CVV;
        this.DataExp=DataExp;

    }

    //set/get


}
