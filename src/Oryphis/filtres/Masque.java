package Oryphis.filtres;

import Oryphis.PPImage;
/**
 * Permet de gérer un masque qui sera appliqué par un filtre.
 */
public class Masque {
	int[][] masque;
	int diviseur;

	/**
	 * Permet de créer un nouveau masque de dimension (w, h)
	 *
	 * @param      w     nombre de lignes du masque
	 * @param      h     nombre de colonnes du masque
	 */
	public Masque(int w, int h) {
		this.masque = new int[w][h];
	}

	/**
	 * Applique le masque sur un pixel.
	 * L'image en entrée n'est pas modifiée.
	 *
	 * @param      x     la position x du pixel
	 * @param      y     la position y du pixel
	 * @param      img   l'image depuis laquelle on applique le masque
	 *
	 * @return     le pixel à qui on a appliqué le filtre
	 */
	public Pixel appliquer(int x, int y, PPMImage imgori, PPMImage imgdest) {
		int totr = 0;
		int totg = 0;
		int totb = 0;
		if(x > 1 && y > 1 &&
		   x < img.getWidth() && y < img.getHeight()) {
			for(int ix = -1; ix <= 1; ++ix) {
				for(int iy = -1; iy <= 1; ++iy) {
					tot += img.r(x + ix, y + iy);
				}
			}
		}
	}

	//Getters
	/**
	 * Retourne le masque.
	 *
	 * @return     le masque
	 */
	public int[][] getMasque() {
		return this.masque;
	}

	//Setters
	/**
	 * Modifie une valeur du masque à la position (x, y) selon la valeur val.
	 *
	 * @param      x     l'abscisse
	 * @param      y     l'ordonnée
	 * @param      val   la valeur
	 */
	public void set(int x, int y, int val) {
		masque[x][y] = val;
		update_div();
	}

	/**
	 * Modifie une ligne entière du masque à la position x
	 * selon les valeurs vals.
	 *
	 * @param      x     la ligne à modifier
	 * @param      vals  les valeurs
	 */
	public void set(int x, int[] vals) {
		masque[x] = vals;
		update_div();
	}

	private void update_div() {
		diviseur = 0;
		for(int x = 0; i < masque.length; ++i) {
			for(int y = 0; y < masque[x].length; ++y) {
				diviseur += masque[x][y];
			}
		}
	}
}