package client;

public class Client {

    private String nume;
    private String prenume;
    private String dataNasterii;
    private String CNP;
    


   public Client(){}
    public Client( String nume, String prenume, String dataNasterii, String CNP )
    {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.CNP=CNP;

    }

    public String getNume()
    {
        return nume;
    }
    public String getPrenume()
    {
        return prenume;
    }
    public String getDataNasterii()
    {
        return dataNasterii;
    }
    public String getCNP() {return CNP;}
    public void setNume(String nume) {
        this.nume = nume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public void setDataNasterii(String dataNasterii) {
        this.dataNasterii = dataNasterii;
    }
    public void setCNP(String CNP) {this.CNP=CNP;}

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("\nClientul: "+nume+" "+prenume+" avand CNP "+CNP+" si data nasterii "+dataNasterii);


        return a.toString();
    }
    }
