package ServiciiBancare;
import Produs.*;
public class Extras  {

    protected String Data;
    protected Cont cont;
    protected Tranzactie[] traz;

    public Extras(String Data, Cont cont,Tranzactie[] traz) {

        this.cont = cont;
        this.Data = Data;

        for(int i=0;i<traz.length;i++)
            if(traz[i].equals(cont))
        this.traz=traz;
            else
                System.out.println("O tranzactie nu apartine contului de la care se doreste extrasul");

    }
    public String getData(){ return Data;}

    public Cont getCont() {
        return cont;
    }

}