package Arezzo.Controllers;

import Arezzo.Modele.Clavier;
import Arezzo.Modele.ClavierDelegate;
import Arezzo.Modele.Note;
import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ClavierController implements Observer, ClavierDelegate {

    private Clavier clavier;
    private PartitionController partitionController;
    private String noteType = "medium";

    @FXML private Pane pane;

    @FXML public void initialize() throws Exception {

        int toucheSize = 40;
        int lastXPosition = -40;

        ArrayList<AnchorPane> noires = new ArrayList<>();

        for(Touche touche: this.clavier) {
            FXMLLoader toucheFxmlLoader = new FXMLLoader();
            toucheFxmlLoader.setLocation(getClass().getResource("../Vues/VueTouche.fxml"));
            toucheFxmlLoader.setControllerFactory(ic -> new ToucheController(touche, this.partitionController));

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

    public ClavierController(Clavier clavier, PartitionController partitionController) {
        this.clavier = clavier;
        this.clavier.delegate = this;
        this.partitionController = partitionController;
    }

    @Override
    public void update(Observable o, Object arg) {
        PitchController pitchController = (PitchController) o;
        this.noteType = pitchController.getType();
    }

    @Override
    public void ajouterNote(Note note) {

    }
}
