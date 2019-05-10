package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class ListeNotes extends Observable implements Iterable<Note>, ClavierDelegate {

    private ArrayList<Note> noteArrayList = new ArrayList<>();
    private Pitch pitch;

    public ListeNotes() {

    }

    public void ajouter(Note note) {

        if (this.pitch != null) {
            note = this.pitch.transform(note);
        }
        this.noteArrayList.add(note);
        setChanged();
        notifyObservers();
    }

    public void supprimer(Note note) {
        if (this.contains(note))
            this.noteArrayList.remove(note);
    }

    public boolean contains(Note note) {
        return this.noteArrayList.contains(note);
    }

    public void setPitch(Pitch p) {
        this.pitch = p;
    }

    @Override public Iterator<Note> iterator() {
        return this.noteArrayList.iterator();
    }

    @Override
    public void ajouterNote(Note note) {
        this.ajouter(note);
    }
}
