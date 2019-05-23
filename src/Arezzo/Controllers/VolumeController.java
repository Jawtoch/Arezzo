package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import partition.Partition;

import java.net.URL;
import java.util.ResourceBundle;

public class VolumeController extends PartitionSettingsController implements Initializable {

    /**
     * Permet de modifier le volume de la partition.
     * NOTE: Ayant travaillé sur mon ordinateur personnel (MacOS), l'appel sur la méthode 'setVolume' de Partition renvoyait une erreur sur la console.
     * Je ne suis donc pas sûr que cette classe fonctionne correctement
     * @param partition la partition à controller
     */
    public VolumeController(Partition partition) {
        super(partition);
        System.out.println("[VolumeController init:" + partition + "]");
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[VolumeController initialize:" + location + " " + resources + "]");

        this.label.setText("Volume");

        this.slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Set volume to " + this.slider.getValue());
            this.partition.setVolume(newValue.doubleValue());
        });
    }
}
