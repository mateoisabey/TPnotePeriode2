package com.example.tpnoteperiode2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireBancaire {
    private List<Transaction> transactions;
    private List<Taux> taux;
    private double solde;

    public GestionnaireBancaire() {
        transactions = new ArrayList<>();
        taux = new ArrayList<>();
        solde = 0;
    }

    public void ajouterTransaction(Transaction transaction) {
        transactions.add(transaction);
        if (transaction.getType().equals("credit")) {
            solde += transaction.getMontant();
        } else if (transaction.getType().equals("debit")) {
            solde -= transaction.getMontant();
        }
    }

    public double getSoldeCompte() {
        return solde;
    }

    public void chargerTaux() throws IOException {
        Path P1 = Paths.get("src/main/resources/com/example/tpnoteperiode2/Data/taux.txt");
        List<String> lignes = Files.readAllLines(P1);
        for(String string : lignes){
            String[] valeurs = string.split(" ");
            double seuilInf = Double.parseDouble(valeurs[1].trim());
            double seuilSup = Double.parseDouble(valeurs[2].trim());
            double taux = Double.parseDouble(valeurs[3].trim());
            String nomTaux = valeurs[0].trim();
            Taux nouveauTaux = new Taux(nomTaux, seuilInf, seuilSup, taux);
            this.taux.add(nouveauTaux);
        }
    }


    public void sauvegarderTransactions(String nomFichier) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(new File(nomFichier)))) {
            out.writeObject(transactions);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des transactions: " + e.getMessage());
        }
    }

    public void chargerTransactions(String nomFichier) {
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(new File(nomFichier)))) {
            transactions = (List<Transaction>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement des transactions: " + e.getMessage());
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public double getSolde() {
        return solde;
    }
}



