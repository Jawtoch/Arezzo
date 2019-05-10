package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Clavier implements Iterable<Touche>, ToucheDelegate {

    private ArrayList<Touche> touches = new ArrayList<>();
    public ClavierDelegate delegate;

    public Clavier() {
    }

    public void ajouterTouches(Touche... touches) {
        for(Touche touche: touches) {
            this.touches.add(touche);
            touche.delegate = this;
        }
    }

    public void supprimerTouches(Touche... touches) {

        for(Touche touche: touches) {
            this.touches.remove(touche);
        }
    }

    public boolean contains(Touche touche) {
        return this.touches.contains(touche);
    }

    public ArrayList<Touche> getTouches() {
        return this.touches;
    }

    public int size() {
        return this.touches.size();
    }

    @Override
    public Iterator<Touche> iterator() {
        return this.touches.iterator();
    }

    @Override
    public void touchUpInside(Note note) {
        if(this.delegate != null)
            this.delegate.ajouterNote(note);
    }
}
