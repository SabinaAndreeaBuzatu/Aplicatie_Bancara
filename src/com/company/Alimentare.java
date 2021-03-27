package com.company;

public class Alimentare extends Tranzactie{

        protected Cont cont;

        public Alimentare(Cont cont,String DataTranzactie, String mesaj, double suma){
            super(DataTranzactie,mesaj,suma);
            this.cont=cont;
        }
        //service

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(" Contul cu IBAN "+cont.IBAN +" a fost alimentat cu "+suma+cont.Valuta );


        return a.toString();
    }
        }


