package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

/**
 * Estampage :  Il permet de simuler un effet d'aplatissement en 
 * supprimant les détails et en rajoutant du relief dans les contours.
 */
public class Estampage extends Filtre {
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Estampage() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{-2, 0, 0},{0, 1, 0},{0, 0, 2}};
                               
        this.masque.diviseur = 1;
    }
    
    /**
     * Applique le filtre à une image
     *
     * @param      img   image à modifier
     *
     * @return     L'image à qui on a appliqué le filtre
     */
    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}