package Arezzo.Modele;

import abc.notation.Note;

import static Arezzo.Modele.Duration.*;

public class NoteFormatter {

    public static String format(Note note) {
        System.out.println("[NoteFormatter format:" + note + "]");

        String output = note.toString();

        // Blanche
        if (output.contains("=")) {
            output = output.replace("=", "");
        }

        // Noire
        if(output.contains("#")) {
            output = output.replace("#", "");
            output = "^" + output;
        }

        // Aigue
        if (output.contains("'")) {
            output = output.replace("'", "");
            output = output.toLowerCase();
        }

        short duration = note.getDuration();
        switch (duration) {
            case CROCHE:
                output = output + "/";
                break;
            case NOIRE:
                break;
            case BLANCHE:
                output = output + "2";
                break;
            case RONDE:
                output = output + "4";
                break;
        }

        return output;
    }
}
