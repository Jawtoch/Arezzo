package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class VueListeNotesController {

    ListeNotes listeNotes;

    @FXML
    VBox liste;

    public VueListeNotesController(ListeNotes listeNotes) {
        this.listeNotes = listeNotes;

        for(Note note: this.listeNotes) {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("Vues/VueNote.fxml"));
            fxmlLoader.setControllerFactory(ic -> new VueNoteController(note));

            try {
                this.liste.getChildren().add(fxmlLoader.load());
            } catch (IOException e) {
                System.out.println("Erreur, impossible de charger la note " + note);
                e.printStackTrace();
            }
        }
    }

}
