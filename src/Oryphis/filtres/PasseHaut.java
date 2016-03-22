package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

public class PasseHaut extends Filtre{
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	
	//Filtre PasseHaut ( appeler aussi filtre d'accentuation)
	public PasseHaut() {
		this.masque = new Masque();
		this.masque.masque = new int[][]
							   
							   {{-1, -1, -1},
							    {-1, 20, -1},
							    {-1, -1, -1}};
							   
		this.masque.update_div();
	}
}