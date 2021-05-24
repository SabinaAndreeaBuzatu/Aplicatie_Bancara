package servicii.serviciiBancare;
import produse.*;
public class Retragere extends Tranzactie {

    public Retragere(){}
    public Retragere(Cont c,String DataTranzactie, String mesaj, double suma){
        super(c,DataTranzactie,mesaj,suma);

    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(" Din contul cu IBAN "+c.getIBAN() +" a fost retrasa suma de "+suma+c.getValuta() );


        return a.toString();
    }
}
