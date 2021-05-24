package produse;

import client.Client;
import servicii.serviciiBancare.Extras;
import servicii.serviciiBancare.Tranzactie;
import validari.ValidareCont;

import java.util.*;

public abstract class Cont {

    protected String IBAN;
    protected String Valuta;
    protected double Sold;
    protected int nrcarduri;
    protected List<Card> carduri =new ArrayList<>();
    protected double ComisionA;
    protected String DataAcordare;
    protected String tipcont;

    protected Extras extras=new Extras();


    public Cont() {
    }

    public Cont(String IBAN, String Valuta, double Sold, int n, Card[] card, String DataAcordare) {
        this.carduri = new ArrayList<>(n);
        this.IBAN = IBAN;
        this.Valuta = Valuta;
        this.Sold = Sold;
        nrcarduri = n;
        for (int i = 0; i < nrcarduri; i++)

            this.carduri.add( card[i]);
        comisionAdministrareCont();
        this.DataAcordare = DataAcordare;
        extras = new Extras();


    }

    public Cont(Cont cont) {
    }

    public int hashCode() {
        return Objects.hash(IBAN, Valuta, Sold);
    }

    public String getIBAN() {
        return IBAN;
    }

    public String getValuta() {
        return Valuta;
    }

    public double getSold() {
        return Sold;
    }

    public double getComisionA() {
        return ComisionA;
    }

    public int getnrcarduri() {
        return nrcarduri;
    }

    public String gettipcont() {
        return tipcont;
    }


    public String getDataAcordare() {
        return DataAcordare;
    }

    public List<Card> getcard() {
        return carduri;
    }

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

    public void settipcont(String tipcont) {
        this.tipcont = tipcont;
    }

    public void setDataAcordare(String dataAcordare) {
        DataAcordare = dataAcordare;
    }

    public void setCarduri(List<Card> carduri) {
        this.carduri = carduri;
    }
    public void setCardelem( Card card)
    {
        this.carduri.add(card);

    }

    abstract public void comisionAdministrareCont();

    public void adtranz(Tranzactie tranz) {
        int ok = 1;
        for (Card i : this.carduri)
            if (extras.getTraz().equals(i)) {
                System.out.println("Tranzactie exista deja. Va rugam alegeti alta tranzactie");
                ok = 0;
            }
        if (extras.getNrtranz() == 0) {
            this.extras.setTraz(new Tranzactie[100]);
            this.extras.adaugatranz(tranz);

        } else if (ok == 1) {

            this.extras.adaugatranz(tranz);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this != obj)
            return false;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Cont c = (Cont) obj;

        if (!Objects.equals(this.IBAN, c.IBAN))
            return false;
        if (!Objects.equals(this.DataAcordare, c.DataAcordare))
            return false;
        if (this.Sold != c.Sold)
            return false;
        if (this.Valuta != c.Valuta)
            return false;
        if (!Objects.equals(this.carduri, c.carduri))
            return false;
        if (!Objects.equals(this.tipcont, c.tipcont))
            return false;
        return true;
    }




     public void StergereCard(int i){
        carduri.remove(i);

     }
    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append("\n" + this.tipcont + " cu IBAN " + this.IBAN + ", Data deschiderii contului " + this.DataAcordare + ", Soldul curent este: " + this.Sold + " in valuta " + Valuta + " si are un comision de administrare lunar de " + ComisionA + Valuta);
        a.append("\nAcesta are atasat " + carduri.size() + " carduri.");
        for (int j = 0; j < carduri.size(); j++)

            a.append("\n" + carduri.get(j));

        return a.toString();
    }

    public void extras(String Data) {
        extras.setData(Data);
        System.out.println("Extras pentru contul cu IBAN " + IBAN);
        System.out.println(extras.toString());

    }
    public abstract void setIBANcontc(String c);




}





