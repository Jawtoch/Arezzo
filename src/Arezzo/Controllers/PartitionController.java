package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import partition.Partition;

public class PartitionController {

    @FXML private ScrollPane image;

    private Partition partition;

    public PartitionController(Partition partition) {
        this.partition = partition;
    }

    @FXML public void initialize() throws Exception {
        this.image.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.partition.setMelodie("");
        this.image.setContent(new ImageView(partition.getImage()));
    }

}
