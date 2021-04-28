package produse;


public class InchiriereCutieValori {
    protected double pragValoriDeclarat;
    protected String valuta;
    protected double comision;
    protected String DataAcordare;
    protected String Adresa;
    protected ContCurent contc;

    public InchiriereCutieValori(){  comision();}
    public InchiriereCutieValori(double pragValoriDeclarat, String valuta ,String DataAcordare, String Adresa, ContCurent contc)
    {
        this.pragValoriDeclarat=pragValoriDeclarat;
        this.valuta=valuta;
        this.DataAcordare=DataAcordare;
        this.Adresa=Adresa;
        this.contc=contc;
        comision();


    }

    public void comision()
    {
        this.comision= 0.1*pragValoriDeclarat;
    }

    public void setAdresa(String adresa) {
        Adresa = adresa;
    }

    public void setComision(double comision) {
        this.comision = comision;
    }

    public String getValuta() {
        return valuta;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
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
        this.pragValoriDeclarat= pragValoriDeclarat;

    }



    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();

        a.append("\nPragul de valori declarat este  " + this.pragValoriDeclarat+ valuta+". Cutia are un comision de asdministrare de "+comision+valuta+". Data acordarii cutiei este "+DataAcordare+" iar adresa sucursalei la care se afla cutia este "+Adresa+". Comisionul de administrare va fi colectat din contul curent cu IBAN "+ contc.getIBAN());

        return a.toString();
    }

}
