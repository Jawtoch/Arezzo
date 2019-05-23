package Arezzo.Controllers;

import Arezzo.Modele.Clavier;
import javafx.application.Platform;
import javafx.fxml.FXML;

public class MenuController {

    public MenuController(Clavier clavier) {
        System.out.println("[MenuController init:" + clavier + "]");
    }

    @FXML void quitButtonAction() {
        System.out.println("[MenuController quitButtonAction:]");
        Platform.exit();
    }

}
