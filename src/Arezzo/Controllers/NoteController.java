package Arezzo.Controllers;

import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;


public class NoteController {

    private Note note;

    @FXML private Button button;
    @FXML private Label label;

    @FXML public void initialize() throws Exception {
        this.label.setText(note.getValue());
        this.button.setText("Ecouter");
    }

    @FXML private void jouer() {
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();

            Partition partition = new Partition(synthesizer);
            partition.setMelodie(this.note.getValue());
            partition.play();
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public NoteController(Note note) {
        this.note = note;
    }

}
