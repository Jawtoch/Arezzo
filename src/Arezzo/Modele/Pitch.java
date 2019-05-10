package Arezzo.Modele;

public class Pitch {

    String currentPitch;

    Pitch() {
        this.currentPitch = "medium";
    }

    Note transform(Note src) {
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
}
