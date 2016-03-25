package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Laplacien extends Filtre {
	/**
	 * filtre laplacien : permet de rendre visible les contours des objets.
	 */
	public Laplacien() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{0, -1, 0},{-1, 4, -1},{0, -1, 0}};
							   //matrice de convolution du filtre Laplacien.
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