package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;
import Oryphis.filtres.Masque;

public abstract class Filtre {
	private Masque masque;
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	static public PPMImage appliquer_masque(PPMImage img) {
		PPMImage img2 = new PPMImage(img);

		for(int x = 1; x < img.getWidth() - 1; x++) {
			for(int y = 1; y < img.getHeight() - 1; y++) {
				masque.appliquer(x, y, img, img2);
			}
		}

		return img2;
	}
}