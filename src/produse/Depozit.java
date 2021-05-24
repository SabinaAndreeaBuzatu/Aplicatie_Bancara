package produse;


import client.Client;

public class Depozit extends Cont {
    protected double dobanda;
    protected String IBANcontc;
    // Depozitul are nevoie de un cont curent atasat. Nu ne putem duce la banca sa deschidem un depozit fara ca sa ni se deschida inainte si un cont curent. Asta este valabil si pentru credite


    public Depozit(){super();
    this.dobanda=0;
   }
    public Depozit(String IBAN, String Valuta, double Sold, int n, Card[] card, String DataAcordare, String contc)
        {
            super( IBAN, Valuta, Sold, n, card, DataAcordare);
            this.dobanda=calcdobanda();
            this.IBANcontc=contc;
            this.tipcont="Depozit";
        }

       @Override
       public void comisionAdministrareCont()
        {
           this.ComisionA= 0;
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
        a.append("Dobanda este  " + this.dobanda+ " si are atasat contul curent cu IBAN "+IBANcontc);

        return a.toString();
    }

    @Override
    public void setIBANcontc(String c) {
         this.IBANcontc=c;
    }
    public String getIBANcontc() {
        return IBANcontc;

    }

    public double getDobanda() {
        return dobanda;
    }
    public void setDobanda(double dobanda)
    {
        this.dobanda=dobanda;
    }

};
