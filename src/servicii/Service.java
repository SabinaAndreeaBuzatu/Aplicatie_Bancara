package servicii;
import fisiere.Timestamp;
import generareValori.BNRval;

import produse.*;
import servicii.serviciiBancare.*;

import java.util.List;


public class Service {
   private Timestamp audit;

    public Service() {
       audit =new Timestamp();
    }
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

            {   audit.Audit("Transfer");
                t=new Transfer(sursa,destinatie,DataTranzactie,mesaj,suma);
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
        for (int i=0;i<6;i++)
            for (int j=0;j<6;j++)
            val[i][j]=Math.round(val[i][j]*100)/100.0;
        if(sursa.getSold()>= suma)
        {   audit.Audit("Schimb Valutar");
            for (int i=0;i<6;i++)
            if(s.equals(valuta[i]))
                indexsursa=i;
                else if(d.equals(valuta[i]))
                    indexdestinatie=i;
                sursa.setSold(sursa.getSold()-suma);
                destinatie.setSold(destinatie.getSold()+val[indexsursa][indexdestinatie]*suma);
                t.sumaTrans=Math.round(val[indexsursa][indexdestinatie]*suma*100)/100.0;
        sursa.adtranz(t);
        destinatie.adtranz(t);
            return t;}
        else {System.out.println("Fonduri insuficiente");
                return null;}

    }

     public Alimentare alimentare(Cont cont, String DataTranzactie, String mesaj, double suma)
     {   audit.Audit("Alimentare");
         cont.setSold( cont.getSold()+ suma);
         Alimentare a = new Alimentare(cont, DataTranzactie, mesaj,  suma);
         cont.adtranz(a);
         return a;
     }
    public Retragere Retragere(Cont cont, String DataTranzactie, String mesaj, double suma)
    {  if(cont.getSold()>=suma)
    {    audit.Audit("Retragere");
        cont.setSold( cont.getSold()- suma);
        Retragere a = new Retragere(cont, DataTranzactie, mesaj,  suma);
        cont.adtranz(a);
        return a;}
        else {     System.out.println("Fonduri insuficiente");

            return null;

        }

    }
    public void AdaugareValori(InchiriereCutieValori c, double valoare)
    {    audit.Audit("Adaugare in cutia de valori");
        c.setPragValoriDeclarat(c.getPragValoriDeclarat()+valoare);
        System.out.println("\nBunurile in valoare de "+ valoare +" a fost adaugate in cutia de valori");
        c.comision();

    }
    public void RetragereValori(InchiriereCutieValori c, double valoare)
    {    if(c.getPragValoriDeclarat()>=valoare)
    {    audit.Audit("Retragere din cutia de valori");
        c.setPragValoriDeclarat(c.getPragValoriDeclarat()-valoare);}
        System.out.println("Au fost retrase bunuri in valoare de "+valoare);
        c.comision();

    }
    public void adaugareCard(Card card, Cont cont) {

        int ok = 1;
        for (Card i : cont.getcard())
            if (card.equals(i)) {
                System.out.println("Cardul " + card.getNrCard()+ "exista deja. Va rugam alegeti alt card");
                ok = 0;
            }
        if (cont.getcard().size() == 0||ok==1) {
            audit.Audit("Adaugare card");
            cont.setCardelem(card);

        }
        cont.setnrcarduri(cont.getnrcarduri()+1);

    }
    public void stergeCard(Card card,Cont cont) {
        int ok = 1;
        for (int i = 0; i < cont.getcard().size(); i++) {
            if (card.getNrCard().equals(cont.getcard().get(i).getNrCard())) {
                audit.Audit("Stergere card");
                ok = 0;
                cont.StergereCard(i);
                cont.setnrcarduri(cont.getnrcarduri()-1);
                }

            }

        if (ok == 1) {
            System.out.println("Cardul " + card.getNrCard() + " nu exista. Va rugam alegeti alt card ");

        }
    }

    public  List <ContCurent>  platarata(Credit credit, List <ContCurent> contc) {
        ContCurent x =new ContCurent(); int j=-1;
        for(ContCurent i:contc)
            if(!(i.getIBAN().equals(credit.getIBANcontc())))
             j++;
        else {

                if (credit.gettipcont().equals("Credit cu dobanda fixa")) {
                    if (credit.getDurataluni() > credit.getRatePlatite())
                        if (i.getSold() >= credit.getRatac()) {
                            contc.get(j+1).setSold(contc.get(j+1).getSold() - credit.getRatac());
                            credit.setRatePlatite(credit.getRatePlatite() + 1);
                            System.out.println("Rata a fost colectata!:)");
                            audit.Audit("Colectarea ratei pentru un credit cu dobanda fixa");
                        }
                else
                    System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul curent pentru a putea achita rata");
            }  else if ((credit.gettipcont().equals("Credit cu dobanda variabila"))) {

            if (credit.getDurataluni() > credit.getRatePlatite())
                if (i.getSold() >= credit.getRatac()) {
                    contc.get(j+1).setSold(contc.get(j+1).getSold() - credit.getRatac());
                    credit.setRatePlatite(credit.getRatePlatite() + 1);
                    System.out.println("Rata a fost colectata!:)");
                    audit.Audit("Colectarea ratei pentru un credit cu dobanda variabila");
                    credit.calcrata();
                    credit.dobanda();
                } else
                    System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul curent pentru a putea achita rata");
        }}
        return  contc;
    }

    public  List <ContCurent>  colectareComisionCredit(List <ContCurent> contc,Credit credit){
        ContCurent x =new ContCurent(); int j=-1;
        for(ContCurent i:contc)
            if(!(i.getIBAN().equals(credit.getIBANcontc())))
                j++;
            else {
        if(i.getSold()>=credit.getComisionA())
        {contc.get(j+1).setSold(contc.get(j+1).getSold()-credit.getComisionA());
            //c.setSold(c.getSold()-credit.getComisionA());
            System.out.println("\nComisionul a fost colectat:)");
            audit.Audit("Colectarea comisionului de administrare al unui cont de credit");
             return contc;}
        else {
            System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita comisionul de administrare");
            return contc;
        }}
        return contc;
    }

    public Cont colectareComisionContC(Cont c) {
        if(c.getSold()>=c.getComisionA())
        { c.setSold(c.getSold()-c.getComisionA());
        System.out.println("Comisionul a fost colectat:)");
            audit.Audit("Colectarea comisionului de administrare al unui cont curent");
       return c;}
        else { System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita comisionul de administrare");
            return c;}
    }

    public ContCurent colectareComisionCutie(InchiriereCutieValori cutie, ContCurent c){
        if(c.getSold()>=cutie.getComision())
        { c.setSold(c.getSold()-cutie.getComision());
            System.out.println("Comisionul a fost colectat:)");
            audit.Audit("Colectarea comisionului de administrare al unei cutii de valori");
            return c;}
        else {
            System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita comisionul de administrare");
            return c;
        }
    }



        }




