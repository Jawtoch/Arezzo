package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import Arezzo.Modele.OctaveError;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ListeNotesController implements Observer, Initializable {

    private ListeNotes listeNotes;

    @FXML private ListView<Note> listView;

    /**
     * Affiche la liste des notes
     * @param listeNotes la liste à afficher
     */
    public ListeNotesController(ListeNotes listeNotes) {
        System.out.println("[ListeNotesController init:" + listeNotes + "]");
        this.listeNotes = listeNotes;
        this.listeNotes.addObserver(this);
    }

    /**
     * Actualise la liste
     */
    private void creerLaListe() {
        System.out.println("[ListeNotesController creerLaListe:]");
        this.listView.setItems(this.listeNotes.getList());
        this.listView.setCellFactory(ic -> {
            NoteCell noteCell = new NoteCell(this.listeNotes);

            ContextMenu contextMenu = new ContextMenu();
            MenuItem deleteMenu = new MenuItem("Effacer");
            deleteMenu.setOnAction(event -> {
                this.listeNotes.supprimer(noteCell.getIndex());
            });

            MenuItem toneUp = new MenuItem("Monter d'un 1/2 ton");
            toneUp.setOnAction(event -> {
                int index = noteCell.getIndex();
                try {
                    this.listeNotes.transpose(index, 1);
                } catch (OctaveError e) {
                    e.printStackTrace();
                }
            });

            MenuItem toneDown = new MenuItem("Descendre d'un 1/2 ton");
            toneDown.setOnAction(event -> {
                int index = noteCell.getIndex();
                try {
                    this.listeNotes.transpose(index, -1);
                } catch (OctaveError e) {
                    e.printStackTrace();
                }
            });

            contextMenu.getItems().addAll(deleteMenu, toneUp, toneDown);

            noteCell.setContextMenu(contextMenu);

            return noteCell;
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("[ListeNotesController update:" + o + " " + arg + "]");
        this.creerLaListe();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("[ListeNotesController initialize:" + location + " " + resources + "]");
        this.creerLaListe();
    }
}
