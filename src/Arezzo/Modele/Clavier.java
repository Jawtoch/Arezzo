package Arezzo.Modele;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Clavier implements Iterable<Touche>, ToucheDelegate {

    private ArrayList<Touche> touches = new ArrayList<>();
    public ClavierDelegate delegate;

    /**
     * Crée un clavier, sans touches
     */
    public Clavier() {
        System.out.println("[Clavier init:]");
    }

    /**
     * Ajoute des touches au clavier
     * @param touches les touches à ajouter
     */
    public void ajouterTouches(Touche... touches) {
        System.out.println("[Clavier ajouterTouches:" + Arrays.toString(touches) + "]");
        for(Touche touche: touches) {
            this.touches.add(touche);
            touche.delegate = this;
        }
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
