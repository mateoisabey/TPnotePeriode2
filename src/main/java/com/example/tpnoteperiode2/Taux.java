package com.example.tpnoteperiode2;

public class Taux {
    private double seuilMax;
    private double seuilMin;
    private double taux;
    private String nom;

    public Taux(double seuilMax, double seuilMin, double taux, String nom) {
        this.seuilMax = seuilMax;
        this.seuilMin = seuilMin;
        this.taux = taux;
        this.nom = nom;
    }
}
