package Validari;
import Client.*;
public class ValidareClient {
    public void vNume(String nume) {
        if (!nume.matches("^[a-zA-Z]+$"))
            System.out.println("Numele nu este valid");
    }

    public void vPrenume(String prenume) {
        if (!prenume.matches("^[a-zA-Z-]+$"))
            System.out.println("Preumele nu este valid");
    }

    public void vDataNasterii(String DataNasterii) {
        // acest regex nu functioneaza - dar nici nu ti recomand sa faci regexuri pentru date. Mai bine folosesti tipurile de date pentru time (OffsetDate, LocalDate, ZonedDateTime, etc - de la java 8+)
        if (!DataNasterii.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida");
    }
    public void vCNP(String cnp)
            // eeh..clar asta nu e o validare de CNP. macar un cnp.length == 13 pt un minim de validare
    { if (!cnp.matches("^[0-9]+$"))
        System.out.println("CNP-ul nu este valid");}

    public void vComplet(Client c) {
        vNume(c.getNume());
        vPrenume(c.getPrenume());
        vDataNasterii(c.getDataNasterii());
        vCNP(c.getCNP());
    }
}
