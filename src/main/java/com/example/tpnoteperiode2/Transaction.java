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
        return "";
    }

    public void setNom(String nom) {

    }

    public String getType() {
        return "";
    }

    public void setType(String type) {

    }

    public double getMontant() {
        return 0;
    }

    public void setMontant(double montant) {

    }
}
