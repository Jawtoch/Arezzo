package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ListeNotesController {

    private ListeNotes listeNotes;

    @FXML private VBox liste;

    @FXML public void initialize() throws Exception {
        for(Note note: this.listeNotes) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("../Vues/VueNote.fxml"));
            fxmlLoader.setControllerFactory(ic -> new NoteController(note));
            this.liste.getChildren().add(fxmlLoader.load());
        }

    }

    public ListeNotesController(ListeNotes listeNotes) {
        this.listeNotes = listeNotes;
    }

}
