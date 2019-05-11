package Arezzo.Modele;

public class Pitch {

    private String currentPitch;

    Pitch() {
        System.out.println("[Pitch init:]");
        this.currentPitch = "medium";
    }

    Note transform(Note src) {
        System.out.println("[Pitch transform:" + src + "]");
        Note n;
        switch (this.currentPitch) {
            case "grave":
                n = new Note(src.getValue() + ",");
                return n;
            case "aïgue":
                n = new Note(src.getValue().toLowerCase());
                return n;
            default:
                return src;
        }
    }

    public void setCurrentPitch(String pitch) {
        System.out.println("[Pitch setCurrentPitch:" + pitch + "]");
        this.currentPitch = pitch;
    }
}
