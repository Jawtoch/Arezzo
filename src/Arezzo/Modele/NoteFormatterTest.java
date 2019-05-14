package Arezzo.Modele;

import abc.notation.Note;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteFormatterTest {

    @Test
    void format() {

        Note note = new Note((byte) 0);
        note.setStrictDuration(Duration.RONDE);

        System.out.println(NoteFormatter.format(note));

    }
}