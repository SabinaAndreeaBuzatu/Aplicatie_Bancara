package ServiciiBancare;
import Produs.*;
public class Extras  {

    protected String Data;
    protected int nrtranz;
    protected Tranzactie[] traz;

    public Extras(){
        traz=new Tranzactie[100];
    }
    public Extras(String Data,Tranzactie[] traz) {


        this.Data = Data;


        this.traz=traz;

    }
    public String getData(){ return Data;}



    public Tranzactie[] getTraz() {
        return traz;
    }

    public void setTraz(Tranzactie[] traz) {
        this.traz = traz;
    }
    public void adaugatranz(Tranzactie t)
    { traz[nrtranz]=t;
    nrtranz++;

    }

    public int getNrtranz() {
        return nrtranz;
    }

    public void setData(String data) {
        Data = data;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();

        a.append("\nData eliberarii extrasului "+Data);
        a.append("\nTranzactii: " );
        for( int j=0; j< nrtranz;j++)

            a.append("\n"+traz[j]);




        return a.toString();
    }
}