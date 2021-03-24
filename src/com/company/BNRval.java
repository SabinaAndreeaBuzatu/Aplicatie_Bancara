package com.company;

import java.util.*;
public class BNRval {

    protected double robor;
    protected double ircc;

    public BNRval( )
    {
        calcrobor();
        calcircc();

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
    public void calcrobor()
    {   Random r = new Random();
        this.robor=1+r.nextDouble();
    }
    public void calcircc()
    {   Random r = new Random();

        this.ircc=r.nextDouble();
    }
}
