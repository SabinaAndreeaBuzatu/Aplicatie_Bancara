package validari;
import produse.*;
public class ValidareCard {
    public void vDataExpirare(String D) {
        if (!D.matches("^(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))
            System.out.println("Data expirarii nu este valida");}

        public void vNrCard(String nr) {
            if (!nr.matches("^[0-9 ]+$"))
                System.out.println("Numarul cardului nu este valid ");
        }
    public void vPin(String nr) {
        if (!nr.matches("^[0-9]+$")&&nr.length()>4)
            System.out.println("Pin-ul nu este valid ");
    }
    public void vCVV(String nr) {
        if (!nr.matches("^[0-9]+$")&&nr.length()>3)
            System.out.println("CVV-ul nu este valid ");
    }

    public void vComplet(Card c) {
       vDataExpirare(c.getDataExp());
       vPin(c.getPin());
       vCVV(c.getCVV());
       vNrCard(c.getNrCard());
    }
    }


