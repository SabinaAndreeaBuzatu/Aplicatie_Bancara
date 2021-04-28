package fisiere;

import produse.*;
import client.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Citire {
    private static Citire singleton = null;
    public static BufferedReader Card;
    public static BufferedReader Client;
    public static BufferedReader Cont;
    public static BufferedReader Cutie;
    public static BufferedReader ContCurent;
    public static String fisiere = System.getProperty("user.dir") + "\\src\\Fisiere";

    private Citire() {

    }


    public static Citire getInstance() {
        if (singleton == null)
            singleton = new Citire();

        return singleton;
    }


    public Pair<List<Cont>, List<Card>> CitireCard(List<Cont> conturi) {
        try {
            List<Card> carduri = new ArrayList<>();
            Card c;
            String linie;
            String[] camp;
            Card = new BufferedReader(new FileReader(fisiere + "\\citire\\Card.csv"));
            Pair ret = null;

            while ((linie = Card.readLine()) != null) {
                int i = -1;
                c = new Card();
                camp = linie.split("[,]");
                String iban = camp[0];
                for (Cont cont : conturi) {
                    i++;
                    if (iban.equals(cont.getIBAN())) {
                        c.setNrCard(camp[1]);
                        c.setDataExp(camp[4]);
                        c.setPin(camp[2]);
                        c.setCVV(camp[3]);
                        carduri.add(c);
                        conturi.get(i).setCardelem(c);
                        conturi.get(i).setnrcarduri(conturi.get(i).getnrcarduri() + 1);
                        ret = new Pair(conturi, carduri);

                    }

                }

            }
            Card.close();

            return ret;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Client> CitireClient() {
        try {
            List<Client> clienti = new ArrayList<>();
            Client c;
            String linie;
            String[] camp;

            Client = new BufferedReader(new FileReader(fisiere + "\\citire\\Client.csv"));

            while ((linie = Client.readLine()) != null) {
                c = new Client();
                camp = linie.split("[,]");
                c.setNume(camp[0]);
                c.setPrenume(camp[1]);
                c.setCNP(camp[3]);
                c.setDataNasterii(camp[2]);
                clienti.add(c);
            }
            Client.close();
            return clienti;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<Cont> CitireContCurent(List<Client> clienti) {
        try {
            ContCurent = new BufferedReader(new FileReader(fisiere + "\\citire\\ContCurent.csv"));
            List<Cont> conturi = new ArrayList<>();
            Cont c;
            String linie;
            String[] camp;

            while ((linie = ContCurent.readLine()) != null) {
                camp = linie.split("[,]");

                if (camp[1].equals("Cont curent")) {
                    String cnp = camp[0];
                    for (Client client : clienti)
                        if (cnp.equals(client.getCNP())) {
                            c = new ContCurent();
                            c.settipcont(camp[1]);
                            c.setIBAN(camp[2]);
                            c.setValuta(camp[3]);
                            c.setSold(Double.parseDouble(camp[4]));
                            c.setDataAcordare(camp[5]);
                            c.setClient(client);
                            c.comisionAdministrareCont();
                            conturi.add(c);
                        }
                }


            }

            ContCurent.close();
            return conturi;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    //    public Pair<List<Depozit>,List<Credit>> CitireCont(List<ContCurent> conturic) {
//        try {
//            Cont = new BufferedReader(new FileReader(fisiere + "\\citire\\Cont.csv"));
//            List<Depozit> depozite = new ArrayList<>();
//            List<Credit> credite = new ArrayList<>();
//            Depozit c;
//            Credit credit;
//            String linie;
//            String[] camp;
//
//            while ((linie = Cont.readLine()) != null) {
//                camp = linie.split("[,]");
//                if (camp[1].equals("Depozit")) {
//                    String iban = camp[0];
//                    for (ContCurent contc : conturic)
//                        if (iban.equals(contc.getIBAN())) {
//                            c = new Depozit();
//                           c.settipcont(camp[1]);
//                            c.setIBAN(camp[2]);
//                            c.setValuta(camp[3]);
//                            c.setSold(Double.parseDouble(camp[4]));
//                            c.setDataAcordare(camp[5]);
//                            c.setContCurent(contc);
//                            c.comisionAdministrareCont();
//
//                            c.comisionAdministrareCont();
//                            depozite.add(c);
//                        }
//                }
//               else  if (camp[1].equals("Credit cu dobanda fixa")) {
//                    String iban = camp[0];
//                    for (ContCurent contc : conturic)
//                        if (iban.equals(contc.getIBAN())) {
//                            credit = new CreditFix();
//                            credit.settipcont(camp[1]);
//                            credit.setIBAN(camp[2]);
//                            credit.setValuta(camp[3]);
//                            credit.setSold(Double.parseDouble(camp[4]));
//                            credit.setDataAcordare(camp[5]);
//                            credit.setContCurent(contc);
//                            credit.setDurataluni(Integer.parseInt(camp[6]));
//                            credit.setSumaAcordata(Double.parseDouble(camp[7]));
//                            credit.dobanda();
//                            credit.calcrata();
//                            credit.comisionAdministrareCont();
//                            credite.add(credit);
//                        }
//                }
//                else if (camp[1].equals("Credit cu dobanda variabila")) {
//                    String iban = camp[0];
//                    for (ContCurent contc : conturic)
//                        if (iban.equals(contc.getIBAN())) {
//                            credit = new CreditFix();
//                            credit.settipcont(camp[1]);
//                            credit.setIBAN(camp[2]);
//                            credit.setValuta(camp[3]);
//                            credit.setSold(Double.parseDouble(camp[4]));
//                            credit.setDataAcordare(camp[5]);
//                            credit.setContCurent(contc);
//                            credit.setDurataluni(Integer.parseInt(camp[6]));
//                            credit.setSumaAcordata(Double.parseDouble(camp[7]));
//                            credit.dobanda();
//                            credit.calcrata();
//                            credit.comisionAdministrareCont();
//                            credite.add(credit);
//                        }
//                }
//            }
//
//            Cont.close();
//            Pair depozitCredit= new Pair(depozite,credite);
//            return depozitCredit;
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return null;
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
    public List<Cont> CitireCont(List<ContCurent> conturic) {
        try {
            Cont = new BufferedReader(new FileReader(fisiere + "\\citire\\Cont.csv"));
            List<Cont> conturi = new ArrayList<>();
            Cont c;
            Credit credit;
            String linie;
            String[] camp;

            while ((linie = Cont.readLine()) != null) {
                camp = linie.split("[,]");
                if (camp[1].equals("Depozit")) {
                    String iban = camp[0];
                    for (ContCurent contc : conturic)
                        if (iban.equals(contc.getIBAN())) {
                            c = new Depozit();
                            c.settipcont(camp[1]);
                            c.setIBAN(camp[2]);
                            c.setValuta(camp[3]);
                            c.setSold(Double.parseDouble(camp[4]));
                            c.setDataAcordare(camp[5]);
                            c.setContCurent(contc);
                            c.comisionAdministrareCont();
                            conturi.add(c);
                        }
                } else if (camp[1].equals("Credit cu dobanda fixa")) {
                    String iban = camp[0];
                    for (ContCurent contc : conturic)
                        if (iban.equals(contc.getIBAN())) {
                            credit = new CreditFix();
                            credit.settipcont(camp[1]);
                            credit.setIBAN(camp[2]);
                            credit.setValuta(camp[3]);
                            credit.setSold(Double.parseDouble(camp[4]));
                            credit.setDataAcordare(camp[6]);
                            credit.setContCurent(contc);
                            credit.setDurataluni(Integer.parseInt(camp[5]));
                            credit.setSumaAcordata(Double.parseDouble(camp[7]));
                            credit.dobanda();
                            credit.calcrata();
                            credit.comisionAdministrareCont();
                            conturi.add(credit);
                        }
                } else if (camp[1].equals("Credit cu dobanda variabila")) {
                    String iban = camp[0];
                    for (ContCurent contc : conturic)
                        if (iban.equals(contc.getIBAN())) {
                            credit = new CreditFix();
                            credit.settipcont(camp[1]);
                            credit.setIBAN(camp[2]);
                            credit.setValuta(camp[3]);
                            credit.setSold(Double.parseDouble(camp[4]));
                            credit.setDataAcordare(camp[6]);
                            credit.setContCurent(contc);
                            credit.setDurataluni(Integer.parseInt(camp[5]));
                            credit.setSumaAcordata(Double.parseDouble(camp[7]));
                            credit.dobanda();
                            credit.calcrata();
                            credit.comisionAdministrareCont();
                            conturi.add(credit);
                        }
                }
            }

            Cont.close();
            return conturi;


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<InchiriereCutieValori> CitireCutie(List<ContCurent> conturic) {
        try {
            List<InchiriereCutieValori> cutii = new ArrayList<>();
            InchiriereCutieValori c;
            String linie;
            String[] camp;


            Cutie = new BufferedReader(new FileReader(fisiere + "\\citire\\Cutie.csv"));

            while ((linie = Cutie.readLine()) != null) {
                camp = linie.split("[,]");
                String iban = camp[0];
                for (ContCurent contc : conturic)
                    if (iban.equals(contc.getIBAN())) {
                        c = new InchiriereCutieValori();
                        c.setPragValoriDeclarat(Double.parseDouble(camp[1]));
                        c.comision();
                        c.setValuta(camp[2]);
                        c.setDataAcordare(camp[3]);
                        c.setAdresa(camp[4]);
                        c.setContc(contc);
                        cutii.add(c);
                    }
            }

            Cutie.close();
            return cutii;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }

    public void CitesteTot() {

    }

}

