package com.company;

//de facut : marja banca
public class Main {

    public static void main(String[] args) {
        Client eu = new Client("sabina", "buzatu", "15 ian","DFGVBH");
        ContCurent aoleu = new ContCurent("DGFGHJHJKK.","RON",1000,0,null,"b",eu);
        Cont x = new Depozit("a", "b", 120.9, 0, null, "1",  aoleu);
        InchiriereCutieValori z=new InchiriereCutieValori(1000,"12 feb","sdfghjk",aoleu);


        Credit y = new CreditFix("a", "b", 120.9, 0, null, 1, "b", 4, aoleu);
        System.out.println(y.getDobanda());
        System.out.println(aoleu.getIBAN());
        Card[] u=new Card[3];

            u[0] = new Card("2345678",0000,663,"kgherjhk");
            Card mor=u[0];
        u[1] = new Card("2765434567",1234,663,"kgherjhk");
        u[2] = new Card("6786544",7777,663,"kgherjhk");
        Card morr=u[2];
        Cont v=new ContCurent("DGFGHJHJKK.","RON",1000,3,u,"b",eu);
        Extras e=new Extras("2yrq3", x);
        Pair<Cont> p =new Pair<>(x,v);
        Tranzactie t = new Tranzactie(p);




          v.stergeCard(morr);


        v.stergeCard(mor);

        System.out.println(v.toString());



    }
}