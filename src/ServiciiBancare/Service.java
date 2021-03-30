package ServiciiBancare;

import GenerareValori.BNRval;

import Produse.*;


public class Service {


    public Service(){}
    public void NullException(Transfer t)
    {
        try{System.out.println(t.toString());}
        catch(NullPointerException e){ System.out.println("\nTransferul este invalid");

        }
    }
    public void NullException(SchimbValutar t)
    {
        try{System.out.println(t.toString());}
        catch(NullPointerException e){ System.out.println("\nSchimbul valutar este invalid");

        }
    }

    public Transfer transfer(Cont sursa, Cont destinatie , String DataTranzactie, String mesaj, double suma)  {

        Transfer t =new Transfer(sursa,destinatie,DataTranzactie,mesaj,suma);;

        if (t.egalitatevaluta()) {
            {  t=new Transfer(sursa,destinatie,DataTranzactie,mesaj,suma);
               if(sursa.getSold()>= suma)
               {sursa.setSold( sursa.getSold()- suma);
                destinatie.setSold( destinatie.getSold()+ suma);
                sursa.adtranz(t);
                destinatie.adtranz(t);
            return t;}
            else {System.out.println("\nFonduri insuficiente ");
            return null;}}
    }
        else
        {

            System.out.println("\nContul sursa are valuta " + sursa.getValuta() + " iar contul destinatie are valuta " + destinatie.getValuta()+". Nu se poate efectua transferul." );


            return null;}

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
        if(sursa.getSold()>= suma)
        { for (int i=0;i<4;i++)
            if(s.equals(valuta[i]))
                indexsursa=i;
                else if(d.equals(valuta[i]))
                    indexdestinatie=i;
                sursa.setSold(sursa.getSold()-suma);
                destinatie.setSold(destinatie.getSold()+val[indexsursa][indexdestinatie]*suma);
                t.sumaTrans=val[indexsursa][indexdestinatie]*suma;
        sursa.adtranz(t);
        destinatie.adtranz(t);
            return t;}
        else {System.out.println("Fonduri insuficiente");
                return null;}

    }

     public Alimentare alimentare(Cont cont,String DataTranzactie, String mesaj, double suma)
     {
         cont.setSold( cont.getSold()+ suma);
         Alimentare a = new Alimentare(cont, DataTranzactie, mesaj,  suma);
         cont.adtranz(a);
         return a;
     }
    public Retragere Retragere(Cont cont, String DataTranzactie, String mesaj, double suma)
    {  if(cont.getSold()>=suma)
    { cont.setSold( cont.getSold()- suma);
        Retragere a = new Retragere(cont, DataTranzactie, mesaj,  suma);
        cont.adtranz(a);
        return a;}
        else {     System.out.println("Fonduri insuficiente");

            return null;

        }

    }
    public void AdaugareValori(InchiriereCutieValori c, double valoare)
    {
        c.setPragValoriDeclarat(c.getPragValoriDeclarat()+valoare);
        System.out.println("\nBunurile in valoare de "+ valoare +" a fost adaugate in cutia de valori");
        c.comision();

    }
    public void RetragereValori(InchiriereCutieValori c, double valoare)
    {    if(c.getPragValoriDeclarat()>=valoare)
        c.setPragValoriDeclarat(c.getPragValoriDeclarat()-valoare);
        System.out.println("Au fost retrase bunuri in valoare de "+valoare);
        c.comision();

    }

}
