package servicii.serviciiBancare;

public class Pair < Cont > {
    protected Cont sursa;
    protected Cont destinatie;

    public Pair( Cont sursa , Cont destinatie)
    {
        this.sursa=sursa;
        this.destinatie=destinatie;

    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("\nContul sursa este: \n" + sursa.toString());
        a.append("\nContul destinatie este:\n" + destinatie.toString());

        return a.toString();
    }

    public Cont getDestinatie() {
        return destinatie;
    }

    public Cont getSursa() {
        return sursa;
    }

    public void setDestinatie(Cont destinatie) {
        this.destinatie = destinatie;
    }

    public void setSursa(Cont sursa) {
        this.sursa = sursa;
    }
}
