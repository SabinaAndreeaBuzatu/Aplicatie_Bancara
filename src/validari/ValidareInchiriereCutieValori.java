package validari;

import produse.InchiriereCutieValori;

public class ValidareInchiriereCutieValori {
    public void vDataAcordare(String DataAcordare) {
        if (!DataAcordare.matches("^([0123]\\d)[- /.]([01]\\d)[- /.]([012]\\d\\d\\d)$"))
            System.out.println("Data acordarii nu este valida");
    }

    public void vPrag(double prag) {
        if (prag < 0)
            System.out.println("Pragul de valori declarat nu este valid");
    }

    public void vValuta(String Valuta) {
        if (!Valuta.matches("^[A-Z]+$"))
            System.out.println("Valuta nu este valida");
    }

    public void vAdresa(String adresa) {
        if (!adresa.matches("^[#.0-9a-zA-Z\\s,-]+$"))
            System.out.println("Adresa nu este valida");
    }
    public void vComplet(InchiriereCutieValori c){


        vDataAcordare(c.getDataAcordare());
        vPrag(c.getPragValoriDeclarat());
        vAdresa(c.getAdresa());
        vValuta(c.getValuta());
    }
}
