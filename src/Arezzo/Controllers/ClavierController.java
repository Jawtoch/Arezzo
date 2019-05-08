package Arezzo.Controllers;

import Arezzo.Modele.Clavier;
import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class ClavierController {

    private Clavier clavier;
    private PartitionController partitionController;

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
        this.partitionController = partitionController;
    }
}
