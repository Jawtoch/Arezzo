package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Clavier implements Iterable<Touche>, ToucheDelegate {

    private ArrayList<Touche> touches = new ArrayList<>();
    public ClavierDelegate delegate;

    public Clavier() {
        System.out.println("[Clavier init:]");
    }

    public void ajouterTouches(Touche... touches) {
        System.out.println("[Clavier ajouterTouches:" + Arrays.toString(touches) + "]");
        for(Touche touche: touches) {
            this.touches.add(touche);
            touche.delegate = this;
        }
    }

    public void supprimerTouches(Touche... touches) {
        System.out.println("[Clavier supprimerTouches:" + Arrays.toString(touches) + "]");

        for(Touche touche: touches) {
            this.touches.remove(touche);
        }
    }

    public boolean contains(Touche touche) {
        System.out.println("[Clavier contains:" + touche + "]");
        return this.touches.contains(touche);
    }

    public ArrayList<Touche> getTouches() {
        System.out.println("[Clavier getTouches:]");
        return this.touches;
    }

    public int size() {
        System.out.println("[Clavier size:]");
        return this.touches.size();
    }

    @Override
    public Iterator<Touche> iterator() {
        System.out.println("[Clavier iterator:]");
        return this.touches.iterator();
    }

    @Override
    public void touchUpInside(Note note) {
        System.out.println("[Clavier touchUpInside:" + note + "]");
        if(this.delegate != null)
            this.delegate.ajouterNote(note);
    }
}
