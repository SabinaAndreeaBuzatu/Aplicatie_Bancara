package com.company;

import Client.Client;
import GenerareValori.BNRval;
import ServiciiBancare.*;
import Produs.*;


public class service {


    public service(){}
//    public void CreareContCurent(String IBAN, String Valuta, double Sold, int n, Card[] card, String DataAcordare, Client client)
//    public void CreareDepozit(){}
//    public void CreareCreditFix(){}
//    public void CreareCreditFlex(){}
//    public void CreareInchiriereCutieValori(){}
//    public void CreareExtras(){}
//    public void CreareClinent(){}
//    public void CreareCard(){}
    public Transfer transfer(Cont sursa, Cont destinatie , String DataTranzactie, String mesaj, double suma)  {
        Pair<Cont> p =new Pair<>(sursa,destinatie);
        Transfer t=new Transfer();
        if (t.egalitatevaluta()) {
            {  t=new Transfer(sursa,destinatie,DataTranzactie,mesaj,suma);
            sursa.setSold( sursa.getSold()- suma);
                destinatie.setSold( destinatie.getSold()+ suma);
            return t;}
    }
        else
        {

            System.out.println("Contul sursa are valuta " + sursa.getValuta() + " iar contul destinatie are valuta " + destinatie.getValuta() + ". Nu se poate efectua transferul.");}
        return null;

    }
    public SchimbValutar SchimbValutar(Cont sursa, Cont destinatie , String DataTranzactie, String mesaj, double suma) {
        BNRval b = new BNRval();
       String s =sursa.getValuta();
        String d =destinatie.getValuta();
        int indexsursa=0;
        int indexdestinatie=0;
        Pair<Cont> p = new Pair<>(sursa, destinatie);
        SchimbValutar t = new SchimbValutar(sursa,destinatie, DataTranzactie, mesaj, suma);
        String[] valuta = {"RON", "EURO", "USD", "GBP","CHF","RUB"};
        double[][] val = {{1, b.getEuro(), b.getUsd(), b.getgbp(),b.getchf(),b.getrub()}, {1 / b.getEuro(), 1, b.getEuro() / b.getUsd(), b.getEuro() / b.getgbp(),b.getEuro() / b.getchf(),b.getEuro() / b.getrub()}, {1 / b.getUsd(), b.getUsd() / b.getEuro(), 1, b.getUsd() / b.getgbp(), b.getUsd() / b.getchf(),b.getUsd() / b.getrub()}, {1 / b.getgbp(), b.getgbp() / b.getEuro(), b.getgbp() / b.getUsd(), 1,b.getgbp() / b.getchf(),b.getgbp() / b.getrub()},{1 / b.getchf(), b.getchf() / b.getEuro(), b.getchf() / b.getUsd(), b.getchf() / b.getgbp(),1, b.getchf() / b.getrub()},{1 / b.getrub(), b.getrub() / b.getEuro(), b.getrub() / b.getUsd(), b.getrub() / b.getgbp(), b.getrub() / b.getchf(),1}};
        for (int i=0;i<4;i++)
            if(s.equals(valuta[i]))
                indexsursa=i;
                else if(d.equals(valuta[i]))
                    indexdestinatie=i;
                sursa.setSold(sursa.getSold()-suma);
                destinatie.setSold(destinatie.getSold()+val[indexsursa][indexdestinatie]*suma);
        for (int i=0;i<4;i++)
            for (int j=0;j<4;j++)
            System.out.println(val[i][j]);
            return t;

    }

     public Alimentare alimentare(Cont cont,String DataTranzactie, String mesaj, double suma)
     {
         cont.setSold( cont.getSold()+ suma);
         Alimentare a = new Alimentare(cont, DataTranzactie, mesaj,  suma);
         return a;
     }
    public Retragere Retragere(Cont cont, String DataTranzactie, String mesaj, double suma)
    {  if(cont.getSold()>=suma)
    { cont.setSold( cont.getSold()- suma);
        Retragere a = new Retragere(cont, DataTranzactie, mesaj,  suma);
        return a;}
        else {     System.out.println("Fonduri insuficiente");

            return null;

        }

    }


}
