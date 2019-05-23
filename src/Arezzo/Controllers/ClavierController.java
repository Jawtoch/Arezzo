package Arezzo.Controllers;

import Arezzo.Modele.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClavierController implements ClavierDelegate, Initializable {

    private Clavier clavier;
    private ListeNotes listeNotes;

    @FXML private Pane pane;

    /**
     * Contruit le clavier en fonction des notes des touches. Une noire sera représentée autrement qu'une blanche.
     * Ajoute une touche chut en bas du clavier
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[ClavierController initialize:" + location + " " + resources + "]");

        int toucheSize = 40;
        int lastXPosition = 0;

        ArrayList<Button> noires = new ArrayList<>();

        for(Touche touche: this.clavier) {
            try {
                FXMLLoader toucheFxmlLoader = new FXMLLoader();
                toucheFxmlLoader.setLocation(getClass().getResource("../Vues/VueTouche.fxml"));
                toucheFxmlLoader.setControllerFactory(ic -> new ToucheController(touche));

                Button element = toucheFxmlLoader.load();

                Note note = touche.getNote();
                String name = note.getNote();

                if (name.contains("^")) {
                    // Noire
                    element.relocate(lastXPosition - (toucheSize >> 1) + 5, 0);
                    element.setPrefHeight(element.getPrefHeight() / 2);
                    element.setPrefWidth(element.getPrefWidth() - 10);
                    element.setStyle("-fx-background-color: #000000");
                    noires.add(element);
                } else {
                    // Blanche
                    element.relocate(lastXPosition, 0);
                    element.setPrefHeight(element.getPrefHeight() - 20);
                    element.toBack();
                    lastXPosition += toucheSize;
                }

                this.pane.getChildren().add(element);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for(Button button: noires) {
            button.toFront();
        }

        Chut chut = new Chut();
        chut.delegate = this.clavier;
        FXMLLoader chutFxmlLoader = new FXMLLoader();
        chutFxmlLoader.setLocation(getClass().getResource("../Vues/VueTouche.fxml"));
        chutFxmlLoader.setControllerFactory(ic -> new ChutController(chut));

        try {
            Button chutButton = chutFxmlLoader.load();
            chutButton.setPrefWidth(lastXPosition);
            chutButton.setPrefHeight(20);

            chutButton.relocate(0, this.pane.getPrefHeight() - 30);
            this.pane.getChildren().add(chutButton);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Représente un clavier
     * @param clavier le clavier à représenter
     */
    public ClavierController(Clavier clavier) {
        System.out.println("[ClavierController init:]");
        this.clavier = clavier;
        this.clavier.delegate = this;
    }

    /**
     * Définie la liste de notes
     * @param listeNotes
     */
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
