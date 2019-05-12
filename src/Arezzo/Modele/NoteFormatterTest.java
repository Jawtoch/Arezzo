package Arezzo.Modele;

import abc.notation.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteFormatterTest {

    @Test
    void format() {

        Note note = new Note((byte) 0);
        for(int i = 0; i < 12; i++) {
            Note n = Note.transpose(note, i);
            System.out.print(n.toString());
            System.out.println(" -> " + NoteFormatter.format(n));
        }
    }
}