package validari;
import produse.*;

import java.util.List;

public class ValidareCredit extends ValidareCont {
    private void vDurataLuni(double durataluni) {
        if (durataluni < 0)
            System.out.println("Numarul de luni nu este valid");
    }

    private void vSuma(double suma) {
        if (suma < 0)
            System.out.println("Suma acordata nu este valida");

    }

    public void vComplet(Credit c) {
        vComplet((Cont)c);
        vDurataLuni(c.getDurataluni());
        vSuma(c.getSumaAcordata());

    }

    public void vListCompletCredit(List<Credit> c)
    {
        for(int i=0;i<c.size();i++)
            vComplet(c.get(i));
    }

}
