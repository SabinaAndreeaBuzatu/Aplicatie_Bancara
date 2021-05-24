package main;

import client.Client;

import fisiere.Citire;
import fisiere.Scriere;
import produse.*;
import servicii.db.DBService;
import servicii.*;
import servicii.serviciiBancare.Alimentare;
import servicii.serviciiBancare.Retragere;
import servicii.serviciiBancare.SchimbValutar;
import servicii.serviciiBancare.Transfer;
import validari.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        Service serv= new Service();
        ValidareClient v1=new ValidareClient();
        ValidareCont v2=new ValidareCont();
        ValidareCredit v3=new ValidareCredit();
        ValidareInchiriereCutieValori v4=new ValidareInchiriereCutieValori();
        ValidareDepozit v5=new ValidareDepozit();
        ValidareCard v6 = new ValidareCard();

///Citire din fisiere
        Citire c =Citire.getInstance();
        Scriere s= Scriere.getInstance();

        List<Client> clienti=c.CitireClient();
        v1.vListComplet(clienti);
        List<ContCurent> conturiCurente=c.CitireContCurent(clienti);
        v2.vListComplet(conturiCurente);
        //cast din lista de conturi curente in lista de conturi
        List<Cont> auxConturiCurente= (List <Cont>)(List<?>) conturiCurente;
        //citim cardurile pentru conturile curente
        fisiere.Pair< List<Cont>, List<Card>> conturiCurenteSiCarduri=c.CitireCard( auxConturiCurente);
        v6.vListComplet(conturiCurenteSiCarduri.getSecond());

        //cast inapoi la cont curent
       conturiCurente = (List<ContCurent>) (List<?>) conturiCurenteSiCarduri.getFirst();
       List<Card> carduri=conturiCurenteSiCarduri.getSecond();
        fisiere.Pair< List<Cont>, List<Card>> conturiSiCarduri;
        List <Cont> conturi=c.CitireCont( conturiCurente);
        for(int i=0;i<conturi.size();i++)
            if((conturi.get(i) instanceof CreditFix)||(conturi.get(i) instanceof CreditFlex))
                v3.vComplet(conturi.get(i));
            else
                v5.vComplet(conturi.get(i));
        conturiSiCarduri=c.CitireCard(conturi);
        v6.vListComplet(conturiSiCarduri.getSecond());
        for(int i=0;i<conturiSiCarduri.getSecond().size();i++)
            carduri.add(conturiSiCarduri.getSecond().get(i));
        List <InchiriereCutieValori> cutii=c.CitireCutie(conturiCurente);
        v4.vListComplet(cutii);

            System.out.println(conturi);


  Client client1=new Client("Buzatu","Maria-Sabina","15/01/2000","6001501004653");
  Client client2=new Client("Gheorghe","Dragos-Stefan","01/06/2000","6000106007821");
  Client client3=new Client("Popescu","Raluca-Ioana","13/02/1996","6001302554199");

