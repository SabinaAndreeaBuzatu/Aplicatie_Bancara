package com.company;

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
        Transfer t=new Transfer();
        if (sursa.getValuta().equals(destinatie.getValuta())) {
            {  t=new Transfer(p,DataTranzactie,mesaj,suma);
            sursa.setSold( sursa.getSold()- suma);
                destinatie.setSold( destinatie.getSold()+ suma);
            return t;}
    }
        else
        {
            System.out.println("Contul sursa are valuta " + sursa.getValuta() + " iar contul destinatie are valuta " + destinatie.getValuta() + ". Nu se poate efectua transferul.");
            return t;}



    }
 /*   public SchimbValutar SchimbValutar(Cont sursa, Cont destinatie , String DataTranzactie, String mesaj, double suma)  {
        BNRval b=new BNRval();
        Pair<Cont> p =new Pair<>(sursa,destinatie);
        SchimbValutar t=new SchimbValutar(p,DataTranzactie,mesaj,suma);

        return t;

        }*/






     public Alimentare alimentare(Cont cont,String DataTranzactie, String mesaj, double suma)
     {
         cont.setSold( cont.getSold()+ suma);
         Alimentare a = new Alimentare(cont, DataTranzactie, mesaj,  suma);
         return a;
     }
    public Retragere Retragere(Cont cont, String DataTranzactie, String mesaj, double suma)
    {  /////if
        cont.setSold( cont.getSold()- suma);
        Retragere a = new Retragere(cont, DataTranzactie, mesaj,  suma);
        return a;
    }
////ultimul curs
    ////java.dot.lang exception

}
