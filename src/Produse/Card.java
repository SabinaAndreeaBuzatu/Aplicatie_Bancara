package Produse;

import java.util.Objects;

public class Card {
    protected String NrCard;
    protected String Pin;
    protected String CVV;
    protected String DataExp;


    public Card (String NrCard, String Pin , String CVV, String DataExp)
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
    public String getCVV() {
        return CVV;
    }
    public String getPin() {
        return Pin;
    }
    public void setNrCard(String NrCard) {
        this.NrCard = NrCard;
    }

    public void setDataExp(String DataExp) {
        this.DataExp = DataExp;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
    public void setPin(String Pin) {
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
