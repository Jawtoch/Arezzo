package Arezzo.Controllers;

import Arezzo.Modele.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ClavierController implements ClavierDelegate {

    private Clavier clavier;
    private ListeNotes listeNotes;

    @FXML private Pane pane;

    @FXML public void initialize() throws Exception {
        System.out.println("[ClavierController initialize:]");

        int toucheSize = 40;
        int lastXPosition = -40;

        ArrayList<AnchorPane> noires = new ArrayList<>();

        for(Touche touche: this.clavier) {
            FXMLLoader toucheFxmlLoader = new FXMLLoader();
            toucheFxmlLoader.setLocation(getClass().getResource("../Vues/VueTouche.fxml"));
            toucheFxmlLoader.setControllerFactory(ic -> new ToucheController(touche));

            AnchorPane element = toucheFxmlLoader.load();

            if (touche.getNote().getValue().contains("^")) {
                // Noire
                element.relocate(lastXPosition + (toucheSize >> 1), 0);
                element.setPrefHeight(element.getPrefHeight() / 2);
                noires.add(element);
            } else {
                // Blanche
                element.relocate(lastXPosition + toucheSize, 0);
                element.toBack();
                lastXPosition += toucheSize;
            }

            this.pane.getChildren().add(element);
        }

        for(AnchorPane anchorPane: noires) {
            anchorPane.toFront();
        }
    }

    public ClavierController(Clavier clavier) {
        System.out.println("[ClavierController init:]");
        this.clavier = clavier;
        this.clavier.delegate = this;
    }

    public void setListeNotes(ListeNotes listeNotes) {
        System.out.println("[ClavierController setListeNote:" + listeNotes + "]");
        this.listeNotes = listeNotes;
    }

    @Override
    public void ajouterNote(Note note) {
        System.out.println("[ClavierController ajouterNote:" + note + "]");
        this.listeNotes.ajouterNote(note);
    }
}
