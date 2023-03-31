package com.example.tpnoteperiode2;

public class Taux {

    private double seuilInf;
    private double seuilSup;
    private double valTaux;
    private String nomTaux;

    public Taux(String nomTaux, double seuilInf, double seuilSup, double taux) {
        this.seuilInf = seuilInf;
        this.seuilSup = seuilSup;
        this.valTaux = taux;
        this.nomTaux = nomTaux;
    }

    public double getSeuilInf() {
        return seuilInf;
    }

    public double getSeuilSup() {
        return seuilSup;
    }

    public double getValTaux() {
        return valTaux;
    }

    public String getNomTaux() {
        return nomTaux;
    }

    public boolean estDansSeuils(double montant) {
        return (montant >= seuilInf && montant <= seuilSup);
    }
}

