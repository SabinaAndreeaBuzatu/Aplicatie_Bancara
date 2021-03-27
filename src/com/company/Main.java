package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Client eu = new Client("sabina", "buzatu", "15 ian","DFGVBH");
        ContCurent aoleu = new ContCurent("123456789","RON",1000,0,null,"23 feb 2009",eu);
        Cont x = new Depozit("99766435537", "RON", 120.9, 0, null, "1 ian 2012",  aoleu);
        InchiriereCutieValori z=new InchiriereCutieValori(100000,"12 feb","strada Marului, nr 5",aoleu);
        Client[] eu1 = new Client[1];
        eu1[0]=new Client("sabina", "buzatu", "15 ian","60000000");

        service ser=new service();

        Card[] u=new Card[3];

            u[0] = new Card("2345678",0000,663,"9/2030");
            Card mor=u[0];
        u[1] = new Card("2765434567",1234,663,"10/22");
        u[2] = new Card("6786544",7777,663,"3/25");
        Card morr=u[2];
        ContCurent v=new ContCurent("DGFGHJHJKK.","RON",1000,3,u,"b",eu);
        Credit y = new CreditFix("345123567", "GBP", 120900, 0, null, 10, "b", 1000000, v);
        Extras e=new Extras("2yrq3", x);
        Pair<Cont> p =new Pair<>(x,v);
        Transfer t = new Transfer(p,"12 iul",".",55);
   Transfer MORRRRRR=new Transfer();

            t=ser.transfer(x,v,"14 iul"," ",1234);

        Alimentare a=ser.alimentare(v,"13 nov"," ", 1000);

        System.out.println(a.toString());
       // System.out.println(x.toString());

////////fa schimb valutar, set get la toate to sting la toate  si MARJA AIA




    }
}