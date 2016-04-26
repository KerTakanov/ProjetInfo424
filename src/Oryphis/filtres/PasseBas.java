package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

/**
 * filtre PasseBas : est l'opposé du filtre passe haut.
 * Il permet de réduire le bruit granuleux d'un fond sans perte de détails.
 */
public class PasseBas extends Filtre{
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