package Arezzo.Controllers;

import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToucheController {

    private Touche touche;

    @FXML private Button button;

    @FXML public void initialize() throws Exception {
        this.button.setText(touche.getNote().getValue());
    }

    public ToucheController(Touche touche) {
        this.touche = touche;
    }
}
