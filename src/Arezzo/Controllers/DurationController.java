package Arezzo.Controllers;

import Arezzo.Modele.Duration;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class DurationController implements Initializable {

    @FXML private RadioButton crocheButton;
    @FXML private RadioButton noireButton;
    @FXML private RadioButton blancheButton;
    @FXML private RadioButton rondeButton;

    private ToggleGroup toggleGroup;
    private Duration duration;

    /**
     * Définie la durée actelle
     * @param duration un object duration
     */
    public DurationController(Duration duration) {
        System.out.println("[DurationController init:" + duration + "]");
        this.duration = duration;
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[DurationController initialize:" + location + " " + resources + "]");
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

        for(Toggle toggle: this.toggleGroup.getToggles()) {
            RadioButton radioButton = (RadioButton) toggle;
            ImageView imageView = (ImageView) radioButton.getGraphic();
            String name = radioButton.getText().toLowerCase() + ".png";
            imageView.setImage(new Image(getClass().getResourceAsStream("../ressources/images/" + name)));
        }


    }
}
