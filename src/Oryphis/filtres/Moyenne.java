package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Moyenne extends Filtre{
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Moyenne() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
                               
        this.masque.update_div();
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}