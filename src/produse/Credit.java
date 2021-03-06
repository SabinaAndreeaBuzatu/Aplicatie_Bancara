package produse;
import generareValori.*;

public abstract class Credit extends Cont{

    protected int durataluni;
    protected double SumaAcordata;
    protected double dobanda;
    protected BNRval valori;
    protected BancaVal valorib;
    protected String IBANcontc;
    protected double ratac;
    protected int ratePlatite;

    public Credit(){

        valori=new BNRval();
        valorib=new BancaVal();
    }
    public Credit (String IBAN, String Valuta, double Sold,int n, Card[] card ,int durataluni, String DataAcordare, double SumaAcordata, String IBANcontc )
    {
        super( IBAN, Valuta, Sold, n, card, DataAcordare);
        this.durataluni=durataluni;
        this.SumaAcordata=SumaAcordata;
        valori=new BNRval();
        valorib=new BancaVal();
        this.IBANcontc=IBANcontc;
        ratePlatite =0;





    }

    public void setRatePlatite(int ratePlatite) {
        this.ratePlatite = ratePlatite;
    }
    public int getRatePlatite()
    {return ratePlatite;
    }

    public void setIBANcontc(String IBANcontc) {
        this.IBANcontc = IBANcontc;
    }

    public String getIBANcontc() {
        return IBANcontc;
    }

    public abstract void dobanda();
    public double getSumaAcordata()
    {
        return SumaAcordata;
    }
    public void setSumaAcordata(double Suma){this.SumaAcordata=Suma;}

    public int getDurataluni() {
        return durataluni;
    }

    public void setDurataluni(int durataluni) {
        this.durataluni = durataluni;
    }

    public double getDobanda() {
        return dobanda;
    }
    public  void setDobanda(double dobanda) {
        this.dobanda=dobanda;
    }
    public double getRatac(){ return ratac;}
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append("Creditul se desfasoara pe  " + this.durataluni + " luni, suma acordata este " + this.SumaAcordata + this.Valuta+". Dobanda pentru acest credit este " +this.dobanda + " Rata in valoare de "+ratac+" va fi colectata din contul curent cu IBAN "+ IBANcontc);

        return a.toString();
    }
    public void calcrata()
    {
        this.ratac=Math.round(this.SumaAcordata/durataluni+dobanda/100*(SumaAcordata/durataluni*durataluni- ratePlatite)*100)/100.0;
    }



}
