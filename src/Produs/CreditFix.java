package Produs;

public class CreditFix extends Credit {



    public CreditFix(String IBAN, String Valuta, double Sold,int n, Card[] card , int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super(IBAN, Valuta,Sold, n, card , durataluni,DataAcordare,SumaAcordata,contc);
        if(dobanda==0)
        this.dobanda=dobanda();
        this.tipcont="Credit cu dobanda fixa";
    }
    @Override
    public double comisionAdministrareCont ()
    {
        return 0.1*Sold;

    }
    @Override
    public double dobanda ()
    {
        return valori.getircc();
    }



}
