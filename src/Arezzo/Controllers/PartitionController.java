package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
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

    /**
     * Permet de controller la partition (ajout de notes, lecture)
     * @param partition
     */
    public PartitionController(Partition partition) {
        System.out.println("[PartitionController init:" + partition + "]");
        this.partition = partition;
    }

    /**
     * Définie la liste des notes, source de la mélodie
     * @param listeNote
     */
    public void setListeNote(ListeNotes listeNote) {
        System.out.println("[PartitionController setListeNote:" + listeNote + "]");
        this.listeNotes = listeNote;
        this.listeNotes.addObserver(this);
    }

    /**
     * Lecture de la partition
     */
    public void play() {
        System.out.println("[PartitionController play:]");
        this.partition.play();
    }

    /**
     * Retourne la partition
     * @return
     */
    public Partition getPartition() {
        System.out.println("[PartitionController getPartition:]");
        return this.partition;
    }

    /**
     * Bind la largeur de la partition avec la largeur du scrollPane
     * @throws Exception
     */
    @FXML public void initialize() throws Exception {
        System.out.println("[PartitionController initialize:]");
        this.image.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        this.partition.setMelodie("");
        this.partition.setPreferedMaxWidth((int) this.image.getPrefWidth());

        this.image.widthProperty().addListener(
                (
                        (observable, oldValue, newValue) -> {
                            Double w = (Double) newValue;
                            partition.setPreferedMaxWidth(w.intValue());
                        }
                )
        );

        this.image.setContent(new ImageView(partition.getImage()));
    }

    /**
     * Récupère la somme des durées des notes
     * @return la durée totale
     */
    public double getTemps() {
        ObservableList<Note> notes = this.listeNotes.getList();
        double temps = 0;
        for(Note note: notes) {
            double duration = note.getDurationValue();
            if (duration == 0)
                temps += 1/2;
            else
                temps += duration;
        }

        return temps;
    }

    /**
     * Affiche la partition en cas de changement de la liste de notes
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("[PartitionController update:" + o + " " + arg + "]");
        ObservableList<Note> notes = this.listeNotes.getList();

        double temps = 0;

        StringBuilder melodie = new StringBuilder();
        for(Note note: notes) {
            melodie.append(note.getNote());
            melodie.append(" ");

            temps += note.getDurationValue();
            if (temps >= 4) {
                melodie.append("|");
                temps = 0;
            }
        }
        this.partition.setMelodie(melodie.toString());
        this.image.setContent(new ImageView(this.partition.getImage()));
    }
}
