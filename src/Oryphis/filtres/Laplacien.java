package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

/**
 * filtre laplacien : permet de rendre visible les contours des objets.
 */
public class Laplacien extends Filtre {
	public Laplacien() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{0, -1, 0},{-1, 4, -1},{0, -1, 0}};
							   //matrice de convolution du filtre Laplacien.
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