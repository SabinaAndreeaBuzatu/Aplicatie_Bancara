package Produse;

import Client.Client;

// mie mi se pare ca un Client are un cont, nu un cont are un client
public class ContCurent extends Cont {
    protected Client client;

// who is n? foloseste cuvinte
     public ContCurent(String IBAN, String Valuta, double Sold,int n, Card[] card, String DataAcordare,Client client)
     {super(IBAN, Valuta,  Sold, n, card, DataAcordare);
     this.client=client;
         this.tipcont="Cont curent";


     }



    @Override
    public void comisionAdministrareCont() {
        this.ComisionA= 5;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
         a.append(super.toString());
         a.append(client.toString());



        return a.toString();
    }
    @Override
    public void colectareComision(){

         this.Sold=this.Sold-this.ComisionA;
    }
    }

