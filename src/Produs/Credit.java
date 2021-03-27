package Produs;
import com.company.*;
public abstract class Credit extends Cont{

    protected int durataluni;
    protected double SumaAcordata;
    protected double dobanda;
    protected BNRval valori;
    protected ContCurent contc;
    protected double ratac;
    static int rateplatite;


    public Credit (String IBAN, String Valuta, double Sold,int n, Card[] card ,int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super( IBAN, Valuta, Sold, n, card, DataAcordare);
        this.durataluni=durataluni;
        this.SumaAcordata=SumaAcordata;
        this.ComisionA=comisionAdministrareCont();
        valori=new BNRval();
        this.contc=contc;
        calcrata();
        rateplatite=0;



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
    public double getRatac(){ return ratac;}
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append("Creditul se desfasoara pe  " + this.durataluni + " luni, suma acordata este " + this.SumaAcordata + this.Valuta+". Dobanda pentru acest credit este " +this.dobanda + " Rata in valoare de "+ratac+" va fi colectata din contul curent cu IBAN "+ contc.IBAN);

        return a.toString();
    }
    public void calcrata()
    {
        this.ratac=this.SumaAcordata/durataluni+dobanda*(durataluni-rateplatite);
    }
    public void platarata(){
        calcrata();
        if(durataluni > rateplatite)
            if(contc.getSold()>=ratac) {
                contc.setSold(contc.getSold() - ratac);
                rateplatite++;
                System.out.println("Rata a fost colectata!:)");
            }
        else System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita rata");
    }

}