package Arezzo.Modele;

import abc.notation.Note;

public class Duration {

    private DurationType currentDuration;

    static final short CROCHE = 48;
    static final short NOIRE = 96;
    static final short BLANCHE = 192;
    static final short RONDE = 384;

    public enum DurationType {
        CROCHE, NOIRE, BLANCHE, RONDE;
    }

    public Duration() {
        System.out.println("[Duration init:]");
        this.currentDuration = DurationType.NOIRE;
    }

    void transform(Note note) {
        System.out.println("[Duration transform:" + note + "]");

        short value = NOIRE;

        switch (this.currentDuration) {
            case NOIRE:
                value = NOIRE;
                break;
            case RONDE:
                value = RONDE;
                break;
            case CROCHE:
                value = CROCHE;
                break;
            case BLANCHE:
                value = BLANCHE;
                break;
        }
        note.setStrictDuration(value);
    }

    public void setCurrentDuration(DurationType duration) {
        System.out.println("[Duration setCurrentDuration:" + duration + "]");
        this.currentDuration = duration;
    }

}
