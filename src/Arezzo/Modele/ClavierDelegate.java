package Arezzo.Modele;

public interface ClavierDelegate {

    /**
     * Signale au délégué qu'une note a été envoyée par le clavier
     * @param note la note envoyée
     */
    void ajouterNote(Note note);

}
