package produse;

import client.Client;

public class CreditFlex extends Credit {



    public CreditFlex( String IBAN, String Valuta, double Sold, int n, Card[] card, int durataluni, String DataAcordare, double SumaAcordata,String IBANcontc) {
        super(IBAN, Valuta, Sold, n, card, durataluni, DataAcordare, SumaAcordata,IBANcontc);
        dobanda();
        calcrata();

        this.tipcont="Credit cu dobanda variabila";
    }

    public CreditFlex() {

    }

    @Override
    public void setIBANcontc(String contc)
    {
        this.IBANcontc=contc;


    }
    @Override
    public void comisionAdministrareCont() {
        this.ComisionA = 0.01 * Sold;

    }
    @Override
    public void dobanda() {
    valori.calcrobor();  valorib.marja();
         this.dobanda=Math.round(valori.getrobor()+valorib.getMarjaCredit()*100)/100.0;



    }



}

