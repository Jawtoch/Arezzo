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
        System.out.println("[NoteController initialize:]");
        this.label.setText(note.getValue());
        this.button.setText("Ecouter");
    }

    public void play() {
        System.out.println("[NoteController play:]");
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();

            Partition partition = new Partition(synthesizer);
            partition.setMelodie(this.note.getValue());

            // MARK: - Uncomment for sound
            partition.play();
            System.out.println("Playing sound " + this.note.getValue());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    NoteController(Note note) {
        System.out.println("[NoteController init:]");
        this.note = note;
    }

}
