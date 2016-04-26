package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

/**
 * filtre nettete : est un filtre Passe Haut mais utilise une plus grande matrice
 * de convolution.
 */
public class Nettete extends Filtre {
	public Nettete() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{-1, -1, -1},{-1, 9, -1},{-1, -1, -1}};
								//matrice de convolution du filtre nettete.		   
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