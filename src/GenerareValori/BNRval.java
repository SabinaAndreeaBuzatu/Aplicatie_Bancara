package GenerareValori;

import java.util.*;


public class BNRval {

    protected double robor;
    protected double ircc;
    protected double eur;
    protected double usd;
    protected double gbp;
    protected double chf;
    protected double rub;
    protected double gramaur;




    public BNRval( )
    {
        calcrobor();
        calcircc();
        calceuro();
        calcifrac();
        calcaur();
        calcusd();
        calcirubla();
        calciliras();

    }

    public void setrobor(double robor)
    {
        this.robor=robor;
    }
    public void setircc(double robor)
    {
        this.ircc=ircc;
    }
    public double getrobor()
    {
        return robor;
    }
    public double getircc()
    {
        return ircc;
    }


    public double getEuro() {
        return eur;
    }

    public double getchf() {
        return chf;
    }

    public double getGramaur() {
        return gramaur;
    }

    public double getgbp() {
        return gbp;
    }

    public double getUsd() {
        return usd;
    }

    public double getrub() {
        return rub;
    }



    public void setEuro(double euro) {
        this.eur = euro;
    }

    public void setgbp(double gbp) {
        this.gbp = gbp;
    }

    public void setchf(double chf) {
        this.chf = chf;
    }

    public void setrub(double rub) {
        this.rub = rub;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }


    public void setGramaur(double gramaur) {
        this.gramaur = gramaur;
    }

    public void calcrobor()
    {   Random r = new Random();
        this.robor=1+10*r.nextDouble();//(min+(max-min)*nextdouble)
    }
    public void calcircc()
    {   Random r = new Random();

        this.ircc=1+6*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calceuro()
    {   Random r = new Random();

        this.eur=Math.round(((3.5+1.5*r.nextDouble()))*100.00)/100.0; //(min+(max-min)*nextdouble)
    }
    public void calcusd()
    {   Random r = new Random();

        this.usd=Math.round(((3+1.5*r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
    public void calciliras()
    {   Random r = new Random();

        this.gbp=Math.round(((4+1.5*r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
    public void calcifrac()
    {   Random r = new Random();

        this.chf=Math.round(((3.5+2.5*r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
    public void calcirubla()
    {   Random r = new Random();

        this.rub=Math.round(((r.nextDouble())*100.00))/100.0;} //(min+(max-min)*nextdouble)
   public void calcaur()
    {   Random r = new Random();

        this.gramaur=Math.round(((200+400*r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
}
