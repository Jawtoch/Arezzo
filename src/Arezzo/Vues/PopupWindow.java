package Arezzo.Vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopupWindow implements EventHandler<ActionEvent> {

    private Parent parent;
    private String title;

    /**
     * Crée une nouvelle fenêtre
     * @param parent le parent à afficher dans la fenêtre
     * @param title le titre de la fenêtre
     */
    public PopupWindow(Parent parent, String title) {
        System.out.println("[PopupWindow init:" + parent + " " + title + "]");
        this.parent = parent;
        this.title = title;
    }

    @Override public void handle(ActionEvent event) {
        System.out.println("[PopupWindow handle:" + event + "]");
        Scene scene = new Scene(this.parent, 130, 400);

        Stage stage = new Stage();
        stage.setTitle(this.title);
        stage.setScene(scene);

        stage.show();
    }
}