package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.util.Observable;

public class PitchController extends Observable {

    @FXML private RadioButton lowPitchButton;
    @FXML private RadioButton mediumPitchButton;
    @FXML private RadioButton highPitchButton;

    private ToggleGroup toggleGroup;

    @FXML public void initialize() throws Exception {

        this.toggleGroup = new ToggleGroup();

        this.lowPitchButton.setText("aigu");
        this.mediumPitchButton.setText("medium");
        this.highPitchButton.setText("grave");

        toggleGroup.getToggles().addAll(this.lowPitchButton, this.mediumPitchButton, this.highPitchButton);
        this.mediumPitchButton.setSelected(true);

        toggleGroup.selectedToggleProperty().addListener(event -> {
            setChanged();
            notifyObservers();
        });
    }

    public PitchController() {

    }

    public String getType() {
        RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
        return radioButton.getText();
    }

}
