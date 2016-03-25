package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Laplacien extends Filtre {
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Laplacien() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{0, -1, 0},{-1, 4, -1},{0, -1, 0}};
                               
        this.masque.diviseur = 1;
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}