package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

public class PasseBas extends Filtre{
	/**
	 * filtre passeBas : est l'opposé du filtre passe haut.
	 * Il permet de réduire le bruit granuleux d'un fond sans perte de détails.
	 */
	public PasseBas() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{1, 1, 1},
							    {1, 4, 1},
							    {1, 1, 1}};
							   //matrice de convolution du filtre PasseBas.
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