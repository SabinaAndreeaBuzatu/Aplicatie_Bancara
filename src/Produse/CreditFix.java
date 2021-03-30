package Produse;

public class CreditFix extends Credit {



    public CreditFix(String IBAN, String Valuta, double Sold,int n, Card[] card , int durataluni, String DataAcordare, double SumaAcordata, ContCurent contc)
    {
        super(IBAN, Valuta,Sold, n, card , durataluni,DataAcordare,SumaAcordata,contc);

        dobanda();
        this.tipcont="Credit cu dobanda fixa";
        calcrata();

    }
    @Override
    public void comisionAdministrareCont ()
    {
        this.ComisionA= 0.01*Sold;

    }
    @Override
    public void dobanda ()
    {
        this.dobanda= Math.round(valori.getircc()+valorib.getMarjacredit()*100)/100.0;
    }///marja credit e o valoare arbitrara aleasa de banca
    ///ircc este o valoare data de BNR in urma unor indicatori
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
        if(contc.Sold>=ComisionA)
        { this.contc.setSold(contc.getSold()-ComisionA);
            System.out.println("Comisionul a fost colectat:)");}
        else
            System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita comisionul de administrare");

    }


}
