package Arezzo.Modele;

public class Touche {

    protected final Note note;
    public ToucheDelegate delegate;

    /**
     * Touche d'un clavier, contenant une note
     * @param note la note de la touche
     */
    public Touche(Note note) {
        System.out.println("[Touche init:" + note + "]");
        this.note = note;
    }

    /**
     * Un appui sur la touche
     */
    public void pressed() {
        System.out.println("[Touche pressed:]");
        if (this.delegate != null)
            this.delegate.touchUpInside(this.getNote());
    }

    /**
     * Récupère une copie de la note de la touche
     * @return la note de la touche
     */
    public Note getNote() {
        System.out.println("[Touche getNote:]");
        Note n = new Note(this.note.getValue());
        return n;
    }

}
