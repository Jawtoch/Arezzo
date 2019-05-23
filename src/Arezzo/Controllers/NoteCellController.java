package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import Arezzo.Modele.Octave;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class NoteCellController {

    private ListeNotes listeNotes;
    private HBox hBox;
    private Note _note;

    @FXML private Label octave;
    @FXML private Label note;

    /**
     * Controlleur de la cellule d'une note de la liste de notes
     * @param listeNotes la liste de note
     */
    NoteCellController(ListeNotes listeNotes) {
        this.listeNotes = listeNotes;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Vues/VueNote.fxml"));
            loader.setController(this);

            this.hBox = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Définie la note de la cellule
     * @param note une note
     */
    public void setNote(Note note) {
        this._note = note;
        this.note.setText(this._note.prettyName());
        Octave octave = this._note.getOctave();
        this.octave.setText(octave.toString());
    }

    /**
     * La HBox de la cellule
     * @return
     */
    public Node getView() {
        return this.hBox;
    }
}
