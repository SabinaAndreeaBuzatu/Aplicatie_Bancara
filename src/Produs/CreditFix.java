package Produs;
import GenerareValori.*;

public class CreditFix extends Credit {



    public CreditFix(String IBAN, String Valuta, double Sold,int n, Card[] card , int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super(IBAN, Valuta,Sold, n, card , durataluni,DataAcordare,SumaAcordata,contc);

        this.dobanda=dobanda();
        this.tipcont="Credit cu dobanda fixa";
        calcrata();

    }
    @Override
    public void comisionAdministrareCont ()
    {
        this.ComisionA= 0.01*Sold;

    }
    @Override
    public double dobanda ()
    {
        return valori.getircc()+valorib.getMarjacredit();
    }
    @Override
    public void platarata(){

        if(durataluni > rateplatite)
            if(contc.getSold()>=ratac) {
                contc.setSold(contc.getSold() - ratac);
                rateplatite++;
                System.out.println("Rata a fost colectata!:)");
            }
            else System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita rata");
    }
    @Override
    public void colectareComision(){

        this.contc.setSold(contc.getSold()-ComisionA);
    }


}
