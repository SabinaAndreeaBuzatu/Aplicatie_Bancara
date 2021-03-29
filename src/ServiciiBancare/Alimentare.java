package ServiciiBancare;

import Produse.*;

public class Alimentare extends Tranzactie {


    public Alimentare(){}
        public Alimentare(Cont c,String DataTranzactie, String mesaj, double suma){
            super(c,DataTranzactie,mesaj,suma);

        }


    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(" Contul cu IBAN "+c.getIBAN() +" a fost alimentat cu "+suma+c.getValuta() );


        return a.toString();
    }
        }


