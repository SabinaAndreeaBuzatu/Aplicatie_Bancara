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

///////////////in clasa servicii fa transfer
    /*@Override
    public void tranzactie(double suma) {
        if (tranz.sursa.Valuta.equals(tranz.destinatie.Valuta))
        {tranz.sursa.Sold-=suma;
            tranz.destinatie.Sold+=suma;}
        else System.out.println("Contul sursa are valuta "+tranz.sursa.Valuta+" iar contul destinatie are valuta "+tranz.destinatie.Valuta+". Nu se poate efectua transferul.");

    }*/
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(tranz.toString());
        a.append("\nA fost transferata suma de "+suma+" "+tranz.sursa.getValuta() +" din contul cu IBAN "+ tranz.sursa.getIBAN()+" in contul cu IBAN "+tranz.destinatie.getIBAN());
        tranz.toString();


        return a.toString();
    }

}
