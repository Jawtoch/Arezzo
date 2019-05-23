package Arezzo.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import partition.Partition;

public class InstrumentsController {

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

    @FXML public void initialize() throws Exception {
        System.out.println("[InstrumentsController initialize:]");

        this.toggleGroup.selectedToggleProperty().addListener(event -> {
            RadioButton radioButton = (RadioButton) this.toggleGroup.getSelectedToggle();
            String instrument = radioButton.getText();

            this.partition.setInstrument(instrument);
        });
    }
}
