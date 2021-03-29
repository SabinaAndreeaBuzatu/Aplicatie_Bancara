package Validari;

public class ValidareCard {
    public void vDataAcordare(String DataAcordare) {
        if (!DataAcordare.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida");
    }

}
