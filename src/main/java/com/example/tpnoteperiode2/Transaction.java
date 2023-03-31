package com.example.tpnoteperiode2;

import java.io.Serializable;

public class Transaction implements Serializable {
    private String nom;
    private String type; //c = credit, d = debit
    private double montant;

    public Transaction(String nom, String type, double montant) {
        this.nom = nom;
        this.type = type;
        this.montant = montant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
}
