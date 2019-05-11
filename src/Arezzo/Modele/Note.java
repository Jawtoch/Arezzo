package Arezzo.Modele;

public class Note {

    private String value;

    public Note(String value) {
        System.out.println("[Note init:" + value + "]");
        this.value = value;
    }

    public String getValue() {
        System.out.println("[Note getValue:]");
        return this.value;
    }

    @Override
    public String toString() {
        return "Note " + this.value;
    }

}
