package com.company;

public class Depozit extends Cont {
    protected double dobanda;
    protected ContCurent contc;

    public Depozit(String IBAN, String Valuta, double Sold,int n, Card[] card,String DataAcordare, ContCurent contc)
        {
            super( IBAN, Valuta, Sold, n, card, DataAcordare);
            this.dobanda=dobanda();
            this.contc=contc;

        }

       @Override
       public double comisionAdministrareCont()
        {
           return 0;
        }
        public double dobanda ()
        {
            return 3*Sold/1000;
        }

    };
