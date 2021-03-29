package Produs;


public class InchiriereCutieValori {
    protected double pragValoriDeclarat;
    protected String valuta;
    protected double comision;
    protected String DataAcordare;
    protected String Adresa;
    protected ContCurent contc;

    public InchiriereCutieValori(double pragValoriDeclarat, String valuta ,String DataAcordare, String Adresa, ContCurent contc)
    {
        this.pragValoriDeclarat=pragValoriDeclarat;
        this.valuta=valuta;
        this.DataAcordare=DataAcordare;
        this.Adresa=Adresa;
        this.contc=contc;
        this.comision=comision();


    }

    public double comision()
    {
        return 0.1*pragValoriDeclarat;
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
        return pragValoriDeclarat;
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
        pragValoriDeclarat = pragValoriDeclarat;
    }

}
