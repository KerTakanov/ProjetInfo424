package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;
import Oryphis.filtres.Masque;

public abstract class Filtre {
	protected Masque masque;
	/**
	 * permet d'appliquer le masque sur l'image d'origine.
	 *
	 * @param      img   { l'image d'origine }
	 *
	 * @return     { retourne l'image d'origine après modification par le masque }
	 */
	public abstract PPMImage appliquer(PPMImage img);

	protected PPMImage appliquer_masque(PPMImage img) {
		PPMImage img2 = new PPMImage(img);

		for(int y = 1; y < img.getWidth() - 1; y++) {
			for(int x = 1; x < img.getHeight() - 1; x++) {
				masque.appliquer(x, y, img, img2);
			}
		}

		return img2;
	}
}