package ServiciiBancare;
import Produs.*;

public class SchimbValutar extends Tranzactie {
    Pair<Cont> tranz;

    public SchimbValutar(Cont c,Cont d, String DataTranzactie, String mesaj, double suma) {
        super(c,DataTranzactie, mesaj, suma);
         this.tranz= new Pair<>(c,d);

    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(tranz.toString());
        a.append(" A fost transferata suma de "+suma+" "+tranz.sursa.getValuta() +" din contul cu IBAN "+ tranz.sursa.getIBAN()+" in contul cu IBAN "+tranz.destinatie.getIBAN()+" convertita in valuta contului destinatie");
        tranz.toString();
        return a.toString();
    }

    public Pair<Cont> getTranz() {
        return tranz;
    }

    public void setTranz(Pair<Cont> tranz) {
        this.tranz = tranz;
    }
}
