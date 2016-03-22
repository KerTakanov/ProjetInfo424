package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.DrawImage;
import Oryphis.Pixel;

class Moyenne {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	public Moyenne(PPMImage img) {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{1, 1, 1},{1, 1, 1},{1, 1, 1}};
							   
		this.masque.update_div();
	}
}