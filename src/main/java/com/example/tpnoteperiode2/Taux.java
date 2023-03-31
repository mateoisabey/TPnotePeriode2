package com.example.tpnoteperiode2;

public class Taux {

    private double seuilInf;
    private double seuilSup;
    private double taux;
    private String nomTaux;

    public Taux(double seuilInf, double seuilSup, double taux, String nomTaux) {
        this.seuilInf = seuilInf;
        this.seuilSup = seuilSup;
        this.taux = taux;
        this.nomTaux = nomTaux;
    }

    public double getSeuilInf() {
        return seuilInf;
    }

    public double getSeuilSup() {
        return seuilSup;
    }

    public double getTaux() {
        return taux;
    }

    public String getNomTaux() {
        return nomTaux;
    }

    public boolean estDansSeuils(double montant) {
        return (montant >= seuilInf && montant <= seuilSup);
    }
}

