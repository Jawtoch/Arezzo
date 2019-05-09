package Arezzo.Controllers;

import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import partition.Partition;

import java.util.ArrayList;
import java.util.Observable;

public class PartitionController extends Observable {

    @FXML private ScrollPane image;

    private Partition partition;
    private ArrayList<Note> notes = new ArrayList<>();

    public PartitionController(Partition partition) {
        this.partition = partition;
    }

    @FXML public void initialize() throws Exception {
        this.image.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.partition.setMelodie("");
        this.image.setContent(new ImageView(partition.getImage()));
    }

    void ajouterNote(Note note) {
        this.notes.add(note);

        StringBuilder mel = new StringBuilder();
        for(Note n: this.notes) {
            mel.append(" ").append(n.getValue());
        }

        partition.setMelodie(mel.toString());
        this.image.setContent(new ImageView(partition.getImage()));

        setChanged();
        notifyObservers();
    }

    Note[] getNotes() {
        return this.notes.toArray(new Note[0]);
    }

}
