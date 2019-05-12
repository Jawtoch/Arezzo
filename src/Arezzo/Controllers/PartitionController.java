package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import Arezzo.Modele.NoteFormatter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import partition.Partition;

import java.util.Observable;
import java.util.Observer;

public class PartitionController implements Observer {

    @FXML private ScrollPane image;

    private Partition partition;
    private ListeNotes listeNotes;

    public PartitionController(Partition partition) {
        System.out.println("[PartitionController init:" + partition + "]");
        this.partition = partition;
    }

    public void setListeNote(ListeNotes listeNote) {
        System.out.println("[PartitionController setListeNote:" + listeNote + "]");
        this.listeNotes = listeNote;
        this.listeNotes.addObserver(this);
    }

    @FXML public void initialize() throws Exception {
        System.out.println("[PartitionController initialize:]");
        this.image.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.partition.setMelodie("");
        this.image.setContent(new ImageView(partition.getImage()));
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("[PartitionController update:" + o + " " + arg + "]");
        ObservableList<abc.notation.Note> notes = this.listeNotes.getList();

        int index = 0;

        StringBuilder melodie = new StringBuilder();
        for(abc.notation.Note note: notes) {
            melodie.append(NoteFormatter.format(note));
            melodie.append(" ");

            index++;
            if (index == 4) {
                melodie.append("|");
                index = 0;
            }
        }
        this.partition.setMelodie(melodie.toString());
        this.image.setContent(new ImageView(this.partition.getImage()));
    }
}
