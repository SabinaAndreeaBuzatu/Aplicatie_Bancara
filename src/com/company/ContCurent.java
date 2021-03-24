package com.company;

public class ContCurent extends Cont {
    protected Client client;


     public ContCurent(String IBAN, String Valuta, double Sold,int n, Card[] card, String DataAcordare,Client client)
     {super(IBAN, Valuta,  Sold, n, card, DataAcordare);
     this.client=client;

     }

    @Override
    public double comisionAdministrareCont() {
        return 5;
    }
}
