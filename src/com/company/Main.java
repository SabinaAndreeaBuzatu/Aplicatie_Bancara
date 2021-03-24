package com.company;

//de facut : marja banca
public class Main {

    public static void main(String[] args) {
        Client eu = new Client("sabina", "buzatu", "15 ian");
        ContCurent aoleu = new ContCurent("DGFGHJHJKK.","RON",1000,0,null,"b",eu);
        Cont x = new Depozit("a", "b", 120.9, 0, null, "1",  aoleu);
        InchiriereCutieValori z=new InchiriereCutieValori(1000,"12 feb","sdfghjk",aoleu);


        Credit y = new CreditFix("a", "b", 120.9, 0, null, 1, "b", 4, aoleu);
        System.out.println(y.getDobanda());
        System.out.println(aoleu.getIBAN());
        Card u[]=new Card[3];
        for(int i=0;i<3;i++)
            u[i] = new Card("2345678",0000,663,"kgherjhk");
        Cont v=new ContCurent("DGFGHJHJKK.","RON",1000,3,u,"b",eu);
        Extras e=new Extras("2yrq3", x);




    }
}