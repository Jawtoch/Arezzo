package Arezzo.Modele;

public interface ToucheDelegate {

    /**
     * Signale au délégué qu'une note a été touchée
     * @param note la note touchée
     */
    void touchUpInside(Note note);
}
