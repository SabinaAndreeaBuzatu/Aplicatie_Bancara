package com.company;
import java.util.*;
public class Client {

    protected String Nume;
    protected String Prenume;
    protected String DataNasterii;
    protected String CNP;



    public Client( String Nume, String Prenume, String DataNasterii )
    {
        this.Nume = Nume;
        this.Prenume = Prenume;
        this.DataNasterii = DataNasterii;

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
    public void setNume(String Nume) {
        this.Nume = Nume;
    }
    public void setPrenume(String Prenume) {
        this.Prenume = Prenume;
    }
    public void setDataNasterii(String DataNasterii) {
        this.DataNasterii = DataNasterii;
    }
    }
