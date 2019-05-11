package Arezzo;

import Arezzo.Controllers.*;
import Arezzo.Modele.Clavier;
import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import Arezzo.Modele.Touche;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import partition.Partition;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        Partition partition = new Partition(synthesizer);

        String[] notes = {"C", "^C", "D", "^D", "E", "F", "^F", "G", "^G", "A", "^A", "B"};
        Clavier clavier = new Clavier();

        for (String value: notes) {
            clavier.ajouterTouches(new Touche(new Note(value)));
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


        FXMLLoader clavierFxmlLoader = new FXMLLoader();
        clavierFxmlLoader.setLocation(getClass().getResource("Vues/VueClavier.fxml"));
        clavierFxmlLoader.setControllerFactory(ic -> {
            ClavierController clavierController = new ClavierController(clavier);
            clavierController.setListeNotes(listeNotes);
            return clavierController;
        });
        root.setBottom(clavierFxmlLoader.load());

        //FXMLLoader pitchFxmlLoader = new FXMLLoader();
        //pitchFxmlLoader.setLocation(getClass().getResource("Vues/VuePitch.fxml"));
        //pitchFxmlLoader.setControllerFactory(ic -> new PitchController());
        //root.setRight(pitchFxmlLoader.load());

        FXMLLoader listeFxmlLoader = new FXMLLoader();
        listeFxmlLoader.setLocation(getClass().getResource("Vues/VueListeNotes.fxml"));

        listeFxmlLoader.setControllerFactory(ic -> new ListeNotesController(listeNotes));
        root.setRight(listeFxmlLoader.load());

        primaryStage.setTitle("Arezzo");
        primaryStage.setScene(new Scene(root, 800, 300));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
