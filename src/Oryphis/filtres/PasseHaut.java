package Oryphis.filtres;

import Oryphis.PPMImage;

class PasseHaut {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	public PasseHaut(PPMImage img) {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{0, -1, 0},
							    {-1, 5, -1},
							    {0, -1, 0}};
							   
		this.masque.update_div();
	}
}