//validare client
  v1.vComplet(client1);
  v1.vComplet(client2);
  v1.vComplet(client3);


  ContCurent cont1=new ContCurent("RO23BNCE4679556772220000","RON",500,0,null,"29/03/2021",client1.getCNP());
  ContCurent cont2=new ContCurent("RO23BNCE0507775482925130","RON",100,0,null,"28/03/2021",client2.getCNP());
  ContCurent cont3=new ContCurent("RO23BNCE1208838620085100","RON",1.78,0,null,"27/03/2021",client3.getCNP());
  ContCurent cont4=new ContCurent("RO23BNCE0900955100985180","USD",10,0,null,"29/03/2021",client1.getCNP());

  //validare cont curent
  v2.vComplet(cont1);
  v2.vComplet(cont2);
  v2.vComplet(cont3);
  v2.vComplet(cont4);

  Card card1=new Card("4244 5643 8870 1002","0917","801","10/22");
  Card card2=new Card("5543 7683 1112 7802","0000","456","09/25");
  Card card3=new Card("6578 9898 3332 0022","4567","328","10/24");
  Card card4=new Card("9989 2246 7878 1110","9876","762","01/32");
  Card card5=new Card("5909 7737 3456 1234","5678","937","09/21");
  Card card6=new Card("1234 5678 9101 1121","1726","076","12/25");

   //Atasarea cardurilor la conturi
    serv.adaugareCard(card1,cont1);
    serv.adaugareCard(card4,cont1);
    serv.adaugareCard(card2,cont2);
    serv.adaugareCard(card3,cont4);
    serv.adaugareCard(card5,cont4);



      v6.vComplet(card1);
      v6.vComplet(card2);
      v6.vComplet(card3);
      v6.vComplet(card4);
      v6.vComplet(card5);
      v6.vComplet(card6);

      Credit c1=new CreditFix("RO23BNCE024678004455100","CHF",100,0,null,36,"12/02/2021",100,cont3.getIBAN());
      Credit c2=new CreditFlex("RO23BNCE02467806547894","USD",10000,0,null,12,"22/02/2021",10000,cont4.getIBAN());
      serv.adaugareCard(card6,c1);

      v3.vComplet(c1);
      v3.vComplet(c2);

      Cont d1= new Depozit("RO23BNCE4673456772220990","RON",0,0,null,"29/03/2021",cont1.getIBAN());
      //validare folosind upcasting si validare simpla
      v2.vComplet(d1);
      v5.vComplet(d1);

      InchiriereCutieValori i1= new InchiriereCutieValori(5000,"RON", "30/03/2021","Str Marului. nr 6 , Sucursala x", cont1.getIBAN());
      v4.vComplet(i1);

      //Adaugare in baza de date
      DBService dbserv=new DBService();
      dbserv.clearDB();
      dbserv.addClient(client1);
      dbserv.addClient(client2);
      dbserv.addClient(client3);

      dbserv.addCont(cont1);
      dbserv.addCont(cont2);
      dbserv.addCont(cont3);
      dbserv.addCont(cont4);

      List<Cont> dbConturi=new ArrayList<>();
      dbConturi.add(cont1);
      dbConturi.add(cont2);
      dbConturi.add(cont3);
      dbConturi.add(cont4);
      dbConturi.add(c1);
      dbConturi.add(c2);
        dbConturi.add(d1);
      List<ContCurent> dbConturic=new ArrayList<>();
        dbConturic.add(cont1);
        dbConturic.add(cont2);
        dbConturic.add(cont3);
        dbConturic.add(cont4);


      dbserv.addDepozit((Depozit) d1);

      dbserv.addCredit(c1);
      dbserv.addCredit(c2);

      dbserv.addCard(dbConturi,card1);
      dbserv.addCard(dbConturi,card2);
      dbserv.addCard(dbConturi,card3);
      dbserv.addCard(dbConturi,card4);
      dbserv.addCard(dbConturi,card5);
      dbserv.addCard(dbConturi,card6);

      dbserv.addCutie(i1);


//Update client
        client1=new Client("Buzatu","Andreea-Sabina","15/01/2000","6001501004653");
        dbserv.updateClient(client1);
//Update esuat Cont Curent pentru ca introducem un IBAN gresit
         ContCurent crr=new ContCurent("RO23BNCE467955677222000","RON",600,0,null,"29/03/2021",client1.getCNP());
        dbserv.updateCont(crr);
          crr=new ContCurent("RO23BNCE4679556772220000","RON",700,0,null,"29/03/2021",client1.getCNP());
        dbserv.updateCont(crr);
//Update Depozit
         Depozit d= new Depozit("RO23BNCE4673456772220990","RON",100,0,null,"29/03/2021",cont1.getIBAN());
         dbserv.updateDepozit(d);
//Update Credit
         Credit cr=new CreditFix("RO23BNCE024678004455100","CHF",100,0,null,36,"12/03/2021",100,cont3.getIBAN());
         dbserv.updateCredit(cr);


//Citire clienti din baza de date
        System.out.println("\n*Clientii din baza de date*");
        List<Client> dbclienti=dbserv.readAllClient();
        System.out.println(dbclienti);
//Citirea conturilor curente din baza de date
        System.out.println("\n*Conturile curente din baza de date*");
        List<Cont> dbConturiCurente=dbserv.readAllContCurent();
        System.out.println(dbConturiCurente);
//Citirea depozitelor din baza de date
        System.out.println("\n*Depozitele din baza de date*");
        List<Cont> dbdep= dbserv.readAllDepozit();
        System.out.println(dbdep);
