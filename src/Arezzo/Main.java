package Arezzo;

import Arezzo.Controllers.VueMenuController;
import Arezzo.Controllers.VueNoteController;
import Arezzo.Modele.Note;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        BorderPane root = new BorderPane();

        //FXMLLoader menuFxmlLoader = new FXMLLoader();
//
        //menuFxmlLoader.setLocation(getClass().getResource("Vues/VueMenu.fxml"));
        //menuFxmlLoader.setControllerFactory(ic->new VueMenuController());
//
        //root.setTop(menuFxmlLoader.load());

        Note note = new Note(10);

        FXMLLoader noteFxmlLoader = new FXMLLoader();

        noteFxmlLoader.setLocation(getClass().getResource("Vues/VueNote.fxml"));
        noteFxmlLoader.setControllerFactory(ic->new VueNoteController(note));

        root.setCenter(noteFxmlLoader.load());

        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
