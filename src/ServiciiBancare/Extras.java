package ServiciiBancare;
import Produs.*;
public class Extras  {

    protected String Data;
    protected Cont cont;
    protected Tranzactie[] traz;

    public Extras(String Data, Cont cont,Tranzactie[] traz) {
        this.cont = cont;
        this.Data = Data;
        this.traz=traz;

    }

}