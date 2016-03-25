package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

public class PasseHaut extends Filtre{
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    
    //Filtre PasseHaut ( appeler aussi filtre d'accentuation)
    public PasseHaut() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{0, -1, 0},
                                {-1, 5, -1},
                                {0, -1, 0}};
                               
        this.masque.diviseur = 1;
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}