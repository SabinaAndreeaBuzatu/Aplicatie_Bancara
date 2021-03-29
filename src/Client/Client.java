package Client;
import Produs.Cont;

import java.util.*;
public class Client {

    protected String Nume;
    protected String Prenume;
    protected String DataNasterii;
    protected String CNP;
    protected ArrayList<Cont> Conturi;



    public Client( String Nume, String Prenume, String DataNasterii, String CNP )
    {
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.DataNasterii = DataNasterii;
        this.CNP=CNP;

    }

    public String getNume()
    {
        return Nume;
    }
    public String getPrenume()
    {
        return Prenume;
    }
    public String getDataNasterii()
    {
        return DataNasterii;
    }
    public String getCNP() {return CNP;}
    public void setNume(String Nume) {
        this.Nume = Nume;
    }
    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }
    public void setDataNasterii(String DataNasterii) {
        this.DataNasterii = DataNasterii;
    }
    public void setCNP(String CNP) {this.CNP=CNP;}

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("\nClientul: "+Nume+" "+Prenume+" avand CNP "+CNP+" si data nasterii "+DataNasterii);


        return a.toString();
    }
    }
