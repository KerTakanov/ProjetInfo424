package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

public class Estampage extends Filtre {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	public Estampage() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{-2, 0, 0},{0, 1, 0},{0, 0, 2}};
							   
		this.masque.diviseur = 1;
	}
}