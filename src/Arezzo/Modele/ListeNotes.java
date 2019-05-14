package Arezzo.Modele;

import abc.notation.Note;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.Observable;

public class ListeNotes extends Observable implements Iterable<abc.notation.Note>, ClavierDelegate {

    private Pitch pitch;
    private Duration duration;
    private ObservableList<abc.notation.Note> list = FXCollections.observableArrayList();

    public ListeNotes() {
        System.out.println("[ListeNotes init:]");
    }

    private void ajouter(abc.notation.Note note) {
        System.out.println("[ListeNotes ajouter:" + note + "]");

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

    public void supprimer(int index) {
        System.out.println("[ListeNotes supprimer:" + index + "]");
        this.list.remove(index);
        this.setChanged();
        this.notifyObservers();
    }

    private boolean contains(abc.notation.Note note) {
        System.out.println("[ListeNotes contains:" + note + "]");
        return this.list.contains(note);
    }

    public void setPitch(Pitch p) {
        System.out.println("[ListeNotes setPitch:" + p + "]");
        this.pitch = p;
    }

    public ObservableList<abc.notation.Note> getList() {
        System.out.println("[ListeNotes getList:]");
        return this.list;
    }

    @Override public Iterator<abc.notation.Note> iterator() {
        System.out.println("[ListeNotes iterator:]");
        return this.list.iterator();
    }

    @Override
    public void ajouterNote(abc.notation.Note note) {
        System.out.println("[ListeNotes ajouterNote:" + note + "]");
        this.ajouter(note);
    }

    public Note get(int index) {
        System.out.println("[ListeNotes get:" + index + "]");
        return this.list.get(index);
    }

    public void set(int index, Note note) {
        System.out.println("[ListeNotes set:" + index + " " + note + "]");
        this.list.set(index, note);
        setChanged();
        notifyObservers();
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
}
