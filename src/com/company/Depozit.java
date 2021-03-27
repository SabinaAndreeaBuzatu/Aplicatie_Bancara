package com.company;

public class Depozit extends Cont {
    protected double dobanda;
    protected ContCurent contc;

    public Depozit(String IBAN, String Valuta, double Sold,int n, Card[] card,String DataAcordare, ContCurent contc)
        {
            super( IBAN, Valuta, Sold, n, card, DataAcordare);
            this.dobanda=calcdobanda();
            this.contc=contc;
            this.tipcont="Depozit";
        }

       @Override
       public double comisionAdministrareCont()
        {
           return 0;
        }
        public double calcdobanda ()
        {
            return 3*Sold/1000;
        }

        public void AdaugaDobandaDepozit(){

        this.Sold=dobanda+Sold;
        }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append("Dobanda este  " + this.dobanda+ " si are atasat contul curent cu IBAN "+contc.IBAN);

        return a.toString();
    }
    public double getDobanda() {
        return dobanda;
    }
    public void setDobanda(double dobanda)
    {
        this.dobanda=dobanda;
    }
};
