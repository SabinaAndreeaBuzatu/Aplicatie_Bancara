package produse;

import client.Client;

public class CreditFix extends Credit {


    public CreditFix(){
        super();
        this.tipcont="Credit cu dobanda fixa";}
    public CreditFix(String IBAN, String Valuta, double Sold,int n, Card[] card , int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super(IBAN, Valuta,Sold, n, card , durataluni,DataAcordare,SumaAcordata,contc);

        dobanda();
        this.tipcont="Credit cu dobanda fixa";
        calcrata();

    }

    @Override
    public void setContCurent(ContCurent contc)
    {
        this.contc.setIBAN(contc.getIBAN());
        this.contc.setSold(contc.getSold());
        this.contc.setValuta(contc.getValuta());
        this.contc.setDataAcordare(contc.getDataAcordare());

    }
    @Override
    public void comisionAdministrareCont ()
    {
        this.ComisionA= 0.01*Sold;

    }

    @Override
    public void setClient(Client c) {

    }

    @Override
    public void dobanda ()
    {
        this.dobanda= Math.round(valori.getircc()+valorib.getMarjaCredit()*100)/100.0;
    }///marja credit e o valoare arbitrara aleasa de banca
    ///ircc este o valoare data de BNR in urma unor indicatori


}
