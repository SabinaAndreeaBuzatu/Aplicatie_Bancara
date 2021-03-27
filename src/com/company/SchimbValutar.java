package com.company;

public class SchimbValutar extends Tranzactie {
    Pair<Cont> tranz;

    public SchimbValutar(Pair<Cont> tranz, String DataTranzactie, String mesaj, double suma) {
        super(DataTranzactie, mesaj, suma);
        this.tranz=tranz;
    }
    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append(super.toString());
        a.append(tranz.toString());
        a.append(" A fost transferata suma de "+suma+" "+tranz.sursa.Valuta +" din contul cu IBAN "+ tranz.sursa.IBAN+" in contul cu IBAN "+tranz.destinatie.IBAN+" convertita in valuta contului destinatie");
        tranz.toString();
        return a.toString();
    }











}
