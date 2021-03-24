package com.company;
import java.util.*;

public class Banca {

    protected Map<Client, Cont> evidenta;

    public Banca(int n, Client[] clienti, Cont[] conturi)
    {
        for(int i=0;i<n;i++)
            evidenta.put(clienti[i],conturi[i]);



    }


}
