package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import partition.Partition;

public class PartitionController {

    @FXML private ImageView image;

    private Partition partition;

    public PartitionController(Partition partition) {
        this.partition = partition;
    }

    public void ajouterNote(String note) {
        partition.setMelodie(note);
        this.image.setImage(partition.getImage());
    }
}
