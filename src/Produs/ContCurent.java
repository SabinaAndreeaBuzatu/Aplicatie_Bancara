package Produs;

import Client.Client;

public class ContCurent extends Cont {
    protected Client client;


     public ContCurent(String IBAN, String Valuta, double Sold,int n, Card[] card, String DataAcordare,Client client)
     {super(IBAN, Valuta,  Sold, n, card, DataAcordare);
     this.client=client;
         this.tipcont="Cont curent";

     }



    @Override
    public double comisionAdministrareCont() {
        return 5;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
         a.append(super.toString());
         a.append(client.toString());



        return a.toString();
    }
    }

