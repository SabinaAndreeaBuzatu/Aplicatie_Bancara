package validari;

import produse.Cont;
import produse.Credit;
import produse.Depozit;

import java.util.List;

public class ValidareDepozit extends ValidareCont  {
    @Override
    public void vComplet(Cont c) {


    }


    public void vComplet(Depozit c) {
        vIBAN(c.getIBAN());
        vDataAcordare(c.getDataAcordare());
        vValuta(c.getValuta());
        vSold(c.getSold());
    }
    public void vListCompletDepozit(List<Depozit> c)
    {
        for(int i=0;i<c.size();i++)
            vComplet(c.get(i));
    }

}
