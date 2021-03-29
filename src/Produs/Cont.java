package Produs;

import ServiciiBancare.Extras;
import ServiciiBancare.Tranzactie;

import java.util.*;

public abstract class Cont {

    protected String IBAN;
    protected String Valuta;
    protected double Sold;
    protected int nrcarduri;
    protected Card[] card;
    protected double ComisionA;
    protected String DataAcordare;
    protected String tipcont;

    protected Extras extras;



    public Cont(){}
    public Cont(String IBAN, String Valuta, double Sold,int n, Card[] card,String DataAcordare) {
        this.card = new Card[n];
        this.IBAN = IBAN;
        this.Valuta = Valuta;
        this.Sold = Sold;
        nrcarduri=n;
        for(int i=0;i<nrcarduri;i++)

            this.card[i]=card[i];
        comisionAdministrareCont();
        this.DataAcordare=DataAcordare;
        extras=new Extras();



    }

    public Cont(Cont cont) {
    }

     public int hashCode() {
         return Objects.hash( IBAN, Valuta, Sold);
     }
    public String getIBAN()
    {
        return IBAN;
    }
    public String getValuta()
    {
        return Valuta;
    }
    public double getSold() {
         return Sold;
    }
    public double getComisionA() {
        return ComisionA;
    }
    public double getnrcarduri() {
        return nrcarduri;
    }
    public String gettipcont() {
        return tipcont;}

    public Card[] getcard() {return card;}
    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }
    public void setnrcarduri(int nrcarduri) {
        this.nrcarduri = nrcarduri;
    }
    public void setValuta(String Valuta) {
        this.Valuta = Valuta;
    }
    public void setSold(double Sold) {
        this.Sold = Sold;
    }
    public void setComisionA(double ComisionA) {
        this.ComisionA = ComisionA;
    }
    public void settipcont(String tipcont) {this.tipcont=tipcont;}


    abstract public double comisionAdministrareCont ();

    public void adtranz(Tranzactie tranz)
    {int ok=1;
        for (Card i: this.card)
            if(extras.getTraz().equals(i))
            {System.out.println("Tranzactie exista deja. Va rugam alegeti alta tranzactie");
                ok=0;}
        if(extras.getNrtranz()== 0)
        {   this.extras.setTraz(new Tranzactie[100]);
            this.extras.adaugatranz(tranz);

        }
        else
        if(ok==1) {

            this.extras.adaugatranz(tranz);
        }
        }

    @Override
    public boolean equals(Object obj) {
        if(this!=obj)
            return false;
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Cont c =(Cont) obj;

        if(!Objects.equals(this.IBAN, c.IBAN))
            return false;
        if(!Objects.equals(this.DataAcordare, c.DataAcordare))
            return false;
        if(this.Sold!= c.Sold)
            return false;
        if(this.Valuta!= c.Valuta)
            return false;
        if(!Objects.equals(this.card,c.card))
            return false;
        if(!Objects.equals(this.tipcont,c.tipcont))
            return false;
        return true;
    }


    public void adaugareCard(Card card)

    {
        int ok=1;
        for (Card i: this.card)
        if(card.equals(i))
        {System.out.println("Cardul " + card.NrCard + "exista deja. Va rugam alegeti alt card");
        ok=0;}
        if(nrcarduri == 0)
        {   this.card=new Card[100];
            this.card[0]=card;

        }
        else
        if(ok==1) {

            this.card[nrcarduri]=card;
        }
        nrcarduri++;

    }

    public void stergeCard(Card card)
    {
        int ok=1;
        for (int i=0;i<this.nrcarduri;i++)
        {if(card.equals(this.card[i]))
        {ok=0;
              for( int j=i; j< this.nrcarduri-1;j++)
            {   this.card[j]=this.card[j+1];

             }
             i=this.nrcarduri;
           this.card[this.nrcarduri-1]=null;
           nrcarduri--;}}
        if(ok==1) { System.out.println("Cardul " + card.NrCard + " nu exista. Va rugam alegeti alt card ");

        }}

    @Override
    public String toString() {
        StringBuilder a= new StringBuilder();
        a.append("\n" + this.tipcont+" cu IBAN " +this.IBAN + ", Data deschiderii contului " + this.DataAcordare + ", Soldul curent este: " +this.Sold + " in valuta "+ Valuta + " si are un comision de administrare lunar de " +comisionAdministrareCont()+ Valuta);
        a.append("\nAcesta are atasat " + this.nrcarduri + " carduri.");
        for( int j=0; j< nrcarduri;j++)

            a.append("\n"+card[j]);

        return a.toString();
    }

    public void extras(String Data){
        extras.setData(Data);
        System.out.println(extras.toString());

    }
    public void retragere(double suma){

        if (Sold>=suma)
            Sold=Sold-suma;
    }
    public void alimentare(double suma){


            Sold=Sold+suma;
    }
    }





