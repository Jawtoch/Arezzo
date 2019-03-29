package Arezzo.Controllers;

import Arezzo.Modele.Clavier;
import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;

public class ClavierController {

    private Clavier clavier;

    @FXML private HBox hBox;

    @FXML public void initialize() throws Exception {
        for(Touche touche: this.clavier) {
            FXMLLoader toucheFxmlLoader = new FXMLLoader();
            toucheFxmlLoader.setLocation(getClass().getResource("../Vues/VueTouche.fxml"));
            toucheFxmlLoader.setControllerFactory(ic -> new ToucheController(touche));
            this.hBox.getChildren().add(toucheFxmlLoader.load());
        }
    }

    public ClavierController(Clavier clavier) {
        this.clavier = clavier;
    }
}
