package com.example.tpnoteperiode2;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class GestionnaireBancaireTest {

    private GestionnaireBancaire gestionnaire;

    @Before
    public void setUp() {
        gestionnaire = new GestionnaireBancaire();
    }

    @Test
    public void testAjouterTransaction() {
        Transaction t1 = new Transaction("achat", "d", 100.0);
        gestionnaire.ajouterTransaction(t1);
        double soldeAttendu = -100.0;
        assertEquals(soldeAttendu, gestionnaire.getSoldeCompte(), 0.001);

        Transaction t2 = new Transaction("salaire", "c", 2000.0);
        gestionnaire.ajouterTransaction(t2);
        soldeAttendu = 1900.0;
        assertEquals(soldeAttendu, gestionnaire.getSoldeCompte(), 0.001);
    }

    @Test
    public void testChargerTaux() {
        gestionnaire.chargerTaux("src/main/resources/com/example/tpnoteperiode2/Data/taux.txt");
        List<Taux> taux = gestionnaire.getTaux();
        System.out.println(taux);
        assertEquals(3, taux.size());

    }

    @Test
    public void testSauvegarderChargerTransactions() {
        Transaction t1 = new Transaction("achat", "d", 100.0);
        Transaction t2 = new Transaction("salaire", "c", 2000.0);
        gestionnaire.ajouterTransaction(t1);
        gestionnaire.ajouterTransaction(t2);
        gestionnaire.sauvegarderTransactions("src/main/resources/com/example/tpnoteperiode2/Data/transactions.bin");
        gestionnaire.chargerTransactions("src/main/resources/com/example/tpnoteperiode2/Data/transactions.bin");
        List<Transaction> transactions = gestionnaire.getTransactions();
        assertEquals(2, transactions.size());
        assertEquals("achat", transactions.get(0).getNom());
        assertEquals(2000.0, transactions.get(1).getMontant(), 0.001);
    }

}
