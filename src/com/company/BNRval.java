package com.company;

import java.util.*;
public class BNRval {

    protected double robor;
    protected double ircc;
    protected double euro;
    protected double usd;
    protected double lireS;
    protected double francE;
    protected double rublaR;
    protected double yeniJ;
    protected double coroanaCEHA;
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

    public void setCoroanaCEHA(double coroanaCEHA) {
        this.coroanaCEHA = coroanaCEHA;
    }

    public double getCoroanaCEHA() {
        return coroanaCEHA;
    }

    public double getEuro() {
        return euro;
    }

    public double getFrancE() {
        return francE;
    }

    public double getGramaur() {
        return gramaur;
    }

    public double getLireS() {
        return lireS;
    }

    public double getUsd() {
        return usd;
    }

    public double getRublaR() {
        return rublaR;
    }

    public double getYeniJ() {
        return yeniJ;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public void setLireS(double lireS) {
        this.lireS = lireS;
    }

    public void setFrancE(double francE) {
        this.francE = francE;
    }

    public void setRublaR(double rublaR) {
        this.rublaR = rublaR;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    public void setYeniJ(double yeniJ) {
        this.yeniJ = yeniJ;
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
