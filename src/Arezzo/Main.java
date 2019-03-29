package Arezzo;

import Arezzo.Controllers.ListeNotesController;
import Arezzo.Controllers.MenuController;
import Arezzo.Controllers.NoteController;
import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
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
        menuFxmlLoader.setControllerFactory(ic->new MenuController());
        root.setTop(menuFxmlLoader.load());

        String[] notes = {"C,", "D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B", "c", "d", "e", "f", "g", "a"};
        ListeNotes listeNotes = new ListeNotes();
        for (String value: notes) {
            listeNotes.ajouter(new Note(value));
        }

        FXMLLoader listeNotesFxmlLoader = new FXMLLoader();
        listeNotesFxmlLoader.setLocation(getClass().getResource("Vues/VueListeNotes.fxml"));
        listeNotesFxmlLoader.setControllerFactory(ic->new ListeNotesController(listeNotes));

        root.setCenter(listeNotesFxmlLoader.load());

        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
