package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Nettete extends Filtre {
	/**
	 * filtre nettete : est un filtre Passe Haut mais utilise une plus grande matrice
	 * de convolution.
	 */
	public Nettete() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{-1, -1, -1},{-1, 9, -1},{-1, -1, -1}};
								//matrice de convolution du filtre nettete.		   
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