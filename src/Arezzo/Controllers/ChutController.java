package Arezzo.Controllers;

import Arezzo.Modele.Chut;
import javafx.fxml.FXML;

public class ChutController extends ToucheController {

    /**
     * Crée une touche chut à l'écran
     * @param chut
     */
    public ChutController(Chut chut) {
        super(chut);
        System.out.println("[ChutController init:]");
    }

    @Override @FXML public void initialize() {
        System.out.println("[ChutController initialize:]");
        String name = "Chut";

        this.button.setText(name);
    }
}
