package Arezzo.Modele;

public class Touche {

    private Note note;
    private ToucheDelegate delegate;

    public Touche(Note note) {
        this.note = note;
    }

    public void pressed() {
        if (this.delegate != null)
            this.delegate.touchUpInside(this.getNote());
    }

    public Note getNote() {
        return this.note;
    }

}
