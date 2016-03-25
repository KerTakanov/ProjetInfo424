package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

public class PasseBas extends Filtre{
    //TODO: Compléter les arguments
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    
    //Filtre PasseHaut ( appeler aussi filtre d'accentuation)
    public PasseBas() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{1, 1, 1},
                                {1, 4, 1},
                                {1, 1, 1}};
                               
        this.masque.diviseur = 1;
    }

    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}