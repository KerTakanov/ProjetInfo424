package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;
import Oryphis.filtres.Masque;

public class Laplacien extends Filtre {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	public Laplacien() {
		this.masque = new Masque();
		this.masque.masque = new int[][] 
							  {{1,1,1},
							  {1,1,1},
							  {1,1,1}};
		this.masque.update_div();
	}
}