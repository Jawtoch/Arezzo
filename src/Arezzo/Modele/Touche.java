package Arezzo.Modele;

import abc.notation.Note;

public class Touche {

    private abc.notation.Note note;
    ToucheDelegate delegate;

    public Touche(abc.notation.Note note) {
        System.out.println("[Touche init:" + note + "]");
        this.note = note;
    }

    public void pressed() {
        System.out.println("[Touche pressed:]");
        if (this.delegate != null)
            this.delegate.touchUpInside(this.getNote());
    }

    public abc.notation.Note getNote() {
        System.out.println("[Touche getNote:]");
        try {
            Note n = (Note) this.note.clone();
            return n;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return this.note;
    }

}
