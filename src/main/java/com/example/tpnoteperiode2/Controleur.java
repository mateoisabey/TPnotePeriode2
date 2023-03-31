package com.example.tpnoteperiode2;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

public class Controleur implements Observer {

    private ObservableList<Transaction> observableListTransactions;

    @FXML
    private TextField textFieldNom;
    @FXML
    private TextField textFieldMontant;
    @FXML
    private ComboBox<String> comboBoxType;
    @FXML
    private Button buttonEnregistrer;
    @FXML
    private Label labelSolde;
    @FXML
    private ListView<Transaction> listViewTransactions;

    GestionnaireBancaire gestionnaireBancaire = new GestionnaireBancaire();
    public void initialize() throws IOException {

        gestionnaireBancaire.chargerTaux();


        observableListTransactions = FXCollections.observableArrayList(gestionnaireBancaire.getTransactions());
        listViewTransactions.setItems(observableListTransactions);
        comboBoxType.setItems(FXCollections.observableArrayList("credit", "debit"));
        System.out.println(gestionnaireBancaire.getTaux());
    }


    public void actionEnregistrer(ActionEvent evt) {
        String nom = textFieldNom.getText();
        double montant = Double.parseDouble(textFieldMontant.getText());
        String type = comboBoxType.getValue();

        Transaction transaction = new Transaction(nom, type, montant);
        System.out.println(transaction.getMontant());

        // add transaction to gestionnaireBancaire
        gestionnaireBancaire.ajouterTransaction(transaction);

        // clear text fields and update listView and labelSolde
        textFieldNom.clear();
        textFieldMontant.clear();
        listViewTransactions.setItems(FXCollections.observableArrayList(gestionnaireBancaire.getTransactions()));
        afficherSolde();
    }



    private void afficherSolde() {
        double solde = gestionnaireBancaire.getSoldeCompte();
        labelSolde.setText(String.format("%.2f €", solde));
        if (solde < 0) {
            labelSolde.setTextFill(Color.RED);
        } else {
            labelSolde.setTextFill(Color.GREEN);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        observableListTransactions.setAll(gestionnaireBancaire.getTransactions());
        afficherSolde();
    }
}
