package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.Observable;
import java.util.Observer;

public class ListeNotesController implements Observer {

    private ListeNotes listeNotes;

    @FXML private ListView<Note> listView;

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
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("[ListeNotesController update:" + o + " " + arg + "]");
        this.creerLaListe();
    }
}
