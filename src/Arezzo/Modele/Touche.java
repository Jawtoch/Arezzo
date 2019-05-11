package Arezzo.Modele;

public class Touche {

    private Note note;
    ToucheDelegate delegate;

    public Touche(Note note) {
        System.out.println("[Touche init:" + note + "]");
        this.note = note;
    }

    public void pressed() {
        System.out.println("[Touche pressed:]");
        if (this.delegate != null)
            this.delegate.touchUpInside(this.getNote());
    }

    public Note getNote() {
        System.out.println("[Touche getNote:]");
        return this.note;
    }

}
