package Arezzo.Controllers;

import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import javax.swing.text.html.ImageView;

/** PROJET */

public class NoteController {

    private Note _note;

    @FXML private Label octave;
    @FXML private Label note;
    @FXML private ImageView imageView;

    @FXML public void initialize() throws Exception {
        System.out.println("[NoteController initialize:]");
        this.note.setText(String.valueOf(_note.getValue()));
    }

    public void play() {
        System.out.println("[NoteController play:]");
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();

            Partition partition = new Partition(synthesizer);
            partition.setMelodie(String.valueOf(this._note.getValue()));

            // MARK: - Uncomment for sound
            partition.play();
            System.out.println("Playing sound " + this._note.getValue());
        } catch (MidiUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    NoteController(Note note) {
        System.out.println("[NoteController init:]");
        this._note = note;
    }

}
