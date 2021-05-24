package produse;

import client.Client;

public class CreditFix extends Credit {


    public CreditFix(){
        super();
        this.tipcont="Credit cu dobanda fixa";}
    public CreditFix(String IBAN, String Valuta, double Sold,int n, Card[] card , int durataluni, String DataAcordare, double SumaAcordata, String IBANcontc)
    {
        super(IBAN, Valuta,Sold, n, card , durataluni,DataAcordare,SumaAcordata,IBANcontc);

        dobanda();
        this.tipcont="Credit cu dobanda fixa";
        calcrata();

    }

    @Override
    public void setIBANcontc(String contc)
    {
        this.IBANcontc=contc;


    }
    @Override
    public void comisionAdministrareCont ()
    {
        this.ComisionA= 0.01*Sold;

    }





    @Override
    public void dobanda ()
    {
        this.dobanda= Math.round(valori.getircc()+valorib.getMarjaCredit()*100)/100.0;
    }///marja credit e o valoare arbitrara aleasa de banca
    ///ircc este o valoare data de BNR in urma unor indicatori


}
