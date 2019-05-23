package Arezzo.Modele;

public class Chut extends Touche {

    /**
     * Crée une touche 'silence', contenant une note 'z'
     */
    public Chut() {
        super(new Note(-1));
        System.out.println("[Chut init:]");
    }
}
