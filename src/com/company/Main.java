package com.company;

import Client.Client;
import Produse.*;
import ServiciiBancare.*;
import Validari.*;

public class Main {

    public static void main(String[] args) {

        Service serv= new Service();

        ValidareClient v1=new ValidareClient();
        ValidareCont v2=new ValidareCont();
        ValidareCredit v3=new ValidareCredit();
        ValidareInchiriereCutieValori v4=new ValidareInchiriereCutieValori();
        ValidareDepozit v5=new ValidareDepozit();


  Client client1=new Client("Buzatu","Andreea-Sabina","15/01/2000","6001501004653");
  Client client2=new Client("Gheorghe","Dragos-Stefan","01/06/2000","6000106007821");
  Client client3=new Client("Popescu","Raluca-Ioana","13/02/1996","60013025541");

//validare client
  v1.vComplet(client1);
  v1.vComplet(client2);
  v1.vComplet(client3);


  ContCurent cont1=new ContCurent("RO23BNCE4679556772220000","RON",0,0,null,"29/03/2021",client1);
  ContCurent cont2=new ContCurent("RO23BNCE0507775482925130","RON",100000,0,null,"28/03/2021",client2);
  ContCurent cont3=new ContCurent("RO23BNCE1208838620085100","RON",1.78,0,null,"27/03/2021",client3);
  ContCurent cont4=new ContCurent("RO23BNCE0900955100985180","USD",1000,0,null,"29/03/2021",client1);

  //validare cont curent
  v2.vComplet(cont1);
  v2.vComplet(cont2);
  v2.vComplet(cont3);
  v2.vComplet(cont4);

  Card card1=new Card("4244 5643 8870 1002","0917","801","10/22");
  Card card2=new Card("5543 7683 1112 7802","0000","456","29/30");
  Card card3=new Card("6578 9898 3332 0022","4567","328","10/24");
  Card card4=new Card("9989 2246 7878 1110","9876","762","1/32");
  Card card5=new Card("5909 7737 3456 1234","5678","937","9/21");
  Card card6=new Card("1234 5678 9101 1121","1726","076","12/25");

  Credit c1=new CreditFix("RO23BNCE024678004455100","CHF",100,0,null,36,"12/02/2021",100,cont3);
  Credit c2=new CreditFlex("RO23BNCE02467806547894","USD",10000,0,null,12,"22/02/2021",10000,cont4);

  v3.vComplet(c1);
  v3.vComplet(c2);

  Cont d1= new Depozit("RO23BNCE4673456772220990","RON",0,0,null,"29/03/2021",cont1);
  //validare folosind upcasting si validare simpla
  v2.vComplet(d1);
  v5.vComplet(d1);

  InchiriereCutieValori i1= new InchiriereCutieValori(5000,"RON", "30/03/2021","Str Marului. nr 6 , Sucursala x", cont1);
  v4.vComplet(i1);


//Atasarea cardurilor la conturi
        cont1.adaugareCard(card1);
        cont1.adaugareCard(card4);
        cont2.adaugareCard(card2);
        cont4.adaugareCard(card3);
        cont4.adaugareCard(card5);
        cont1.adaugareCard(card6);

//Stergerea unui card atasat unui cont
        System.out.println("\n*Stergerea unui card*");
        System.out.println(cont1);
        cont1.stergeCard(card6);
        System.out.println(cont1);

//Alimentarea unui cont
        System.out.println("\n*Alimentarea unui cont*");
        System.out.println(d1);
        Alimentare a1=new Alimentare();
        a1=serv.alimentare(d1, "30/03/2021","economii",1000);
        System.out.println("\n"+a1);
        System.out.println(d1);

//Retragerea dintr-un cont
        System.out.println("\n*Retragerea dintr-un cont*");
        System.out.println(c2);
        Retragere r1=new Retragere();
        r1=serv.Retragere(c2,"30/03/2021"," de o acadea ", 1);
        System.out.println("\n"+r1);
        System.out.println(c2) ;

//Colectarea comisionului de administrare al unui cont

        System.out.println("\n*Colectarea comisionului de administrare al unui cont*");
        System.out.println(cont2);
        cont2.colectareComision();
        System.out.println(cont2);

//Colectarea comisionului de administrare al contului de credit ( se colecteaza din contul curent atasat)

        System.out.println("\n*Colectarea comisionului de administrare al contului de credit*");
        System.out.println(c2);
        System.out.println(cont4);
        c2.colectareComision();
        System.out.println(cont4);

//Incercare de colectare a ratei unui credit cu dobanda fixa si alimentarea contului curent atasat
        System.out.println("\n*Colectarea ratei unui credit cu dobanda fixa*");
        System.out.println(c1);
        System.out.println("\n");
        c1.platarata();
        System.out.println("\n");
        Alimentare a2=new Alimentare();
        a2=serv.alimentare(cont3, "30/03/2021","plata rata",3000);
        System.out.println(a2);
        c1.platarata();
        System.out.println(cont3);





    }
}