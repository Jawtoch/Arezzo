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
    }

    @FXML private void touchUpInsideAction() {
        this.noteController.play();
    }

    public ToucheController(Touche touche) {
        this.touche = touche;
        this.noteController = new NoteController(this.touche.getNote());
    }
}
