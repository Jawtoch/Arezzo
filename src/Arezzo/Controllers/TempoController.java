package Arezzo.Controllers;

import javafx.fxml.FXML;
import partition.Partition;

public class TempoController extends PartitionSettingsController {

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
     * @throws Exception
     */
    @FXML public void initialize() throws Exception {
        System.out.println("[VolumeController initialize:]");

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
