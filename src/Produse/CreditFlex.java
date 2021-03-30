package Produse;

public class CreditFlex extends Credit {



    public CreditFlex( String IBAN, String Valuta, double Sold, int n, Card[] card, int durataluni, String DataAcordare, double SumaAcordata,ContCurent contc) {
        super(IBAN, Valuta, Sold, n, card, durataluni, DataAcordare, SumaAcordata,contc);
        dobanda();
        calcrata();

        this.tipcont="Credit cu dobanda variabila";
    }

    @Override
    public void comisionAdministrareCont() {
        this.ComisionA= 0.01 * Sold;

    }

    @Override
    public void platarata(){


        if(durataluni > rateplatite)
            if(contc.getSold()>=ratac) {
                contc.setSold(contc.getSold() - ratac);
                rateplatite++;
                System.out.println("Rata a fost colectata!:)");
                dobanda();

                calcrata();

            }
            else System.out.println("Fonduri insuficiente! Va rugam sa alimentati contul pentru a putea achita rata");
    }
    @Override
    public void dobanda() {
    valori.calcrobor();  valorib.marja();
         this.dobanda=Math.round(valori.getrobor()+valorib.getMarjacredit()*100)/100.0;



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

