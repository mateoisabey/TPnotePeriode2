package com.example.tpnoteperiode2;

import java.io.IOException;
import java.util.*;

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
        if (transaction.getType().equals("c")) {
            solde += transaction.getMontant();
        } else if (transaction.getType().equals("d")) {
            solde -= transaction.getMontant();
        }
    }

    public double getSoldeCompte() {
        return solde;
    }

    public void chargerTaux(String nomFichier) {
        File fichier = new File(nomFichier);
        try (Scanner scanner = new Scanner(fichier)) {
            while (scanner.hasNextLine()) {
                String ligne = scanner.nextLine();

                String[] valeurs = ligne.split(" ");
                if (valeurs.length == 4) {
                    double seuilInf = Double.parseDouble(valeurs[1].trim());
                    double seuilSup = Double.parseDouble(valeurs[2].trim());
                    double taux = Double.parseDouble(valeurs[3].trim());
                    String nomTaux = valeurs[0].trim();
                    Taux nouveauTaux = new Taux(nomTaux, seuilInf, seuilSup, taux);
                    this.taux.add(nouveauTaux);
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier de taux: " + e.getMessage());
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
}



