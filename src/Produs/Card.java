package Produs;

import java.util.Objects;

public class Card {
    protected String NrCard;
    protected int Pin;
    protected int CVV;
    protected String DataExp;


    public Card (String NrCard, int Pin , int CVV, String DataExp)
    {
        this.NrCard=NrCard;
        this.Pin=Pin;
        this.CVV=CVV;
        this.DataExp=DataExp;

    }

    //set/get
    public String getNrCard()
    {
        return NrCard;
    }

    public String getDataExp()
    {
        return DataExp;
    }
    public int getCVV() {
        return CVV;
    }
    public int getPin() {
        return Pin;
    }
    public void setNrCard(String NrCard) {
        this.NrCard = NrCard;
    }

    public void setDataExp(String DataExp) {
        this.DataExp = DataExp;
    }
    public void setCVV(int CVV) {
        this.CVV = CVV;
    }
    public void setPin(int Pin) {
        this.Pin = Pin;
    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("Numarul cardului " + this.NrCard + ", Pin " +Pin +",CVV "+CVV+", Data expirarii "+ DataExp);
        return a.toString();}

    @Override
    public boolean equals(Object obj) {
        if(this!=obj)
            return false;
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Card c =(Card) obj;

        if(!Objects.equals(this.NrCard, c.NrCard))
            return false;
        if(!Objects.equals(this.DataExp, c.DataExp))
            return false;
        if(this.Pin!= c.Pin)
            return false;
        if(this.CVV!= c.CVV)
            return false;
        return true;
    }

}
