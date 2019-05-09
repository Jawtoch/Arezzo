package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;

public class ListeNotesController implements Observer {

    private PartitionController partitionController;

    @FXML private VBox liste;

    @FXML public void initialize() throws Exception {
        for(Note note: this.partitionController.getNotes()) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Vues/VueNote.fxml"));
            fxmlLoader.setControllerFactory(ic -> new NoteController(note));
            this.liste.getChildren().add(fxmlLoader.load());
        }

    }

    public ListeNotesController(PartitionController partitionController) {
        this.partitionController = partitionController;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.liste.getChildren().clear();
        for(Note note: this.partitionController.getNotes()) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Vues/VueNote.fxml"));
            fxmlLoader.setControllerFactory(ic -> new NoteController(note));

            try {
                this.liste.getChildren().add(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
