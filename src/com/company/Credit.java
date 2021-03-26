package com.company;

public abstract class Credit extends Cont{

    protected int durataluni;
    protected double SumaAcordata;
    protected double dobanda;
    protected BNRval valori;
    protected ContCurent contc;


    public Credit (String IBAN, String Valuta, double Sold,int n, Card[] card ,int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super( IBAN, Valuta, Sold, n, card, DataAcordare);
        this.durataluni=durataluni;
        this.SumaAcordata=SumaAcordata;
        this.ComisionA=comisionAdministrareCont();
        valori=new BNRval();
        this.contc=contc;




    }

     public abstract double dobanda();
    public double getSumaAcordata()
    {
        return SumaAcordata;
    }

    public double getDobanda() {
        return dobanda;
    }
    public  void setDobanda(double dobanda) {
        this.dobanda=dobanda;
    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append("Creditul se desfasoara pe  " + this.durataluni + " luni, suma acordata este " + this.SumaAcordata + this.Valuta+". Dobanda pentru acest credit este " +this.dobanda + " Rata va fi colectata din  "+ contc.toString());

        return a.toString();
    }

}
