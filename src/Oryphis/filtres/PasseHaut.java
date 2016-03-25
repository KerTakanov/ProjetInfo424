package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

public class PasseHaut extends Filtre{
	/**
	 * Filtre PasseHaut : appeler aussi filtre d'accentuation.
	 * Ces effets sont : augmentation du bruit, effet couronne, effet de bord.
	 */
	public PasseHaut() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{0, -1, 0},
							    {-1, 5, -1},
							    {0, -1, 0}};
							    //matrice de convolution du filtre PasseHaut.
							   
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