package Arezzo.Controllers;

import Arezzo.Modele.NoteFormatter;
import Arezzo.Modele.Touche;
import abc.notation.Note;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToucheController {

    private Touche touche;

    @FXML private Button button;

    @FXML public void initialize() throws Exception {
        System.out.println("[ToucheController initialize:]");

        Note note = this.touche.getNote();
        String name = NoteFormatter.format(note);

        this.button.setText(name);

        if (name.contains("^")) {
            this.button.setStyle("-fx-background-color: #000000");
            this.button.setPrefHeight(this.button.getPrefHeight() / 2);
        }
    }

    @FXML private void touchUpInsideAction() {
        System.out.println("[ToucheController touchUpInsideAction:]");
        this.touche.pressed();
    }

    ToucheController(Touche touche) {
        System.out.println("[ToucheController init:]");
        this.touche = touche;
    }
}
