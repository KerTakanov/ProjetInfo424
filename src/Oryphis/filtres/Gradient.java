package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

/**
 * Gradient : permet un effet de relief qui permet de 
 * visualiser de faibles variations de luminosité.
 */
public class Gradient extends Filtre {

	/**
	 * filtre Gradient : permet un effet de relief qui permet de 
	 * visualiser de faibles variations de luminosité.
	 *
	 * @param      direction  Définit la direction dans laquelle appliquer le filtre
	 */
	public Gradient(int direction) {
		this.masque = new Masque();
		if(direction == 1)
			this.masque.masque = new int[][]
							   {{-1, -1, -1},{1, 1, 1},{0, 0, 0}};
							   //Matrice de convolution du filtre gradient allant du bas vers le haut
		else if(direction == 2)
			this.masque.masque = new int[][]
							   {{0, 1, -1},{0, 1, -1},{0, 1, -1}};
							   //Matrice de convolution du filtre gradient allant de gauche a droite
		else if(direction == 3)
			this.masque.masque = new int[][]
							   {{0, 0, 0},{1, 1, 1},{-1, -1, -1}};
							   //Matrice de convolution du filtre gradient allant de haut en bas
		else if(direction == 4)
			this.masque.masque = new int[][]
							   {{-1, 1, 0},{-1, 1, 0},{-1, 1, 0}};
							   //Matrice de convolution du filtre gradient allant de droite a gauche
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