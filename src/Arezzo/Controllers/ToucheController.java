package Arezzo.Controllers;

import Arezzo.Modele.Touche;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ToucheController {

    protected Touche touche;

    @FXML protected Button button;

    @FXML public void initialize() throws Exception {
        System.out.println("[ToucheController initialize:]");
    }

    /**
     * Méthode appelée par le bouton en cas de clic. Notifie la touche du clic
     */
    @FXML protected void touchUpInsideAction() {
        System.out.println("[ToucheController touchUpInsideAction:]");
        this.touche.pressed();
    }

    /**
     * Controlleur de touche, permettant de signaler à la touche un appui en cas de clic que le bouton
     * @param touche une touche
     */
    ToucheController(Touche touche) {
        System.out.println("[ToucheController init:]");
        this.touche = touche;

    }
}
