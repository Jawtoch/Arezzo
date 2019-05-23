package Arezzo.Modele;

public class Duration {

    private DurationType currentDuration;

    static final int CROCHE = 1/2;
    static final int NOIRE = 1;
    static final int BLANCHE = 2;
    static final int RONDE = 4;

    public enum DurationType {
        CROCHE, NOIRE, BLANCHE, RONDE;
    }

    /**
     * Permet de changer la durée des notes
     */
    public Duration() {
        System.out.println("[Duration init:]");
        this.currentDuration = DurationType.NOIRE;
    }

    /**
     * Transforme une note en fonction de la durée actuelle
     * @param note la note à modifier
     */
    void transform(Note note) {
        System.out.println("[Duration transform:" + note + "]");

        int value = NOIRE;

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
        note.setDuration(value);
    }

    /**
     * Définie la durée actuelle
     * @param duration une durée
     */
    public void setCurrentDuration(DurationType duration) {
        System.out.println("[Duration setCurrentDuration:" + duration + "]");
        this.currentDuration = duration;
    }

}
