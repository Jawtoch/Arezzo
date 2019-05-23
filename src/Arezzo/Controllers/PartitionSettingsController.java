package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import partition.Partition;

abstract public class PartitionSettingsController {

    protected Partition partition;
    @FXML protected Label label;
    @FXML protected Slider slider;

    /**
     * Controller permettant de modifier des paramètres de la partition.
     * Le controller peut modifier ces paramètres avec un slider
     * @param partition la partition controllé
     */
    public PartitionSettingsController(Partition partition) {
        System.out.println("[PartitionSettingsController init:" + partition + "]");
        this.partition = partition;
    }

    @FXML public void initialize() throws Exception {
        System.out.println("[PartitionSettingsController initialize:]");
    }


}
