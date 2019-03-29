package Arezzo.Controllers;

import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToucheController {

    private Touche touche;
    private NoteController noteController;

    @FXML private Button button;

    @FXML public void initialize() throws Exception {
        this.button.setText(touche.getNote().getValue());
        if (this.touche.getNote().getValue().contains("^")) {
            this.button.setStyle("-fx-background-color: #000000");
            this.button.setPrefHeight(this.button.getPrefHeight() / 2);
        }
    }

    @FXML private void touchUpInsideAction() {
        this.noteController.play();
    }

    public ToucheController(Touche touche) {
        this.touche = touche;
        this.noteController = new NoteController(this.touche.getNote());
    }
}
