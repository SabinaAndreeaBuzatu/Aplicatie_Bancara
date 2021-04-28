package validari;

import produse.Depozit;

public class ValidareDepozit extends ValidareCont implements ValidareDepInterface {

    @Override
    public void vComplet(Depozit c) {
        vIBAN(c.getIBAN());
        vDataAcordare(c.getDataAcordare());
        vValuta(c.getValuta());
        vSold(c.getSold());
    }

    }
