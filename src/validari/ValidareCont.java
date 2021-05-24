package validari;
import produse.*;

import java.util.List;

public class ValidareCont {


   protected void vIBAN(String IBAN) {
        if (!IBAN.matches("^[A-Z]{2}[0-9]{2}[A-Z]{4}[0-9]{16,18}$"))
            System.out.println("IBAN-ul nu este valid "+IBAN);
    }

    protected void vDataAcordare(String DataAcordare) {
        if (!DataAcordare.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida "+DataAcordare);
    }

    protected void vSold(double Sold) {
        if (Sold < 0)
            System.out.println("Soldul nu este valid "+Sold);
    }

    protected void vValuta(String Valuta) {
        int ok=0;
        String[] valuta = {"RON", "EURO", "USD", "GBP","CHF","RUB"};
        for(String i: valuta)
        if (Valuta.matches(i))
        ok=1;
        if(ok==0)
         System.out.println("Valuta nu este valida "+Valuta);
    }

   public void vComplet(Cont c) {
        vIBAN(c.getIBAN());
        vDataAcordare(c.getDataAcordare());
        vValuta(c.getValuta());
        vSold(c.getSold());

    }
    public void vListComplet(List<ContCurent> c)
    {for (int i=0;i<c.size();i++)
         vComplet(c.get(i));
    }
}



