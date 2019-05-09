package Arezzo.Controllers;

import Arezzo.Modele.Clavier;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ToggleGroup;

import javax.sound.midi.*;

public class MenuController {

    @FXML private Menu devices;

    public MenuController(Clavier clavier) {
    }

    @FXML public void initialize() throws Exception {
        ToggleGroup toggleGroup = new ToggleGroup();

        for(MidiDevice.Info info: MidiSystem.getMidiDeviceInfo()) {
            RadioMenuItem menuItem = new RadioMenuItem(info.getName());
            toggleGroup.getToggles().add(menuItem);
            this.devices.getItems().add(menuItem);
        }

    }

    @FXML void quitButtonAction() {
        Platform.exit();
    }

}
