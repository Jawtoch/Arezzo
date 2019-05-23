package Arezzo.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.Observable;

public class ListeNotes extends Observable implements Iterable<Note>, ClavierDelegate {

    private Pitch pitch;
    private Duration duration;
    private ObservableList<Note> list = FXCollections.observableArrayList();
    private Note lastNote;

    /**
     * Une liste contenant les notes
     */
    public ListeNotes() {
        System.out.println("[ListeNotes init:]");
    }

    /**
     * Ajoute une note à la liste, et notifie ses observers
     * @param note la note à ajouter
     */
    private void ajouter(Note note) {
        System.out.println("[ListeNotes ajouter:" + note + "]");

        this.setLastNote(note);

        if (note.getValue() == -1) {
            this.list.add(note);
            setChanged();
            notifyObservers();
            return;
        }

        if (this.pitch != null) {
            this.pitch.transform(note);
        }
        if (this.duration != null) {
            this.duration.transform(note);
        }
        this.list.add(note);

        setChanged();
        notifyObservers();
    }

    /**
     * Supprime une note à un index donné. Supprimer une note revient à la transformer en silence
     * @param index la note à supprimer
     */
    public void supprimer(int index) {
        System.out.println("[ListeNotes supprimer:" + index + "]");
        Note n = this.list.get(index);
        n.setValue(-1);

        this.setChanged();
        this.notifyObservers();
    }

    /**
     * Définie l'objet Pitch permettant de changer l'octave des futures notes qui seront ajoutées
     * @param p
     */
    public void setPitch(Pitch p) {
        System.out.println("[ListeNotes setPitch:" + p + "]");
        this.pitch = p;
    }

    /**
     * La liste des notes
     * @return la liste
     */
    public ObservableList<Note> getList() {
        System.out.println("[ListeNotes getList:]");
        return this.list;
    }

    @Override public Iterator<Note> iterator() {
        System.out.println("[ListeNotes iterator:]");
        return this.list.iterator();
    }

    @Override
    public void ajouterNote(Note note) {
        System.out.println("[ListeNotes ajouterNote:" + note + "]");
        this.ajouter(note);
    }

    /**
     * Transpose une note d'un nombre donné de demi-tons, à un index donné. En cas d'index incorrect, ne fait rien
     * @param index l'index de la note à transposer
     * @param semitones le nombre de demi-tons à transposer
     * @throws OctaveError si la note ne peut être transposée
     */
    public void transpose(int index, int semitones) throws OctaveError {
        System.out.println("[ListeNotes transpose:" + index + " " + semitones + "]");
        Note note = this.list.get(index);
        if (note != null) {
            note.transpose(semitones);
            setChanged();
            notifyObservers();
        }
    }

    /**
     * Définie l'objet duration, permettant de changer la durée des futures notes qui seront ajoutées
     * @param duration
     */
    public void setDuration(Duration duration) {
        System.out.println("[ListeNotes setDuration:" + duration + "]");
        this.duration = duration;
    }

    /**
     * Récupère la dernière note ajoutée
     * @return la dernière note ajoutée
     */
    public Note getLastNote() {
        return lastNote;
    }

    /**
     * Définie la dernière note ajoutée
     * @param lastNote la dernière note ajoutée
     */
    public void setLastNote(Note lastNote) {
        this.lastNote = lastNote;
    }
}
