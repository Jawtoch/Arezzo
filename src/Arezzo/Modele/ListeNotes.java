package Arezzo.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Iterator;
import java.util.Observable;

public class ListeNotes extends Observable implements Iterable<Note>, ClavierDelegate {

    private Pitch pitch;
    private ObservableList<Note> list = FXCollections.observableArrayList();

    public ListeNotes() {
        System.out.println("[ListeNotes init:]");
    }

    private void ajouter(Note note) {
        System.out.println("[ListeNotes ajouter:" + note + "]");

        if (this.pitch != null) {
            note = this.pitch.transform(note);
        }
        this.list.add(note);

        setChanged();
        notifyObservers();
    }

    public void set(int index, Note note) {
        System.out.println("[ListeNotes set:" + index + " " + note + "]");
        if (index >= 0 && index < this.list.size()) {
            this.list.set(index, note);
            setChanged();
            notifyObservers();
        }
    }

    public void supprimer(Note note) {
        System.out.println("[ListeNotes supprimer:" + note + "]");
        if (this.contains(note))
            this.list.remove(note);
    }

    private boolean contains(Note note) {
        System.out.println("[ListeNotes contains:" + note + "]");
        return this.list.contains(note);
    }

    public void setPitch(Pitch p) {
        System.out.println("[ListeNotes setPitch:" + p + "]");
        this.pitch = p;
    }

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
}
