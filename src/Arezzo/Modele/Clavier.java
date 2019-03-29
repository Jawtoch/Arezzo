package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Iterator;

public class Clavier implements Iterable<Touche> {

    private ArrayList<Touche> touches = new ArrayList<>();

    public Clavier() {
    }

    public void ajouterTouches(Touche... touches) {
        for(Touche touche: touches) {
            this.touches.add(touche);
        }
    }

    public void supprimerTouches(Touche... touches) {
        for(Touche touche: touches) {
            if (this.touches.contains(touche))
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
}
