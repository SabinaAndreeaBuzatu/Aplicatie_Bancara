package Produs;

public class CreditFlex extends Credit {



    public CreditFlex( String IBAN, String Valuta, double Sold, int n, Card[] card, int durataluni, String DataAcordare, double SumaAcordata,ContCurent contc) {
        super(IBAN, Valuta, Sold, n, card, durataluni, DataAcordare, SumaAcordata,contc);
        if(dobanda==0)
        this.dobanda =dobanda();

        this.tipcont="Credit cu dobanda variabila";
    }

    @Override
    public double comisionAdministrareCont() {
        return 0.01 * Sold;

    }

    @Override
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
    @Override
    public double dobanda() {
        return valori.getrobor()+valorib.getMarjacredit();
    }

}

