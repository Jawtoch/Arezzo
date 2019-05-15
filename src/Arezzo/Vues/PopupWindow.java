package Arezzo.Vues;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PopupWindow implements EventHandler<ActionEvent> {

    private Parent parent;
    private String title;

    public PopupWindow(Parent parent, String title) {
        this.parent = parent;
        this.title = title;
    }

    @Override public void handle(ActionEvent event) {
        Scene scene = new Scene(this.parent, 100, 400);

        Stage stage = new Stage();
        stage.setTitle(this.title);
        stage.setScene(scene);

        stage.show();
    }
}