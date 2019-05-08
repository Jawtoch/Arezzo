package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import partition.Partition;

public class PartitionController {

    @FXML private ImageView image;

    private Partition partition;
    private String notes = "";

    public PartitionController(Partition partition) {
        this.partition = partition;
    }

    public void ajouterNote(String note) {
        this.notes += note + " ";

        partition.setMelodie(this.notes);
        this.image.setImage(partition.getImage());
    }
}
