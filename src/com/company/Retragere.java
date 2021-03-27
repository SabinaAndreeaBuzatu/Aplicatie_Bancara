package com.company;

public class Retragere extends Tranzactie{
    protected Cont cont;

    public Retragere(Cont cont,String DataTranzactie, String mesaj, double suma){
        super(DataTranzactie,mesaj,suma);
        this.cont=cont;
    }
//service


    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(" Din contul cu IBAN "+cont.IBAN +" a fost retrasa suma de "+suma+cont.Valuta );


        return a.toString();
    }
}
