package produse;

import client.Client;

public class ContCurent extends Cont {
    protected Client client = new Client();

    public ContCurent() {
    }

    public ContCurent(String IBAN, String Valuta, double Sold, int n, Card[] card, String DataAcordare, Client client) {
        super(IBAN, Valuta, Sold, n, card, DataAcordare);
        setClient(client);
        this.tipcont = "Cont curent";


    }


    @Override
    public void comisionAdministrareCont() {
        this.ComisionA = 5;
    }

    @Override
    public String toString() {
        StringBuilder a = new StringBuilder();
        a.append(super.toString());
        a.append(client.toString());


        return a.toString();
    }

    @Override
    public void setContCurent(ContCurent c) {

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client c) {
        this.client.setNume(c.getNume());
        this.client.setPrenume(c.getPrenume());
        this.client.setCNP(c.getCNP());
        this.client.setDataNasterii(c.getDataNasterii());

    }


}

