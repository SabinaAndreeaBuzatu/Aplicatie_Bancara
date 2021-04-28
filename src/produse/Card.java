package produse;

import java.util.Objects;

public class Card {
    protected String nrCard;
    protected String pin;
    protected String CVV;
    protected String DataExp;

    public Card(){}
    public Card (String nrCard, String pin , String CVV, String DataExp)
    {
        this.nrCard=nrCard;
        this.pin=pin;
        this.CVV=CVV;
        this.DataExp=DataExp;

    }

    //set/get
    public String getNrCard()
    {
        return nrCard;
    }

    public String getDataExp()
    {
        return DataExp;
    }
    public String getCVV() {
        return CVV;
    }
    public String getPin() {
        return pin;
    }
    public void setNrCard(String nrCard) {
        this.nrCard = nrCard;
    }

    public void setDataExp(String DataExp) {
        this.DataExp = DataExp;
    }
    public void setCVV(String CVV) {
        this.CVV = CVV;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("Numarul cardului " + this.nrCard + ", pin " +pin +",CVV "+CVV+", Data expirarii "+ DataExp);
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

        if(!Objects.equals(this.nrCard, c.nrCard))
            return false;
        if(!Objects.equals(this.DataExp, c.DataExp))
            return false;
        if(this.pin!= c.pin)
            return false;
        if(this.CVV!= c.CVV)
            return false;
        return true;
    }

}
