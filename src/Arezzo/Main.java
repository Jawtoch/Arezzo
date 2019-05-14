package Arezzo;

import Arezzo.Controllers.*;
import Arezzo.Modele.*;
import abc.notation.Note;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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

        abc.notation.Note note = new abc.notation.Note((byte)0);

        //for (String value: notes) {
        //    clavier.ajouterTouches(new Touche(new Note(value)));
        //}

        for(int i = 0; i < 12; i++) {
            Note n = Note.transpose(note, i);
            clavier.ajouterTouches(new Touche(n));
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

        HBox hBox = new HBox();

        FXMLLoader clavierFxmlLoader = new FXMLLoader();
        clavierFxmlLoader.setLocation(getClass().getResource("Vues/VueClavier.fxml"));
        clavierFxmlLoader.setControllerFactory(ic -> {
            ClavierController clavierController = new ClavierController(clavier);
            clavierController.setListeNotes(listeNotes);
            return clavierController;
        });

        hBox.getChildren().add(clavierFxmlLoader.load());

        VBox vBox = new VBox();

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

        hBox.getChildren().add(vBox);

        root.setBottom(hBox);

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
