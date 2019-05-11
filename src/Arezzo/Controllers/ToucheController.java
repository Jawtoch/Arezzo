package Arezzo.Controllers;

import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToucheController {

    private Touche touche;

    @FXML private Button button;

    @FXML public void initialize() throws Exception {
        System.out.println("[ToucheController initialize:]");
        this.button.setText(touche.getNote().getValue());
        if (this.touche.getNote().getValue().contains("^")) {
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
