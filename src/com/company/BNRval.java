package com.company;

import java.util.*;
public class BNRval {

    protected double robor;
    protected double ircc;
    protected double euro;
    protected double usd;
    protected double gbp;
    protected double chf;
    protected double rub;
    protected double jpy;
    protected double czk;
    protected double gramaur;



    public BNRval( )
    {
        calcrobor();
        calcircc();
        calceuro();
        calcifrac();
        calcaur();
        calcusd();
        calciyeni();
        calcirubla();
        calccoroana();
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

    public void setczk(double czk) {
        this.czk = czk;
    }

    public double getczk() {
        return czk;
    }

    public double getEuro() {
        return euro;
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

    public double getjpy() {
        return jpy;
    }

    public void setEuro(double euro) {
        this.euro = euro;
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

    public void setjpy(double jpy) {
        this.jpy = jpy;
    }

    public void setGramaur(double gramaur) {
        this.gramaur = gramaur;
    }

    public void calcrobor()
    {   Random r = new Random();
        this.robor=1+6*r.nextDouble();//(min+(max-min)*nextdouble)
    }
    public void calcircc()
    {   Random r = new Random();

        this.ircc=1+6*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calceuro()
    {   Random r = new Random();

        this.ircc=3+2*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calcusd()
    {   Random r = new Random();

        this.ircc=3+4.5*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calciliras()
    {   Random r = new Random();

        this.ircc=5+6.5*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calcifrac()
    {   Random r = new Random();

        this.ircc=3.5+5.5*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
    public void calcirubla()
    {   Random r = new Random();

        this.ircc=r.nextDouble(); //(min+(max-min)*nextdouble)
    }public void calciyeni()
    {   Random r = new Random();

        this.ircc=3+4.5*r.nextDouble(); //(min+(max-min)*nextdouble)
    }public void calccoroana()
    {   Random r = new Random();

        this.ircc=r.nextDouble(); //(min+(max-min)*nextdouble)
    }public void calcaur()
    {   Random r = new Random();

        this.ircc=200+400*r.nextDouble(); //(min+(max-min)*nextdouble)
    }
}