package com.company;

import java.util.*;

public class Tranzactie {
    protected Pair<Cont> tranz;
    protected String DataTranzactie;
    protected String mesaj;
    protected double suma;

    public Tranzactie(Pair<Cont> tranz, String DataTranzactie, String mesaj, double suma)
    {
        this.tranz=tranz;
        this.DataTranzactie=DataTranzactie;
        this.mesaj=mesaj;
        this.suma=suma;
    }
    public String getDataTranzactie()
    {
        return DataTranzactie;
    }
    public String getmesaj()
    {
        return mesaj;
    }
    public double getsuma() {
        return suma;
    }
    public void setDataTranzactie(String DataTranzactie) {
        this.DataTranzactie = DataTranzactie;
    }
    public void setmesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    public void setsuma(double suma) {
        this.suma = suma;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("Tranzactia a fost facuta la data de "+DataTranzactie+ "avand mesajul '' "+mesaj + "''.");
        tranz.toString();


        return a.toString();
    }


      }



