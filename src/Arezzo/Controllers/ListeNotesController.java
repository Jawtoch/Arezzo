package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.NoteFormatter;
import abc.notation.Note;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.util.Callback;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

public class ListeNotesController implements Observer, Initializable {

    private ListeNotes listeNotes;

    @FXML private ListView<abc.notation.Note> listView;

    @FXML public void initialize() throws Exception {
        System.out.println("[ListeNotesController initialize:]");
        this.creerLaListe();

    }

    public ListeNotesController(ListeNotes listeNotes) {
        System.out.println("[ListeNotesController init:" + listeNotes + "]");
        this.listeNotes = listeNotes;
        this.listeNotes.addObserver(this);
    }

    private void creerLaListe() {
        System.out.println("[ListeNotesController creerLaListe:]");
        this.listView.setItems(this.listeNotes.getList());
        this.listView.setCellFactory(new Callback<ListView<abc.notation.Note>, ListCell<abc.notation.Note>>() {
            @Override
            public ListCell<abc.notation.Note> call(ListView<abc.notation.Note> param) {
                ListCell<abc.notation.Note> listCell = new ListCell<Note>() {
                    @Override
                    protected void updateItem(Note item, boolean empty) {
                        super.updateItem(item, empty);

                        if (empty || item == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(NoteFormatter.format(item));
                        }
                    }
                };

                ContextMenu contextMenu = new ContextMenu();
                MenuItem deleteMenu = new MenuItem("Effacer");
                deleteMenu.setOnAction(event -> {
                    listeNotes.supprimer(listCell.getIndex());
                });

                MenuItem toneUp = new MenuItem("Monter d'un 1/2 ton");
                toneUp.setOnAction(event -> {
                    int index = listCell.getIndex();
                    Note note = listeNotes.get(index);
                    Note transposedNote = Note.transpose(note, 1);
                    listeNotes.set(index, transposedNote);
                });

                MenuItem toneDown = new MenuItem("Descendre d'un 1/2 ton");
                toneDown.setOnAction(event -> {
                    int index = listCell.getIndex();
                    Note note = listeNotes.get(index);
                    Note transposedNote = Note.transpose(note, -1);
                    listeNotes.set(index, transposedNote);
                });

                contextMenu.getItems().addAll(deleteMenu, toneUp, toneDown);

                listCell.setContextMenu(contextMenu);

                return listCell;
            }
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
