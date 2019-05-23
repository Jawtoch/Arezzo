package Arezzo.Controllers;

import Arezzo.Modele.ListeNotes;
import Arezzo.Modele.Note;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

public class NoteCell extends ListCell<Arezzo.Modele.Note> {

    private NoteCellController noteCellController;
    private Node view;

    /**
     * Une cellule de la liste de notes
     * @param listeNotes la liste de notes
     */
    NoteCell(ListeNotes listeNotes) {
        this.noteCellController = new NoteCellController(listeNotes);
        this.view = this.noteCellController.getView();
    }

    @Override
    protected void updateItem(Note item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {
            this.noteCellController.setNote(item);
            this.setGraphic(this.view);
        }
    }
}
