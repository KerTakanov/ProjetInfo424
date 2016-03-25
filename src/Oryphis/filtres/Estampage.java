package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Estampage extends Filtre {
	/**
	 * filtre Estampage :  Il permet de simuler un effet d'aplatissement en 
	 * supprimant les détails et en rajoutant du relief dans les contours.
	 */

    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Estampage() {
        this.masque = new Masque();
        this.masque.masque = new int[][]
                               
                               {{-2, 0, 0},{0, 1, 0},{0, 0, 2}};
                               
        this.masque.diviseur = 1;
    }
    /**
     * applique le filtre à une image
     *
     * @param      img   { image à modifier }
     *
     * @return     { applique le filtre }
     */
    public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}