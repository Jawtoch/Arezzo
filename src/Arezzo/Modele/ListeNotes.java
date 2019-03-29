package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Iterator;

public class ListeNotes implements Iterable<Note> {

    private ArrayList<Note> noteArrayList = new ArrayList<>();

    public ListeNotes() {

    }

    public void ajouter(Note note) {
        this.noteArrayList.add(note);
    }

    public void supprimer(Note note) {
        if (this.contains(note))
            this.noteArrayList.remove(note);
    }

    public boolean contains(Note note) {
        return this.noteArrayList.contains(note);
    }

    @Override public Iterator<Note> iterator() {
        return this.noteArrayList.iterator();
    }
}
