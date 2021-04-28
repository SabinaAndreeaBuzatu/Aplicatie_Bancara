package main;

import client.Client;
import fisiere.Citire;
import fisiere.Pair;
import fisiere.Scriere;
import produse.*;
import serviciiBancare.*;
import validari.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Service serv= new Service();

        ValidareClient v1=new ValidareClient();
        ValidareCont v2=new ValidareCont();
        ValidareCredit v3=new ValidareCredit();
        ValidareInchiriereCutieValori v4=new ValidareInchiriereCutieValori();
        ValidareDepozit v5=new ValidareDepozit();
        ValidareCard v6 = new ValidareCard();

        Citire c =Citire.getInstance();
        Scriere s= Scriere.getInstance();
        List<Client> clienti;
        List<Cont> conturic;
        List<ContCurent> local;
        clienti=c.CitireClient();
        conturic=c.CitireContCurent(clienti);
        fisiere.Pair< List<Cont>, List<Card>> contcCard;
        fisiere.Pair< List<Cont>, List<Card>> contCard;
        contcCard=c.CitireCard(conturic);
        local= (List <ContCurent>)(List<?>) contcCard.getFirst();
      //  fisiere.Pair< List<Depozit>, List<Credit>> depozitCredit;
        List <Cont> cccc= new ArrayList<>();
        cccc=c.CitireCont( local);
        contCard=c.CitireCard(cccc);
        List < InchiriereCutieValori> cutii=c.CitireCutie(local);

//        s.ScriereCard(contcCard.getCarduri());
//        s.ScriereClient(clienti);
//        s.ScriereCont(contCard.getFirst());
//        s.ScriereContCurent(local);
//        s.ScriereCutie(cutii);
//        s.ScriereCompleta(cutii,contcCard.getCarduri(),local,contCard.getFirst(),clienti);


//
//  Client client1=new Client("Buzatu","Andreea-Sabina","15/01/2000","6001501004653");
//  Client client2=new Client("Gheorghe","Dragos-Stefan","01/06/2000","6000106007821");
//  Client client3=new Client("Popescu","Raluca-Ioana","13/02/1996","60013025541");
//
////validare client
//  v1.vComplet(client1);
//  v1.vComplet(client2);
//  v1.vComplet(client3);
//
//
//  ContCurent cont1=new ContCurent("RO23BNCE4679556772220000","RON",500,0,null,"29/03/2021",client1);
//  ContCurent cont2=new ContCurent("RO23BNCE0507775482925130","RON",100000,0,null,"28/03/2021",client2);
//  ContCurent cont3=new ContCurent("RO23BNCE1208838620085100","RON",1.78,0,null,"27/03/2021",client3);
//  ContCurent cont4=new ContCurent("RO23BNCE0900955100985180","USD",1000,0,null,"29/03/2021",client1);
//
//  //validare cont curent
//  v2.vComplet(cont1);
//  v2.vComplet(cont2);
//  v2.vComplet(cont3);
//  v2.vComplet(cont4);
//
//  Card card1=new Card("4244 5643 8870 1002","0917","801","10/22");
//  Card card2=new Card("5543 7683 1112 7802","0000","456","09/25");
//  Card card3=new Card("6578 9898 3332 0022","4567","328","10/24");
//  Card card4=new Card("9989 2246 7878 1110","9876","762","01/32");
//  Card card5=new Card("5909 7737 3456 1234","5678","937","09/21");
//  Card card6=new Card("1234 5678 9101 1121","1726","076","12/25");
//
//  v6.vComplet(card1);
//  v6.vComplet(card2);
//  v6.vComplet(card3);
//  v6.vComplet(card4);
//  v6.vComplet(card5);
//  v6.vComplet(card6);
//
//  Credit c1=new CreditFix("RO23BNCE024678004455100","CHF",100,0,null,36,"12/02/2021",100,cont3);
//  Credit c2=new CreditFlex("RO23BNCE02467806547894","USD",10000,0,null,12,"22/02/2021",10000,cont4);
//
//  v3.vComplet(c1);
//  v3.vComplet(c2);
//
//  Cont d1= new Depozit("RO23BNCE4673456772220990","RON",0,0,null,"29/03/2021",cont1);
//  //validare folosind upcasting si validare simpla
//  v2.vComplet(d1);
//  v5.vComplet(d1);
//
//  InchiriereCutieValori i1= new InchiriereCutieValori(5000,"RON", "30/03/2021","Str Marului. nr 6 , Sucursala x", cont1);
//  v4.vComplet(i1);
//
//
////Atasarea cardurilor la conturi
//        serv.adaugareCard(card1,cont1);
//        serv.adaugareCard(card4,cont1);
//        serv.adaugareCard(card2,cont2);
//        serv.adaugareCard(card3,cont4);
//        serv.adaugareCard(card5,cont4);
//        serv.adaugareCard(card6,cont1);

