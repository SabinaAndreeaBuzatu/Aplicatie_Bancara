package generareValori;

import java.util.Random;

public class BancaVal {
    protected double marjaCredit;

    public BancaVal()
    {marja();}

    public double getMarjaCredit() {
        return marjaCredit;
    }

    public void setMarjaCredit(double marjaCredit) {
        this.marjaCredit = marjaCredit;
    }
    public void marja()
    {   Random r = new Random();

        this.marjaCredit=Math.round(((3+r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
}
