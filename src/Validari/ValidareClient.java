package Validari;

public class ValidareClient {
    public void vNume(String nume) {
        if (!nume.matches("^[a-zA-Z]+$"))
            System.out.println("Numele nu este valid");
    }
    public void vPrenume(String prenume) {
        if (!prenume.matches("^[a-zA-Z]+$"))
            System.out.println("Preumele nu este valid");
    }
    public void vDataNasterii(String DataNasterii) {
        if (!DataNasterii.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida");
    }
}
