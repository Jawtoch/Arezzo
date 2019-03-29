package Arezzo.Modele;

public class Note {

    String value;

    public Note(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "Note " + this.value;
    }

}
