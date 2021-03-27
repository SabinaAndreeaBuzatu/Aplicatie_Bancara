package com.company;

import GenerareValori.BNRval;
import ServiciiBancare.*;
import Produs.*;


public class service {


    public service(){}
    public void CreareContCurent(){}
    public void CreareDepozit(){}
    public void CreareCreditFix(){}
    public void CreareCreditFlex(){}
    public void CreareInchiriereCutieValori(){}
    public void CreareExtras(){}
    public void CreareClinent(){}
    public void CreareCard(){}
    public Transfer transfer(Cont sursa, Cont destinatie , String DataTranzactie, String mesaj, double suma)  {
        Pair<Cont> p =new Pair<>(sursa,destinatie);
        if (sursa.getValuta().equals(destinatie.getValuta())) {
            {  Transfer t=new Transfer(p,DataTranzactie,mesaj,suma);
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
        SchimbValutar t = new SchimbValutar(p, DataTranzactie, mesaj, suma);
        String[] valuta = {"RON", "EURO", "USD", "GBP"};
        double[][] val = {{1, b.getEuro(), b.getUsd(), b.getgbp()}, {1 / b.getEuro(), 1, b.getEuro() / b.getUsd(), b.getEuro() / b.getgbp()}, {1 / b.getUsd(), b.getUsd() / b.getEuro(), 1, b.getUsd() / b.getgbp()}, {1 / b.getgbp(), b.getgbp() / b.getEuro(), b.getgbp() / b.getUsd(), 1}};
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
