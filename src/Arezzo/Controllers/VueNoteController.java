package Arezzo.Controllers;

import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import partition.Partition;

import javax.sound.midi.Synthesizer;


public class VueNoteController {

    Note note;

    @FXML private Button button;

    @FXML private Label label;

    @FXML public void initialize() throws Exception {
        this.label.setText(note.getValue());
        this.button.setText("Ecouter");
    }

    @FXML private void jouer() {
        //Partition partition = new Partition()
    }
    
    public VueNoteController(Note note) {
        this.note = note;
    }

}