//Stergerea unui card atasat unui cont
        System.out.println("\n*Stergerea unui card*");
        System.out.println(contcCard.getFirst());
        serv.stergeCard(contcCard.getCarduri().get(4),contcCard.getFirst().get(0));
        System.out.println(contcCard.getFirst().get(0));

//Alimentarea unui cont
        System.out.println("\n*Alimentarea unui cont*");
        System.out.println(contCard.getFirst().get(2));
        Alimentare a1;
        a1=serv.alimentare(contCard.getFirst().get(2), "30/03/2021","economii",1000);
        System.out.println("\n"+a1);
        System.out.println(contCard.getFirst().get(2));

//Retragerea dintr-un cont
        System.out.println("\n*Retragerea dintr-un cont*");
        System.out.println(contCard.getFirst().get(1));
        Retragere r1;
        r1=serv.Retragere(contCard.getFirst().get(1),"30/03/2021"," de o acadea ", 1);
        System.out.println("\n"+r1);
        System.out.println(contCard.getFirst().get(1)) ;

//Colectarea comisionului de administrare al unui cont

        System.out.println("\n*Colectarea comisionului de administrare al unui cont*");
        System.out.println(contcCard.getFirst().get(1));
        contcCard.getFirst().set(1,serv.colectareComisionContC( contcCard.getFirst().get(1)));
        System.out.println(contcCard.getFirst().get(1));

//Colectarea comisionului de administrare al contului de credit ( se colecteaza din contul curent atasat)

        System.out.println("\n*Colectarea comisionului de administrare al contului de credit*");
        System.out.println(contCard.getFirst().get(1));
        System.out.println(contcCard.getFirst().get(3));
        contcCard.getFirst().set(3,serv.colectareComisionCredit(contcCard.getFirst().get(3),(Credit) contCard.getFirst().get(1)));
        System.out.println(contcCard.getFirst().get(3));

//Colectarea comisionului de administrare al cutiei de valori ( se colecteaza din contul curent atasat)
        System.out.println("\n*Colectarea comisionului de administrare al cutiei de valori*");
        System.out.println(cutii.get(0));
        System.out.println(contcCard.getFirst().get(0));
        System.out.println("\n");
        contcCard.getFirst().set(0,serv.colectareComisionCutie(cutii.get(0),(ContCurent) contcCard.getFirst().get(0)));
        System.out.println(contcCard.getFirst().get(0));



//Incercare de colectare a ratei unui credit cu dobanda fixa si alimentarea contului curent atasat
        System.out.println("\n*Colectarea ratei unui credit cu dobanda fixa*");
        System.out.println(contCard.getFirst().get(0));
        System.out.println("\n");
        serv.platarata((Credit) contCard.getFirst().get(0));
        Alimentare a2;
        a2=serv.alimentare(contcCard.getFirst().get(2), "30/03/2021","plata rata",3000);
        System.out.println(a2);
        serv.platarata((Credit) contCard.getFirst().get(0));
        System.out.println(contcCard.getFirst().get(2));

//Incercare de colectare a ratei unui credit cu dobanda variabila si alimentarea contului curent atasat
//Vom colecta 2 rate pentru a vedea cum se schimba dobanda si, in consecinta, rata
        System.out.println("\n*Colectarea ratei unui credit cu dobanda variabila*");
        System.out.println( contCard.getFirst().get(1));
        System.out.println("\n");
        serv.platarata((Credit) contCard.getFirst().get(1));
        System.out.println(contcCard.getFirst().get(3));
        Alimentare a3;
        a3=serv.alimentare(contcCard.getFirst().get(3), "30/03/2021","plata rata",30000);
        System.out.println(a3);
        serv.platarata((Credit) contCard.getFirst().get(1));
        System.out.println(contCard.getFirst().get(1));
        serv.platarata((Credit) contCard.getFirst().get(1));
        System.out.println(contcCard.getFirst().get(3));

