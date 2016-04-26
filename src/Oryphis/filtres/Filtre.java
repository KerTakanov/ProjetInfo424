package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;
import Oryphis.filtres.Masque;

public abstract class Filtre {
	protected Masque masque;

	/**
	 * Applique le Filtre à l'image
	 * 
	 * @param img L'image à qui on applique le filtre
	 * @return L'image à qui on a appliqué le filtre
	 */
	public abstract PPMImage appliquer(PPMImage img);

	/**
	 * Applique un masque à une image
	 *
	 * @param      img   L'image à qui on applique le masque
	 *
	 * @return     L'image à qui on a appliqué le masque
	 */
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