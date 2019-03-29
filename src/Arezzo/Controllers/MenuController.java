package Arezzo.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class MenuController {

    public MenuController() {

    }

    @FXML void quitButtonAction() {
        Platform.exit();
    }

}
