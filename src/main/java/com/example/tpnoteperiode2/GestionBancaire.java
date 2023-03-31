package com.example.tpnoteperiode2;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class GestionBancaire {
    private ArrayList<Transaction> transactions;
    private ArrayList<Taux> taux;
    private double solde;


    GestionBancaire() {
        transactions = new ArrayList<>();
        taux = new ArrayList<>();
        solde = 0;
    }



    public void ajouterTransaction(Transaction transaction) {

        }

        public double getSoldeCompte() {
            return solde;
        }

        public void chargerTaux(String nomFichier) throws FileNotFoundException {
        }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public void sauvegarderTransactions(String s) {
    }

    public void chargerTransactions(String s) {
    }
}


