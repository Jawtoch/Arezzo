package Arezzo.Controllers;

import javafx.fxml.Initializable;
import partition.Partition;

import java.net.URL;
import java.util.ResourceBundle;

public class TempoController extends PartitionSettingsController implements Initializable {

    /**
     * Permet de modifier le tempo de la partition
     * @param partition
     */
    public TempoController(Partition partition) {
        super(partition);
        System.out.println("[TempoController init:" + partition + "]");
    }

    /**
     * Paramètre le slider
     */
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[VolumeController initialize:" + location + " " + resources + "]");

        this.label.setText("Tempo");

        this.slider.setMin(40);
        this.slider.setMax(220);

        this.slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Set tempo to " + this.slider.getValue());
            this.partition.setTempo(newValue.intValue());
        });
    }

    /**
     * Recupère le tempo actuel
     * @return le tempo
     */
    public double getTempo() {
        System.out.println("[VolumeController getTempo:]");
        return this.slider.getValue();
    }
}
