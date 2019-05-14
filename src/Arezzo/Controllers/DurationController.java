package Arezzo.Controllers;

import Arezzo.Modele.Duration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class DurationController {

    @FXML private RadioButton crocheButton;
    @FXML private RadioButton noireButton;
    @FXML private RadioButton blancheButton;
    @FXML private RadioButton rondeButton;

    private ToggleGroup toggleGroup;
    private Duration duration;

    public DurationController(Duration duration) {
        System.out.println("[DurationController init:" + duration + "]");
        this.duration = duration;
    }

    @FXML public void initialize() throws Exception {
        System.out.println("[DurationController initialize:]");
        this.toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(
                this.crocheButton,
                this.noireButton,
                this.blancheButton,
                this.rondeButton
        );

        this.noireButton.setSelected(true);

        this.toggleGroup.selectedToggleProperty().addListener(event -> {
            RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            String string = radioButton.getText();
            this.duration.setCurrentDuration(Duration.DurationType.valueOf(string));
        });
    }
}
