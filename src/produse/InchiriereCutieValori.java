package produse;


import java.util.UUID;

public class InchiriereCutieValori {
    private static String nrCutie;
    private static final UUID UUID = null;
    protected double pragValoriDeclarat;
    protected String valuta;
    protected double comision;
    protected String DataAcordare;
    protected String Adresa;
    protected String IBANcontc;

    public InchiriereCutieValori(){  comision();}
    public InchiriereCutieValori(double pragValoriDeclarat, String valuta ,String DataAcordare, String Adresa, String contc)
    {   nrCutie= UUID.randomUUID().toString();
        this.pragValoriDeclarat=pragValoriDeclarat;
        this.valuta=valuta;
        this.DataAcordare=DataAcordare;
        this.Adresa=Adresa;
        this.IBANcontc=contc;
        comision();


    }

    public  String getNrCutie() {
        return nrCutie;
    }

    public  void setNrCutie(String nrCutie) {
        InchiriereCutieValori.nrCutie = nrCutie;
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

    public String getContc() {
        return IBANcontc;
    }

    public double getComision() {
        return comision;
    }

    public double getPragValoriDeclarat() {
        return pragValoriDeclarat;
    }

    public void setContc(String contc) {
        this.IBANcontc = contc;
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

        a.append("\nCutia de valori cu numarul "+nrCutie+"are pragul de valori declarat  " + this.pragValoriDeclarat+ valuta+".Aceasta are un comision de asdministrare de "+comision+valuta+". Data acordarii cutiei este "+DataAcordare+" iar adresa sucursalei la care se afla cutia este "+Adresa+". Comisionul de administrare va fi colectat din contul curent cu IBAN "+ IBANcontc);

        return a.toString();
    }

}
