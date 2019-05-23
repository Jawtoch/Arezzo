package Arezzo;

import Arezzo.Controllers.*;
import Arezzo.Modele.*;
import Arezzo.Vues.PopupWindow;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        Partition partition = new Partition(synthesizer);

        //String[] notes = {"C", "^C", "D", "^D", "E", "F", "^F", "G", "^G", "A", "^A", "B"};
        Clavier clavier = new Clavier();

        for(int i = 0; i < 12; i++) {
            Note note = new Note(i);
            clavier.ajouterTouches(new Touche(note));
        }

        ListeNotes listeNotes = new ListeNotes();

        BorderPane root = new BorderPane();

        FXMLLoader partitionFxmlLoader = new FXMLLoader();
        partitionFxmlLoader.setLocation(getClass().getResource("Vues/VuePartition.fxml"));
        PartitionController partitionController = new PartitionController(partition);
        partitionFxmlLoader.setControllerFactory(ic -> {
            partitionController.setListeNote(listeNotes);
            return  partitionController;
        });
        root.setCenter(partitionFxmlLoader.load());

        FXMLLoader menuFxmlLoader = new FXMLLoader();
        menuFxmlLoader.setLocation(getClass().getResource("Vues/VueMenu.fxml"));
        menuFxmlLoader.setControllerFactory(ic -> new MenuController(clavier));
        root.setTop(menuFxmlLoader.load());

        BorderPane hBox = new BorderPane();


        FXMLLoader clavierFxmlLoader = new FXMLLoader();
        clavierFxmlLoader.setLocation(getClass().getResource("Vues/VueClavier.fxml"));
        clavierFxmlLoader.setControllerFactory(ic -> {
            ClavierController clavierController = new ClavierController(clavier);
            clavierController.setListeNotes(listeNotes);
            return clavierController;
        });

        hBox.setLeft(clavierFxmlLoader.load());

        VBox vBox = new VBox();
        vBox.setSpacing(10);

        Pitch pitch = new Pitch();
        listeNotes.setPitch(pitch);

        FXMLLoader pitchFxmlLoader = new FXMLLoader();
        pitchFxmlLoader.setLocation(getClass().getResource("Vues/VuePitch.fxml"));
        pitchFxmlLoader.setControllerFactory(ic -> new PitchController(pitch));
        vBox.getChildren().add(pitchFxmlLoader.load());

        Duration duration = new Duration();
        listeNotes.setDuration(duration);

        FXMLLoader durationFxmlLoader = new FXMLLoader();
        durationFxmlLoader.setLocation(getClass().getResource("Vues/VueDuration.fxml"));
        durationFxmlLoader.setControllerFactory(ic -> new DurationController(duration));
        vBox.getChildren().add(durationFxmlLoader.load());

        hBox.setCenter(vBox);

        FXMLLoader toolsFxmlLoader = new FXMLLoader();
        toolsFxmlLoader.setLocation(getClass().getResource("Vues/VueTools.fxml"));
        toolsFxmlLoader.setControllerFactory(ic -> new ToolsController(partitionController));
        hBox.setRight(toolsFxmlLoader.load());

        root.setBottom(hBox);

        FXMLLoader listeFxmlLoader = new FXMLLoader();
        listeFxmlLoader.setLocation(getClass().getResource("Vues/VueListeNotes.fxml"));
        listeFxmlLoader.setControllerFactory(ic -> new ListeNotesController(listeNotes));

        Button button = new Button("Les notes");
        button.setOnAction(new PopupWindow(listeFxmlLoader.load(), "ListeNotes"));
        root.setRight(button);

        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(root, 1000, 600));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
