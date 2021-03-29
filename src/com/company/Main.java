package com.company;

import Client.Client;
import Produs.*;
import ServiciiBancare.*;

public class Main {

    public static void main(String[] args) {

        service serv= new service();
//Am adaugat 3 clienti
  Client client1=new Client("Buzatu","Andreea-Sabina","15/01/2000","6001501004653");
  Client client2=new Client("Gheorghe","Dragos-Stefan","01/06/2000","6000106007821");
  Client client3=new Client("Popescu","Raluca-Ioana","13/02/1996","60013025541");

//Am creat 4 conturi curente. Un client poate avea mai multe conturi curente
  ContCurent cont1=new ContCurent("RO23BNCE090SV34866455100","RON",0,0,null,"29/03/2021",client1);
  ContCurent cont2=new ContCurent("RO23BNCE050SV75482925130","RON",100000,0,null,"28/03/2021",client2);
  ContCurent cont3=new ContCurent("RO23BNCE120SV38620085100","RON",1.78,0,null,"27/03/2021",client3);
  ContCurent cont4=new ContCurent("RO23BNCE090SV55100985180","USD",1000,0,null,"29/03/2021",client1);

//Am creat 6 carduri si le-am adaugat conturilor. Conturile pot avea intre 0 si 100 carduri
  Card card1=new Card("4244 5643 8870 1002","0917","801","10/22");
  Card card2=new Card("5543 7683 1112 7802","0000","456","29/30");
  Card card3=new Card("6578 9898 3332 0022","4567","328","10/24");
  Card card4=new Card("9989 2246 7878 1110","9876","762","1/32");
  Card card5=new Card("5909 7737 3456 1234","5678","937","9/21");
  Card card6=new Card("1234 5678 9101 1121","1726","076","12/25");

        cont1.adaugareCard(card1);
        cont1.adaugareCard(card4);
        cont2.adaugareCard(card2);
        cont4.adaugareCard(card3);
        cont4.adaugareCard(card5);
        cont1.adaugareCard(card6);

// System.out.println(cont1.toString());
// System.out.println(cont2.toString());
// System.out.println(cont4.toString());
// System.out.println(cont3.toString());

 //Stergerea cardului card6
        cont1.stergeCard(card6);

// System.out.println(cont1.toString());
//Crearea unui Depozit si alimentarea acestuia
 Cont d1= new Depozit("RO23BNCE090SV4004455100","RON",0,0,null,"29/03/2021",cont1);
 Alimentare a1= new Alimentare();
 a1=serv.alimentare(d1,"30/03/2021","tentativa de economisire",1000);
 d1.extras("29/3/2021");
 Retragere r1= new Retragere();
 r1=serv.Retragere(d1,"30/02/2021",":)",10);

Transfer t=new Transfer();
t= serv.transfer(d1,cont1,"30/03/2021","imprumut",100);
        d1.extras("30/3/2021");

    Credit c1=new CreditFix("RO23BNCE024678004455100","CHF",100,0,null,36,"12/02/2021",10,cont3);
    c1.retragere(1);
    System.out.println(c1.toString());
    c1.platarata();
    cont3.alimentare(3000);
    c1.platarata();
    System.out.println(cont3.toString());



    }
}