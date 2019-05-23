package Arezzo.Controllers;

import Arezzo.Modele.Pitch;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class PitchController implements Initializable {

    @FXML private RadioButton lowPitchButton;
    @FXML private RadioButton mediumPitchButton;
    @FXML private RadioButton highPitchButton;

    private ToggleGroup toggleGroup;
    private Pitch pitch;

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[PitchController initialize:" + location + " " + resources + "]");

        this.toggleGroup = new ToggleGroup();

        this.lowPitchButton.setText(Pitch.PitchType.AÏGUE.name());
        this.mediumPitchButton.setText(Pitch.PitchType.MEDIUM.name());
        this.highPitchButton.setText(Pitch.PitchType.GRAVE.name());

        toggleGroup.getToggles().addAll(this.lowPitchButton, this.mediumPitchButton, this.highPitchButton);
        this.mediumPitchButton.setSelected(true);

        toggleGroup.selectedToggleProperty().addListener(event -> {
            RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            String string = radioButton.getText();
            this.pitch.setCurrentPitch(Pitch.PitchType.valueOf(string));
        });
    }

    /**
     * Permet de modifier l'octave
     * @param pitch
     */
    public PitchController(Pitch pitch) {
        System.out.println("[PitchController init:]");
        this.pitch = pitch;
    }
}
