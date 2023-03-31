package com.example.tpnoteperiode2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


public class TransactionTest {

    @Test
    public void testGetNom() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        assertEquals("salaire", transaction.getNom());
    }

    @Test
    public void testSetNom() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        transaction.setNom("prime");
        assertEquals("prime", transaction.getNom());
    }

    @Test
    public void testGetType() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        assertEquals("c", transaction.getType());
    }

    @Test
    public void testSetType() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        transaction.setType("d");
        assertEquals("d", transaction.getType());
    }

    @Test
    public void testGetMontant() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        assertEquals(2000, transaction.getMontant(), 0.001);
    }

    @Test
    public void testSetMontant() {
        Transaction transaction = new Transaction("salaire", "c", 2000);
        transaction.setMontant(1500);
        assertFalse(2000 == transaction.getMontant());
    }
}