//Adaugare bunuri la cutia de valori
        System.out.println("\n*Adaugare bunuri la cutia de valori *");
        System.out.println(cutii.get(0));
        serv.AdaugareValori(cutii.get(0),1000);
        System.out.println(cutii.get(0));

//Retragere bunuri din cutia de valori
        System.out.println("\n*Retragere bunuri din cutia de valori*");
        System.out.println(cutii.get(0));
        serv.RetragereValori(cutii.get(0),1000);
        System.out.println(cutii.get(0));

//Transfer intre 2 conturi cu aceeasi valuta
        System.out.println("\n*Transfer intre 2 conturi *");
        System.out.println(contcCard.getFirst().get(0));
        System.out.println(contCard.getFirst().get(2));
        Transfer t1 ;
        t1= serv.transfer(contcCard.getFirst().get(0),contCard.getFirst().get(2),"30/03/2021","economii :) ",100);
        //transferul o sa fie esuat pentru ca sunt fuonduri insufieciente
        serv.NullException(t1);
        serv.alimentare(contcCard.getFirst().get(0), "30/03/2021","plata rata",300);
        t1= serv.transfer(contcCard.getFirst().get(0),contCard.getFirst().get(2),"30/03/2021","economii :) ",100);
        serv.NullException(t1);
        System.out.println(contcCard.getFirst().get(0));
        System.out.println(contCard.getFirst().get(2));

//Incercarea unui transfer intre 2 conturi cu valuta diferita
        System.out.println("\n*Transfer intre 2 conturi *");
        System.out.println(contcCard.getFirst().get(0));
        System.out.println(contcCard.getFirst().get(3));
        Transfer t2 ;
        t2= serv.transfer(contcCard.getFirst().get(0),contcCard.getFirst().get(3),"30/03/2021","economii :) ",100);
        serv.NullException(t2);


//Transfer folosind Schimb Valutar
        System.out.println("\n*Transfer intre 2 conturi cu valuta diferita folosind schimb valutar *");
        System.out.println(contcCard.getFirst().get(0));
        System.out.println(contcCard.getFirst().get(3));
        SchimbValutar s2;
        s2= serv.SchimbValutar(contcCard.getFirst().get(0),contcCard.getFirst().get(3),"30/03/2021","economii in valuta diferita:) ",100);
        serv.NullException(s2);
        System.out.println(contcCard.getFirst().get(0));
        System.out.println(contcCard.getFirst().get(3));


//Afisare extras
        System.out.println("\n*Afisare extras de cont*\n ");
        contcCard.getFirst().get(0).extras("30/03/2021");
        System.out.println("\n");
        contCard.getFirst().get(0).extras("30/03/2021");
        System.out.println("\n");
        contcCard.getFirst().get(2).extras("30/03/2021");

//
//
//
//    Citire c =Citire.getInstance();
//    Scriere s= Scriere.getInstance();
//    List<Client> x=new ArrayList<>();
//        List<Cont> y=new ArrayList<>();
//    List<ContCurent> local = new ArrayList<>();
//    x=c.CitireClient();
//    System.out.println(x);
//    y=c.CitireContCurent(x);
//        System.out.println("-------------------------------------------------------");
//    System.out.println(y);
//        List<Card> z=new ArrayList<>();
//        fisiere.Pair< List<Cont>, List<Card>> xx=new Pair<>(y,z);
//        fisiere.Pair< List<Cont>, List<Card>> xxx;
//        xx=c.CitireCard(y);
//
//         local= (List <ContCurent>)(List<?>) xx.getFirst();
//         List <Cont> ccc;
//        ccc=c.CitireCont( local);
//        xxx=c.CitireCard(ccc);
//      List < InchiriereCutieValori> cc=c.CitireCutie(local);

       s.ScriereCard(contcCard.getCarduri());
       s.ScriereCard(contCard.getCarduri());
       s.ScriereClient(clienti);
       s.ScriereCont(contCard.getFirst());
       s.ScriereContCurent(contcCard.getFirst());
       s.ScriereCutie(cutii);
        s.ScriereCompleta(cutii, null, contcCard.getFirst(), contCard.getFirst(), clienti);




    }
}