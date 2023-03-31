package com.example.tpnoteperiode2;

public class GestionBancaire {
    private Transaction[] transactions;
    private Taux[] taux;
    private double solde;

    public GestionBancaire() {
        this.transactions = new Transaction[0];
        this.taux = new Taux[0];
        this.solde = 0;
    }
}
