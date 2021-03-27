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

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public ContCurent getContc() {
        return contc;
    }

    public double getComision() {
        return comision;
    }

    public double getPragValoriDeclarat() {
        return PragValoriDeclarat;
    }

    public void setContc(ContCurent contc) {
        this.contc = contc;
    }

    public String getAdresa() {
        return Adresa;
    }

    public String getDataAcordare() {
        return DataAcordare;
    }

    public void setDataAcordare(String dataAcordare) {
        DataAcordare = dataAcordare;
    }

    public void setPragValoriDeclarat(double pragValoriDeclarat) {
        PragValoriDeclarat = pragValoriDeclarat;
    }

}
