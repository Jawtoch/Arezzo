package Arezzo.Modele;

class Octave {

    int oct;

    /**
     * Instancie une octave
     * @param value l'octave
     */
    Octave(int value) {
        this.oct = value;
    }

    /**
     * Augmente de 1 l'octave
     * @throws OctaveError si l'octave ne peut augmenter
     */
    void augmenter() throws OctaveError {
        if (this.oct == 1) {
            throw new OctaveError("Impossible de monter plus haut");
        }
        this.oct += 1;
    }

    /**
     * Descend de 1 l'octave
     * @throws OctaveError si l'octave ne peut descendre
     */
    void descendre() throws OctaveError {
        if (this.oct == -1) {
            throw new OctaveError("Impossible de descendre plus bas");
        }
        this.oct -= 1;
    }

    /**
     * Modifie la valeur de l'octave
     * @param value la nouvelle valeur de l'octave
     */
    void set(int value) {
        if ((value >= -1) || (value <= 1)) {
            this.oct = value;
        } else {
            this.oct = 0;
        }
    }

    /**
     * Transforme une note en fonction de l'octave
     * @param note la note a modifier
     * @return la note modifée
     */
    String transform(String note) {

        String newNote = note;

        switch (this.oct) {
            case -1:
                newNote = note.toUpperCase() + ",";
                break;
            case 0:
                newNote = note.toUpperCase();
                break;
            case 1:
                newNote = note.toLowerCase();
                break;
            default:
                return note;
        }

        return newNote;
    }
}

