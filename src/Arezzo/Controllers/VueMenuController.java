package Arezzo.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class VueMenuController {

    @FXML
    MenuItem test;

    public VueMenuController() {

    }

    @FXML
    void quitButtonAction() {
        Platform.exit();
    }

}
