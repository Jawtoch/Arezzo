package Arezzo.Modele;

import abc.notation.Note;

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

        return output;
    }
}
