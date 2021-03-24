package com.company;

public class InchiriereCutieValori {
    protected double PragValoriDeclarat;
    protected double comision;
    protected String DataAcordare;
    protected String Adresa;
    protected ContCurent contc;

    public InchiriereCutieValori(double PragValoriDeclarat, String DataAcordare, String Adresa, ContCurent contc)
    {
        this.PragValoriDeclarat=PragValoriDeclarat;
        this.DataAcordare=DataAcordare;
        this.Adresa=Adresa;
        this.contc=contc;
        this.comision=comision();


    }

    public double comision()
    {
        return 0.1*PragValoriDeclarat;
    }


}
