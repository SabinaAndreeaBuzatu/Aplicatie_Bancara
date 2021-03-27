package ServiciiBancare;
import Produs.*;
public class Transfer extends Tranzactie {

    Pair<Cont> tranz;

    public Transfer(Pair<Cont> tranz, String DataTranzactie, String mesaj, double suma) {
        super(DataTranzactie, mesaj, suma);
        this.tranz=tranz;
    }
    public Transfer(){ }
    public boolean egalitatevaluta()

    {
        if( tranz.sursa.getValuta().equals(tranz.destinatie.getValuta()))
            return true;
        else
            return false;
    }


    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());

        a.append("\nA fost transferata suma de "+suma+" "+tranz.sursa.getValuta() +" din contul cu IBAN "+ tranz.sursa.getIBAN()+" in contul cu IBAN "+tranz.destinatie.getIBAN());
        tranz.toString();


        return a.toString();
    }

}
