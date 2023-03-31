package com.example.tpnoteperiode2;

import org.junit.Test;

import static org.junit.Assert.*;

public class TauxTest {

    @Test
    public void testGetSeuilInf() {
        Taux taux = new Taux( "Taux1",0, 500, 0.01);
        assertEquals(0, taux.getSeuilInf(), 0.001);
    }

    @Test
    public void testGetSeuilSup() {
        Taux taux = new Taux("Taux1",0, 500, 0.01);
        assertEquals(500, taux.getSeuilSup(), 0.001);
    }

    @Test
    public void testGetTaux() {
        Taux taux = new Taux("Taux1",0, 500, 0.01);
        assertEquals(0.01, taux.getValTaux(), 0.001);
    }

    @Test
    public void testGetNomTaux() {
        Taux taux = new Taux( "Taux1",0, 500, 0.01);
        assertEquals("Taux1", taux.getNomTaux());
    }

    @Test
    public void testEstDansSeuilsTrue() {
        Taux taux = new Taux( "Taux1",0, 500, 0.01);
        assertTrue(taux.estDansSeuils(250));
    }

    @Test
    public void testEstDansSeuilsFalse() {
        Taux taux = new Taux("Taux1",0, 500, 0.01);
        assertFalse(taux.estDansSeuils(750));
    }
}
