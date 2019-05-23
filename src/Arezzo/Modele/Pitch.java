package Arezzo.Modele;

public class Pitch {

    private PitchType currentPitch;

    private static int GRAVE = -1;
    private static int MEDIUM = 0;
    private static int AÏGUE = 1;

    public enum PitchType {
        GRAVE, MEDIUM, AÏGUE;
    }

    /**
     * Représente les différentes octaves, sous forme d'un enum
     */
    public Pitch() {
        System.out.println("[Pitch init:]");
        this.currentPitch = PitchType.MEDIUM;
    }

    /**
     * Transforme une note en fonction de l'octave actuelle.
     * Modifie la note, ne retourne pas une copie modifiée
     * @param src la note à transformer
     */
    void transform(Note src) {
        System.out.println("[Pitch transform:" + src + "]");
        switch (this.currentPitch) {
            case GRAVE:
                src.getOctave().set(Pitch.GRAVE);
                break;
            case MEDIUM:
                src.getOctave().set(Pitch.MEDIUM);
                break;
            case AÏGUE:
                src.getOctave().set(Pitch.AÏGUE);
                break;
        }
    }

    /**
     * Définie l'octave actuelle
     * @param pitch l'octave
     */
    public void setCurrentPitch(Pitch.PitchType pitch) {
        System.out.println("[Pitch setCurrentPitch:" + pitch + "]");
        this.currentPitch = pitch;
    }
}
