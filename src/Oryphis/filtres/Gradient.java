package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Gradient extends Filtre {
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Gradient(int direction) {
        this.masque = new Masque();
        if(direction == 1)
            this.masque.masque = new int[][]
                               {{-1, -1, -1},{1, 1, 1},{0, 0, 0}};
        else if(direction == 2)
            this.masque.masque = new int[][]
                               {{0, 1, -1},{0, 1, -1},{0, 1, -1}};
        else if(direction == 3)
            this.masque.masque = new int[][]
                               {{0, 0, 0},{1, 1, 1},{-1, -1, -1}};
        else if(direction == 4)
            this.masque.masque = new int[][]
                               {{-1, 1, 0},{-1, 1, 0},{-1, 1, 0}};
                               
        this.masque.diviseur = 1;
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}