package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import partition.Partition;

import java.net.URL;
import java.util.ResourceBundle;

public class InstrumentsController implements Initializable {

    @FXML private ToggleGroup toggleGroup;
    private Partition partition;

    /**
     * Controle la sélection de l'instrument
     * @param partition une partition
     */
    public InstrumentsController(Partition partition) {
        System.out.println("[InstrumentsController init:]");
        this.partition = partition;
    }

    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[InstrumentsController initialize:" + location + " " + resources + "]");

        this.toggleGroup.selectedToggleProperty().addListener(event -> {
            RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            String instrument = radioButton.getText();

            this.partition.setInstrument(instrument);
        });
    }
}
