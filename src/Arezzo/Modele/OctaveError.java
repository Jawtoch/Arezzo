package Arezzo.Modele;

public class OctaveError extends Error {

    /**
     * Erreur lors d'un appel d'une méthode sur une octave
     * @param m le message d'erreur
     */
    OctaveError(String m) {
        super(m);
    }

}
