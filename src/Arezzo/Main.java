package Arezzo;

import Arezzo.Controllers.ClavierController;
import Arezzo.Controllers.ListeNotesController;
import Arezzo.Controllers.MenuController;
import Arezzo.Controllers.NoteController;
import Arezzo.Modele.Clavier;
import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import Arezzo.Modele.Touche;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();

        FXMLLoader menuFxmlLoader = new FXMLLoader();
        menuFxmlLoader.setLocation(getClass().getResource("Vues/VueMenu.fxml"));
        menuFxmlLoader.setControllerFactory(ic -> new MenuController());
        root.setTop(menuFxmlLoader.load());

        String[] notes = {"C,", "D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B", "c", "d", "e", "f", "g", "a"};
        Clavier clavier = new Clavier();

        for (String value: notes) {
            clavier.ajouterTouches(new Touche(new Note(value)));
        }

        FXMLLoader clavierFxmlLoader = new FXMLLoader();
        clavierFxmlLoader.setLocation(getClass().getResource("Vues/VueClavier.fxml"));
        clavierFxmlLoader.setControllerFactory(ic -> new ClavierController(clavier));

        root.setCenter(clavierFxmlLoader.load());

        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
