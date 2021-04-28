package fisiere;

import produse.Card;
import client.*;
import produse.Cont;

import java.io.*;
import java.util.List;

public class Scriere {
    private static Scriere singleton = null;
    public static BufferedWriter Card;
    public static BufferedWriter Client;
    public static BufferedWriter Cont;
    public static BufferedWriter Cutie;
    public static BufferedWriter ContCurent;
    public static BufferedWriter Complet;
    public static String fisiere = System.getProperty("user.dir") + "\\src\\fisiere";

     private Scriere()
     {  Stergere("Card");
         Stergere("Client");
         Stergere("Cont");
         Stergere("ContCurent");
         Stergere("Cutie");
         Stergere("ScriereCompleta");}
    public static Scriere getInstance()
    {
        if (singleton == null)
            singleton = new Scriere();

        return singleton;
    }

    public void Stergere(String fisier) {
        try {
            FileWriter x = new FileWriter(fisiere + "\\scriere\\" + fisier + ".csv");

            x.write("");
            x.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ScriereCard(List<Card> carduri) {
        try {

            Card = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\Card.csv", true));
            if(carduri!=null)
            for (int i = 0; i < carduri.size(); i++) {
                Card.write(carduri.get(i).toString());
                Card.write("\n");
            }
            Card.close();
        } catch (IOException e) {
        }
        catch (NullPointerException e){}
    }

    public void ScriereClient(List<Client> clienti) {
        try {

            Client = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\Client.csv", true));
            for (int i = 0; i < clienti.size(); i++)
                Client.write(clienti.get(i).toString());
            Client.close();
        } catch (IOException e) {
        }
    }

    public void ScriereCont(List<produse.Cont> conturi) {
        try {

            Cont = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\Cont.csv", true));
            for (int i = 0; i < conturi.size(); i++)
                Cont.write(conturi.get(i).toString());
            Cont.close();
        } catch (IOException e) {
        }
    }

    public void ScriereContCurent(List<produse.Cont> conturi) {
        try {

            ContCurent = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\ContCurent.csv", true));
            for (int i = 0; i < conturi.size(); i++)
                ContCurent.write(conturi.get(i).toString());
            ContCurent.close();
        } catch (IOException e) {
        }
    }

    public void ScriereCutie(List<produse.InchiriereCutieValori> conturi) {
        try {

            Cutie = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\Cutie.csv", true));
            for (int i = 0; i < conturi.size(); i++)
                Cutie.write(conturi.get(i).toString());
            Cutie.close();
        } catch (IOException e) {
        }
    }

    public void ScriereCompleta(List<produse.InchiriereCutieValori> cutii, List<Card> carduri, List<produse.Cont> conturic, List<produse.Cont> conturi, List<Client> clienti) {
        try {

              Complet = new BufferedWriter(new FileWriter(fisiere + "\\scriere\\ScriereCompleta.csv", true));
            for (int i = 0; i < clienti.size(); i++){
                Complet.write(clienti.get(i).toString());
                Complet.write("\n"); }
            for (int i = 0; i < conturic.size(); i++){
                Complet.write(conturic.get(i).toString());
                Complet.write("\n"); }
            for (int i = 0; i < conturi.size(); i++){
                Complet.write(conturi.get(i).toString());
                Complet.write("\n"); }
            if(carduri!=null)
            for (int i = 0; i < carduri.size(); i++) {
                Complet.write(carduri.get(i).toString());
                Complet.write("\n"); }
            for (int i = 0; i < cutii.size(); i++) {
                Complet.write(cutii.get(i).toString());
                Complet.write("\n"); }
            Complet.close();
        } catch (IOException e) {
        }
    }

}

