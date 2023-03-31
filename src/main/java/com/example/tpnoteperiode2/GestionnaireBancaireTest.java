package com.example.tpnoteperiode2;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class GestionnaireBancaireTest {

    private GestionBancaire gestionnaire;

    public void setUp() throws FileNotFoundException {
        GestionBancaire gestionnaire = new GestionBancaire();
        gestionnaire.chargerTaux("Data/taux.txt");
    }

    @Test
    public void testAjouterTransaction() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        gestionnaire.ajouterTransaction(transaction);
        List<Transaction> transactions = gestionnaire.getTransactions();
        assertEquals(1, transactions.size());
        assertEquals(transaction, transactions.get(0));
    }

    @Test
    public void testRecalculerSolde() {
        Transaction transaction1 = new Transaction("salaire", "c", 2000);
        Transaction transaction2 = new Transaction("loyer", "d", 1000);
        gestionnaire.ajouterTransaction(transaction1);
        gestionnaire.ajouterTransaction(transaction2);
        assertEquals(1000, gestionnaire.getSoldeCompte());
    }

    @Test
    public void testChargerTaux() {
        List<Taux> taux = gestionnaire.getTaux();
        assertEquals(3, taux.size());
        Taux taux1 = taux.get(0);
        assertEquals(0, taux1.getSeuilInf());
        assertEquals(500, taux1.getSeuilSup());
        assertEquals(0.01, taux1.getTaux());
        assertEquals("Taux1", taux1.getNomTaux());
    }

    @Test
    public void testSauvegarderTransactions() throws IOException, ClassNotFoundException {
        Transaction transaction1 = new Transaction("salaire", "c", 2000);
        Transaction transaction2 = new Transaction("loyer", "d", 1000);
        gestionnaire.ajouterTransaction(transaction1);
        gestionnaire.ajouterTransaction(transaction2);
        gestionnaire.sauvegarderTransactions("Data/SaveList.bin");
        gestionnaire.getTransactions().clear();
        gestionnaire.chargerTransactions("Data/SaveList.bin");
        List<Transaction> transactions = gestionnaire.getTransactions();
        assertEquals(2, transactions.size());
        assertEquals(transaction1, transactions.get(0));
        assertEquals(transaction2, transactions.get(1));
    }
}
