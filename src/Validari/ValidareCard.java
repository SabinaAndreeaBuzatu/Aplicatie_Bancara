package Validari;
import Produse.*;
public class ValidareCard {
    public void vDataExpirare(String D) {
        if (!D.matches("^(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$"))
            System.out.println("Data expirarii nu este valida");}

//            123456789 15 20 nu e chiar un nr de card valid
        public void vNrCard(String nr) {
            if (!nr.matches("^[0-9 ]+$"))
                System.out.println("Numarul cardului nu este valid ");
        }
    public void vPin(String nr) {
        if (!nr.matches("^[0-9]+$")&&nr.length()>4)
            System.out.println("Pin-ul nu este valid ");
    }
    // 000 e un CVV valid?
    public void vCVV(String nr) {
        if (!nr.matches("^[0-9]+$")&&nr.length()>3)
            System.out.println("CVV-ul nu este valid ");
    }

    // superb - atunci poti sa le faci pe celelalte private si sa expui o singura metoda de validare Card
    public void vComplet(Card c) {
       vDataExpirare(c.getDataExp());
       vPin(c.getPin());
       vCVV(c.getCVV());
       vNrCard(c.getNrCard());
    }
    }


