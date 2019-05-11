package Arezzo.Controllers;

import Arezzo.Modele.Pitch;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PitchController {

    @FXML private RadioButton lowPitchButton;
    @FXML private RadioButton mediumPitchButton;
    @FXML private RadioButton highPitchButton;

    private ToggleGroup toggleGroup;
    private Pitch pitch;

    @FXML public void initialize() throws Exception {
        System.out.println("[PitchController initialize:]");

        this.toggleGroup = new ToggleGroup();

        this.lowPitchButton.setText("aïgue");
        this.mediumPitchButton.setText("medium");
        this.highPitchButton.setText("grave");

        toggleGroup.getToggles().addAll(this.lowPitchButton, this.mediumPitchButton, this.highPitchButton);
        this.mediumPitchButton.setSelected(true);

        toggleGroup.selectedToggleProperty().addListener(event -> {
            RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            this.pitch.setCurrentPitch(radioButton.getText());
        });
    }

    public PitchController(Pitch pitch) {
        System.out.println("[PitchController init:]");
        this.pitch = pitch;
    }
}
