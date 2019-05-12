package Arezzo.Modele;

public class Pitch {

    private PitchType currentPitch;

    private static byte GRAVE = -1;
    private static byte MEDIUM = 0;
    private static byte AÏGUE = 1;

    public enum PitchType {
        GRAVE, MEDIUM, AÏGUE;
    }

    public Pitch() {
        System.out.println("[Pitch init:]");
        this.currentPitch = PitchType.MEDIUM;
    }

    void transform(abc.notation.Note src) {
        System.out.println("[Pitch transform:" + src + "]");
        switch (this.currentPitch) {
            case GRAVE:
                src.setOctaveTransposition(Pitch.GRAVE);
                break;
            case MEDIUM:
                src.setOctaveTransposition(Pitch.MEDIUM);
                break;
            case AÏGUE:
                src.setOctaveTransposition(Pitch.AÏGUE);
                break;
        }
    }

    public void setCurrentPitch(Pitch.PitchType pitch) {
        System.out.println("[Pitch setCurrentPitch:" + pitch + "]");
        this.currentPitch = pitch;
    }
}
