package validari;
import client.*;

import java.util.List;

public class ValidareClient {
    private void vNume(String nume) {
        if (!nume.matches("^[a-zA-Z]+$"))
            System.out.println("Numele nu este valid:"+nume);
    }

    private void vPrenume(String prenume) {
        if (!prenume.matches("^[a-zA-Z-]+$"))
            System.out.println("Preumele nu este valid: "+prenume);
    }

    private void vDataNasterii(String DataNasterii) {
        if (!DataNasterii.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida "+DataNasterii);
    }
    private void vCNP(String cnp)
    { if (!cnp.matches("^[0-9]+$"))
        System.out.println("CNP-ul nu este valid "+ cnp);}

    public void vComplet(Client c) {
        vNume(c.getNume());
        vPrenume(c.getPrenume());
        vDataNasterii(c.getDataNasterii());
        vCNP(c.getCNP());
    }
    public void vListComplet(List<Client> c)
    {
        for(int i=0;i<c.size();i++)
            vComplet(c.get(i));
    }
}