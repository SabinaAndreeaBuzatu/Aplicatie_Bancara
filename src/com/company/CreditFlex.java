package com.company;

public class CreditFlex extends Credit {

    protected int indiceRecalculareDobanda;

    public CreditFlex( String IBAN, String Valuta, double Sold, int n, Card[] card, int durataluni, String DataAcordare, double SumaAcordata, int indiceRecalculareDobanda,ContCurent contc) {
        super(IBAN, Valuta, Sold, n, card, durataluni, DataAcordare, SumaAcordata,contc);
        if(dobanda==0)
        this.dobanda =dobanda();
        this.indiceRecalculareDobanda=indiceRecalculareDobanda;
        this.tipcont="Credit cu dobanda variabila";
    }

    @Override
    public double comisionAdministrareCont() {
        return 0.1 * Sold;

    }

    @Override
    public double dobanda() {
        return valori.getrobor();//marjaa
    }

}