//Citirea creditelor din baza de date
        System.out.println("\n*Creditele din baza de date*");
        List<Cont> dbcredite= dbserv.readAllCredit();
        System.out.println(dbcredite);
//Citirea cutiilor din baza de date
        System.out.println("\n*Cutiile de valori din baza de date*");
        List<InchiriereCutieValori> dbcutii= dbserv.readAllCutie();
        System.out.println(dbcutii);
//Citirea cardurilor din baza de date
        System.out.println("\n*Cardurile din baza de date*");
        List<Card> dbcarduri=dbserv.readAllCard();
        for(int i=0;i<dbcarduri.size();i++)
        System.out.println(dbcarduri.get(i));

//Stergerea unui card atasat unui cont
        System.out.println("\n*Stergerea unui card*");
        System.out.println(dbConturiCurente.get(3));
        serv.stergeCard(dbcarduri.get(4),dbConturiCurente.get(3));
        System.out.println(dbConturiCurente.get(3));

//Alimentarea unui cont
        System.out.println("\n*Alimentarea unui cont*");
        System.out.println(dbConturiCurente.get(2));
        Alimentare a1;
        a1=serv.alimentare(dbConturiCurente.get(2), "30/03/2021","economii",1000);
        System.out.println("\n"+a1);
        System.out.println(dbConturiCurente.get(2));

//Retragerea dintr-un cont
        System.out.println("\n*Retragerea dintr-un cont*");
        System.out.println(dbConturiCurente.get(1));
        Retragere r1;
        r1=serv.Retragere(dbConturiCurente.get(1),"30/03/2021"," de o acadea ", 1);
        System.out.println("\n"+r1);
        System.out.println(dbConturiCurente.get(1));

//Colectarea comisionului de administrare al unui cont

        System.out.println("\n*Colectarea comisionului de administrare al unui cont*");
        System.out.println(dbConturiCurente.get(1));
        serv.colectareComisionContC(dbConturiCurente.get(1));
        System.out.println(dbConturiCurente.get(1));

//Colectarea comisionului de administrare al contului de credit ( se colecteaza din contul curent atasat)

        System.out.println("\n*Colectarea comisionului de administrare al contului de credit*");
        System.out.println(dbcredite.get(1));
        System.out.println(dbConturiCurente.get(1));
        List<ContCurent> aux= (List<ContCurent>)( List<?>)dbConturiCurente;
        serv.colectareComisionCredit(aux,(Credit) dbcredite.get(1));
        System.out.println(dbConturiCurente.get(1));

//Colectarea comisionului de administrare al cutiei de valori ( se colecteaza din contul curent atasat)
        System.out.println("\n*Colectarea comisionului de administrare al cutiei de valori*");
        System.out.println(dbcutii.get(0));
        System.out.println(dbConturiCurente.get(3));
        System.out.println("\n");
        serv.colectareComisionCutie(dbcutii.get(0),(ContCurent) dbConturiCurente.get(3));
        System.out.println(dbConturiCurente.get(3));



//Incercare de colectare a ratei unui credit cu dobanda fixa si alimentarea contului curent atasat
        System.out.println("\n*Colectarea ratei unui credit cu dobanda fixa*");
        System.out.println( dbcredite.get(0));
        System.out.println(dbConturi.get(2));
        dbConturic=serv.platarata((Credit) dbcredite.get(0),dbConturic);
        Alimentare a2;
        a2=serv.alimentare(dbConturi.get(2), "30/03/2021","plata rata",3000);
        System.out.println(a2);
        dbConturic= serv.platarata((Credit) dbcredite.get(0),dbConturic);
        System.out.println(dbConturic.get(2));


//Incercare de colectare a ratei unui credit cu dobanda variabila si alimentarea contului curent atasat
//Vom colecta 2 rate pentru a vedea cum se schimba dobanda si, in consecinta, rata
        System.out.println("\n*Colectarea ratei unui credit cu dobanda variabila*");
        System.out.println( dbcredite.get(1));
        System.out.println("\n");
        serv.platarata((Credit) dbcredite.get(1),dbConturic);
        System.out.println(dbConturic.get(3));
        Alimentare a3;
        a3=serv.alimentare(dbConturic.get(3), "30/03/2021","plata rata",3000);
        System.out.println(a3);
        serv.platarata((Credit) dbcredite.get(1),dbConturic);
        System.out.println( dbcredite.get(1));
        serv.platarata((Credit)  dbcredite.get(1),dbConturic);
        System.out.println(dbConturic.get(3));

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
        System.out.println(dbConturic.get(0));
        System.out.println(dbdep.get(0));
        Transfer t1 ;
        t1= serv.transfer(dbConturic.get(0),dbdep.get(0),"30/03/2021","economii :) ",100);
        serv.NullException(t1);
        System.out.println(dbConturic.get(0));
        System.out.println(dbdep.get(0));

