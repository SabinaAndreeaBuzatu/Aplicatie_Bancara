package produse;

import client.Client;

public class ContCurent extends Cont {
    protected String CNP;

    public ContCurent() {
    }

    public ContCurent(String IBAN, String Valuta, double Sold, int n, Card[] card, String DataAcordare, String CNP) {
        super(IBAN, Valuta, Sold, n, card, DataAcordare);
        this.CNP=CNP;
        this.tipcont = "Cont curent";


    }


    @Override
    public void comisionAdministrareCont() {
        this.ComisionA = 5;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append(super.toString());
        a.append("Contul apartine clientului cu CNP: "+CNP);


        return a.toString();
    }

    @Override
    public void setIBANcontc(String c) {

    }

    public String getCNP() {
        return CNP;
    }

    public void setcnp(String CNP) {
       this.CNP=CNP;

    }


}

