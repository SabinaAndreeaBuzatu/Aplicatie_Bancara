package Validari;
import Produse.*;

// de ce extinde ValidareCont daca nu folosesti nimic din parinte?
public class ValidareCredit extends ValidareCont{
    public void vDurataLuni(double durataluni) {
        if (durataluni < 0)
            System.out.println("Numarul de luni nu este valid");
    }
    public void vSuma(double suma) {
        if (suma < 0)
            System.out.println("Suma acordata nu este valida");

    }
    public void vComplet(Credit c){
        vDurataLuni(c.getDurataluni());
        vSuma(c.getSumaAcordata());

    }
}
