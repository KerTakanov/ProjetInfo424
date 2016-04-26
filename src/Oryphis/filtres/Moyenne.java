package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

/**
 * filtre moyenne : remplace chaque pixel par la moyenne des valeurs
 * des pixels adjacents et du pixel central.
 */
public class Moyenne extends Filtre{
	public Moyenne() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
							   //matrice de convolution du filtre moyenne.
		this.masque.update_div();
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