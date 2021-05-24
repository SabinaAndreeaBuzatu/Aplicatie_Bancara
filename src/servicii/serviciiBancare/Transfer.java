package servicii.serviciiBancare;
import produse.*;
public class Transfer extends Tranzactie {


   protected  Pair<Cont> tranz;

    public Transfer(Cont c, Cont d, String DataTranzactie, String mesaj, double suma) {
        super(c,DataTranzactie, mesaj, suma);

        this.tranz= new Pair<>(c,d);
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
