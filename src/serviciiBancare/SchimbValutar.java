package serviciiBancare;
import produse.*;

public class SchimbValutar extends Tranzactie {
    protected Pair<Cont> tranz;
    protected  double sumaTrans;


    public SchimbValutar
            (){}
    public SchimbValutar(Cont c,Cont d, String DataTranzactie, String mesaj, double suma) {
        super(c,DataTranzactie, mesaj, suma);
         this.tranz= new Pair<>(c,d);

    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
       // a.append(tranz.toString());
        a.append("\nA fost transferata suma de "+suma+" "+tranz.sursa.getValuta() +" din contul cu IBAN "+ tranz.sursa.getIBAN()+" in contul cu IBAN "+tranz.destinatie.getIBAN()+" transformata in "+sumaTrans+" valuta contului destinatie");
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
