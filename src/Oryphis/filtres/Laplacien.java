package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;

public class Laplacien extends Filtre {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	static public PPMImage laplacien(PPMImage img) {
		int[][] masque = new int[][]
		{{0, 1, 0}, 
		 {0, 1, 0}, 
		 {1, -4, 1}, 
		 {0, 1, 0}
		};

		return appliquer_masque(img, masque);
	}
}