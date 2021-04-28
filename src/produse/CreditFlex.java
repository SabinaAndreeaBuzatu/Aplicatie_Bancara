package produse;

import client.Client;

public class CreditFlex extends Credit {



    public CreditFlex( String IBAN, String Valuta, double Sold, int n, Card[] card, int durataluni, String DataAcordare, double SumaAcordata,ContCurent contc) {
        super(IBAN, Valuta, Sold, n, card, durataluni, DataAcordare, SumaAcordata,contc);
        dobanda();
        calcrata();

        this.tipcont="Credit cu dobanda variabila";
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
    @Override
    public void setClient(Client c) {
    }
    @Override
    public void setContCurent(ContCurent contc)
    {
        this.contc.setIBAN(contc.getIBAN());
        this.contc.setSold(contc.getSold());
        this.contc.setValuta(contc.getValuta());
        this.contc.setDataAcordare(contc.getDataAcordare());

    }


}

