package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Nettete extends Filtre {
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Nettete() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{-1, -1, -1},{-1, 9, -1},{-1, -1, -1}};
                               
        this.masque.diviseur = 1;
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}