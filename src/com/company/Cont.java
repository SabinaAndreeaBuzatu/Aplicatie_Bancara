package com.company;

import java.util.*;

public abstract class Cont {

    protected String IBAN;
    protected String Valuta;
    protected double Sold;
    protected Card card[];
    protected double ComisionA;
    protected String DataAcordare;




    public Cont(String IBAN, String Valuta, double Sold,int n, Card card[],String DataAcordare) {
        this.card = new Card[n];
        this.IBAN = IBAN;
        this.Valuta = Valuta;
        this.Sold = Sold;
        for(int i=0;i<n;i++)

            this.card[i]=card[i];
        comisionAdministrareCont();
        this.DataAcordare=DataAcordare;


    }

    public Cont(Cont cont) {
    }

     public int hashCode() {
         return Objects.hash( IBAN, Valuta, Sold);
     }
    public String getIBAN()
    {
        return IBAN;
    }

    public String getValuta()
    {
        return Valuta;
    }
    public double getSold() {
         return Sold;
    }
    public double getComisionA() {
        return ComisionA;
    }
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public void setValuta(String Valuta) {
        this.Valuta = Valuta;
    }
    public void setSold(double Sold) {
        this.Sold = Sold;
    }
    public void setComisionA(double ComisionA) {
        this.ComisionA = ComisionA;
    }
    abstract public double comisionAdministrareCont ();


}

