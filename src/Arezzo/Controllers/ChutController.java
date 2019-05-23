package Arezzo.Controllers;

import Arezzo.Modele.Chut;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

public class ChutController extends ToucheController implements Initializable {

    /**
     * Crée une touche chut à l'écran
     * @param chut
     */
    public ChutController(Chut chut) {
        super(chut);
        System.out.println("[ChutController init:]");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[ChutControler initialize:" + location + " " + resources + "]");
        String name = "Chut";
        this.button.setText(name);
    }
}
