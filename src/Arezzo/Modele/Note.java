package Arezzo.Modele;

public class Note {

    private int value;
    private int duration;
    private Octave octave;
    private String accidental;


    /**
     * Instancie une note avec une valeur définie entre 0 et 11, ainsi que -1 pour le silence
     * @param value la valeur de la note
     */
    public Note(int value) {
        System.out.println("[Note init:" + value + "]");
        this.value = value;
        this.octave = new Octave(0);
        this.duration = 1;
        this.accidental = "";

        this.setAccidental();
    }

    /**
     * Définie la valeur de l'accent de la note
     */
    private void setAccidental() {
        System.out.println("[Note setAccidental:]");
        if (value == 1 || value == 3 || value == 6 || value == 8 || value == 10) {
            this.accidental = "^";
        } else {
            this.accidental = "";
        }
    }

    /**
     * Transpose la note. Cette méthode transpose la valeur de la note, et change si nécessaire son accidental et son octave
     * @param semitones le nombre de demi-tons à transposer
     * @throws OctaveError si la note ne peut etre transposée plus haut ou plus bas
     */
    public void transpose(int semitones) throws OctaveError {
        System.out.println("[Note transpose:" + semitones + "]");
        if (this.value + semitones > 11) {
            this.octave.augmenter();
        } else if (this.value + semitones < 0) {
            this.octave.descendre();
        }

        this.value = (this.value + semitones) % 12;

        while (this.value < 0) {
            this.value += 12;
        }

        this.setAccidental();
    }

    /**
     * L'octave de la note
     * @return l'octave
     */
    public Octave getOctave() {
        System.out.println("[Note getOctave:]");
        return this.octave;
    }

    /**
     * La valeur de la note
     * @return sa valeur
     */
    public int getValue() {
        System.out.println("[Note getValue:]");
        return this.value;
    }

    /**
     * Définie la durée de la note
     * @param duration une durée comprise dans [1/2, 1, 2, 3, 4]
     */
    public void setDuration(int duration) {
        System.out.println("[Note setDuration:" + duration + "]");
        if ((duration == 1/2) || (duration == 1) || (duration == 2) || (duration == 3) || (duration == 4)) {
            this.duration = duration;
        } else {
            this.duration = 1;
        }
    }

    /**
     * La valeur de la durée de la note, nécessaire pour calculer la durée réelle de la mélodie
     * @return la durée de la note
     */
    public int getDurationValue() {
        System.out.println("[Note getDurationValue:]");
        int val = 0;
        switch (this.duration) {
            case 0:
                val = 96;
                break;
            case 1:
                val = 192;
                break;
            case 2:
                val = 384;
                break;
            case 3:
                val = 576;
                break;
            case 4:
                val = 768;
                break;
            default:
                break;
        }
        return this.duration;
    }

    /**
     * La durée de la note pour la notation ABC
     * @return une chaine de caractères représentant la durée de la note
     */
    public String getDuration() {
        System.out.println("[Note getDuration:]");

        String str = "";

        switch (this.duration) {
            case 1/2:
                if (this.getValue() == -1)
                    str = "1/2";
                else
                    str = "/";
                break;
            case 1:
                if (this.getValue() == -1)
                    str = "1";
                else
                    str = "";
                break;
            case 2:
                str = "2";
                break;
            case 3:
                if (this.getValue() == -1)
                    str = "3";
                else
                    str = "";
                break;
            case 4:
                str = "4";
                break;
            default:
                break;
        }
        return str;
    }

    /**
     * La lettre associée à la valeur de la note
     * @return une lettre comprise dans A...G et z
     */
    public String getName() {
        System.out.println("[Note getName:]");

        int val = this.getValue();
        String name = "";
        switch (val) {
            case -1:
                name = "z";
                break;
            case 0:
            case 1:
                name = "C";
                break;
            case 2:
            case 3:
                name = "D";
                break;
            case 4:
                name = "E";
                break;
            case 5:
            case 6:
                name = "F";
                break;
            case 7:
            case 8:
                name = "G";
                break;
            case 9:
            case 10:
                name = "A";
                break;
            case 11:
                name = "B";
                break;
            default:
                break;
        }

        return name;
    }

    /**
     * Construit la note en notation ABC, avec sa lettre, sa durée, son accidental et son octave
     * @return
     */
    public String getNote() {
        System.out.println("[Note getNote:]");
        String name = this.getName();

        if (!name.equals("z"))
            name = this.octave.transform(name);
        return accidental + name + this.getDuration();
    }

    @Override
    public String toString() {
        System.out.println("[Note toString:]");
        return "Note " + this.getValue();
    }

    /**
     * Définie la valeur de la note
     * @param i sa nouvelle valeur
     */
    public void setValue(int i) {
        System.out.println("[Note setValue:" + i + "]");
        this.value = i;
    }

    /**
     * Retourne le nom de la note en français
     * @return la note
     */
    public String prettyName() {
        System.out.println("[Note prettyName:]");

        int val = this.getValue();
        String name = "";
        switch (val) {
            case -1:
                name = "Chut";
                return name;
            case 0:
            case 1:
                name = "Do";
                break;
            case 2:
            case 3:
                name = "Ré";
                break;
            case 4:
                name = "Mi";
                break;
            case 5:
            case 6:
                name = "Fa";
                break;
            case 7:
            case 8:
                name = "Sol";
                break;
            case 9:
            case 10:
                name = "La";
                break;
            case 11:
                name = "Si";
                break;
            default:
                break;
        }

        if (this.accidental.equals("^"))
            name = name + "#";

        return name;
    }
}
