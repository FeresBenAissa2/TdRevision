package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Voiture v1 = new Voiture(1, "RENAUT", 30.00f);
        Voiture v4 = new Voiture(1, "RENAUT", 30.00f);

        Voiture v2 = new Voiture(2, "BMW", 25.00f);
        Voiture v3 = new Voiture(3, "AUDI", 26.00f);

        Client c1 = new Client(1, "feres", "ben aissa");
        Client c2 = new Client(2, "Mezen", "boulares");

        ListVoitures listeVoiture = new ListVoitures();
        HashMap<Client, ListVoitures> hashMapVoiure = new HashMap<>();
        Agence ag = new Agence("ABC", listeVoiture, hashMapVoiure);


        try {
            // test voiture double fonctionne
            ag.ajoutVoiture(v1);
            //   ag.ajoutVoiture(v4);
            ag.ajoutVoiture(v2);
            ag.ajoutVoiture(v3);
            // voiture deja louweee
            // ag.loueClientVoiture(c1,v1);
            //  ag.loueClientVoiture(c2,v1);
            //
            ag.loueClientVoiture(c1, v1);
            ag.loueClientVoiture(c2, v2);
            ag.retourClientVoiture(c1,v1);
            ag.loueClientVoiture(c2, v1);
            // collection retourne une liste (code )
            // collection voiture louees
            ArrayList<ListVoitures> newList = new ArrayList<>(ag.collectionVoituresLouees());
            ag.afficheLesClientsEtLeursListesVoitures();

            CriterePrix cp = new CriterePrix(26.00f);
            ArrayList<Voiture> ListeSelonPrix = (ArrayList<Voiture>) ag.selectVoitureSelonCritere(cp);
            System.out.println("------------- selon prix----------------");
            for(Voiture v :ListeSelonPrix)
                System.out.println(v);

            TreeMap<Client,ListVoitures> triMap = (TreeMap<Client, ListVoitures>) ag.triCodeCroissant();
            triMap.forEach(( c,lv)->{
                System.out.println(c);
                System.out.println(lv);

            });

        } catch (VoitureException e) {
            System.out.println(e.getMessage());
        }


    }
}