package GenerareValori;

import java.util.Random;

public class BancaVal {
    protected double marjacredit;

    public BancaVal()
    {marja();}

    public double getMarjacredit() {
        return marjacredit;
    }

    public void setMarjacredit(double marjacredit) {
        this.marjacredit = marjacredit;
    }
    public void marja()
    {   Random r = new Random();

        this.marjacredit=Math.round(((3+r.nextDouble())*100.00))/100.0; //(min+(max-min)*nextdouble)
    }
}
