package ServiciiBancare;
import Produs.*;
import java.util.*;

public abstract class Tranzactie {
    protected Cont c;
    protected String DataTranzactie;
    protected String mesaj;
    protected double suma;
    public Tranzactie(){}
    public Tranzactie( Cont c, String DataTranzactie, String mesaj, double suma)
    {
        this.c=c;
        this.DataTranzactie=DataTranzactie;
        this.mesaj=mesaj;
        this.suma=suma;
    }
    public String getDataTranzactie()
    {
        return DataTranzactie;
    }
    public String getmesaj()
    {
        return mesaj;
    }
    public double getsuma() {
        return suma;
    }
    public void setDataTranzactie(String DataTranzactie) {
        this.DataTranzactie = DataTranzactie;
    }
    public void setmesaj(String mesaj) {
        this.mesaj = mesaj;
    }
    public void setsuma(double suma) {
        this.suma = suma;
    }

    public Cont getC() {
        return c;
    }

    public void setC(Cont c) {
        this.c = c;
    }

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("Tranzactia a fost facuta la data de "+DataTranzactie+ " avand mesajul '' "+mesaj + "''.");



        return a.toString();
    }


      }



