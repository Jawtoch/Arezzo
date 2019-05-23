package Arezzo.Controllers;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import partition.Partition;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class ToolsController implements Initializable {

    @FXML private VBox vBox;
    private Label titleLabel;
    private TempoController tempoController;
    private PartitionController partition;

    /**
     * Regroupe tous les outils nécessaire à la modification de la partition
     * @param partition la partition à controller
     */
    public ToolsController(PartitionController partition) {
        this.partition = partition;
    }

    /**
     * Initialise un label pour le titre de la mélodie, un bouton pour jouer la mélodie. Celui-ci modifie sa transparence pendant la lecture.
     * Contient un VolumeController, InstrumentController, TempoController
     * @param location
     * @param resources
     */
    @Override public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[ToolsController initialize:" + location + " " + resources + "]");

        Partition partition = this.partition.getPartition();
        ObservableList<Node> vBoxChildren = this.vBox.getChildren();

        this.titleLabel = new Label("Clique ici pour le titre de votre mélodie");
        this.titleLabel.setOnMouseClicked(event -> {
            TextInputDialog dialog = new TextInputDialog("Titre");
            dialog.setTitle("Définir un titre");
            Optional<String> title = dialog.showAndWait();

            this.titleLabel.setText(title.get());
        });
        vBoxChildren.add(titleLabel);

        Button button = new Button("Play");
        button.setOnAction(event -> {

            double temps = this.partition.getTemps();
            double tempo = this.tempoController.getTempo();

            double time = (1 / tempo) * temps * 60;

            FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), button);
            fadeTransition.setFromValue(0.0);
            fadeTransition.setToValue(1.0);
            fadeTransition.setCycleCount((int) time);

            this.partition.play();
            fadeTransition.play();
            }
        );
        vBoxChildren.add(button);

        FXMLLoader volumeFxmlLoader = new FXMLLoader();
        volumeFxmlLoader.setLocation(getClass().getResource("/fxml/VuePartitionSettingsController.fxml"));
        volumeFxmlLoader.setControllerFactory(ic -> new VolumeController(partition));
        try {
            vBoxChildren.add(volumeFxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader tempoFxmlLoader = new FXMLLoader();
        tempoFxmlLoader.setLocation(getClass().getResource("/fxml/VuePartitionSettingsController.fxml"));
        tempoFxmlLoader.setControllerFactory(ic -> {
            this.tempoController = new TempoController(partition);
            return this.tempoController;
        });
        try {
            vBoxChildren.add(tempoFxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        FXMLLoader testFXML = new FXMLLoader();
        testFXML.setLocation(getClass().getResource("/fxml/VueInstruments.fxml"));
        testFXML.setControllerFactory(ic -> new InstrumentsController(partition));
        try {
            vBoxChildren.add(testFXML.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
