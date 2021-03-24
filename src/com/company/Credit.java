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

}