//Incercarea unui transfer intre 2 conturi cu valuta diferita
        System.out.println("\n*Transfer intre 2 conturi *");
        System.out.println(dbConturic.get(0));
        System.out.println(dbcredite.get(0));
        Transfer t2 ;
        t2= serv.transfer(dbConturic.get(0),dbcredite.get(0),"30/03/2021","economii :) ",100);
        serv.NullException(t2);


//Transfer folosind Schimb Valutar
        System.out.println("\n*Transfer intre 2 conturi cu valuta diferita folosind schimb valutar *");
        System.out.println(dbConturic.get(0));
        System.out.println(dbcredite.get(0));
        SchimbValutar s2;
        s2= serv.SchimbValutar(dbConturic.get(0),dbcredite.get(0),"30/03/2021","economii in valuta diferita:) ",100);
        serv.NullException(s2);
        System.out.println(dbConturic.get(0));
        System.out.println(dbcredite.get(0));


//Afisare extras
        System.out.println("\n*Afisare extras de cont*\n ");
        dbcredite.get(1).extras("30/03/2021");
        System.out.println("\n");
        dbConturic.get(0).extras("30/03/2021");
        System.out.println("\n");
        dbdep.get(0).extras("30/03/2021");
//
//Stergerea unui credit si a tuturor cardurilor atasate
        System.out.println("\n*Stergerea unui credit din baza de date*");
        System.out.println(dbcredite);
        dbserv.deleteCredit((Credit)dbcredite.get(0));
        dbcredite= dbserv.readAllCredit();
        System.out.println(dbcredite);
//Stergerea unui depozit din baza de date si a tuturor cardurilor atasate
        System.out.println("\n*Stergerea unui depozit din baza de date*");
        System.out.println(dbdep);
        dbserv.deleteDepozit((Depozit) dbdep.get(0));
        dbdep= dbserv.readAllDepozit();
        System.out.println(dbdep);
//Stergerea unei cutii din baza de date
        System.out.println(dbcutii);
        dbserv.deleteCutie(i1);
        dbcutii= dbserv.readAllCutie();
        System.out.println(dbcutii);
//Stergerea unui cont curent si a tuturor conturilor si cardurilor atasate
        System.out.println("\n*Stergerea unui cont curent din baza de date*");
        System.out.println("Contul curent:");
        System.out.println(dbConturiCurente);
        System.out.println("Depozit atasat:");
        System.out.println(dbdep);
        dbserv.deleteCont((ContCurent) dbConturiCurente.get(3));
        dbConturiCurente= dbserv.readAllContCurent();
        dbdep=dbserv.readAllDepozit();
        System.out.println("Contul curent:");
        System.out.println(dbConturiCurente);
        System.out.println("Depozit atasat:");
        System.out.println(dbdep);
//Stergerea unui client si a tuturor conturilor si cardurilor acestuia
        dbserv.deleteClient(clienti.get(2));
//Stergerea tuturor creditelor
        dbserv.deleteallCredit();
//Stergerea tuturor depozitelor
        dbserv.deleteallDepozit();
//Stergerea tuturor conturilor curent
        dbserv.deleteallContCurent();
//Stergerea tuturor clientilor
        dbserv.deleteallClient();


//Scriere in fisiere
       s.ScriereCard(conturiCurenteSiCarduri.getSecond());
       s.ScriereCard(conturiSiCarduri.getSecond());
       s.ScriereClient(clienti);
       s.ScriereCont(conturiSiCarduri.getFirst());
       s.ScriereContCurent(conturiCurenteSiCarduri.getFirst());
       s.ScriereCutie(cutii);
       s.ScriereCompleta(cutii, null, conturiCurenteSiCarduri.getFirst(), conturiSiCarduri.getFirst(), clienti);

       //System.out.println(c1);


   }
}