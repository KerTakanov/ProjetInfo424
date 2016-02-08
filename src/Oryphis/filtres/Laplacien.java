package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;

public class Laplacien {
	//TODO: Compléter les arguments
	//doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
	public Laplacien(PPMImage img) {
		Pixel px;
		PPMImage img2 = new PPMImage(
			img.getWidth(), 
			img.getHeight(), 
			img.getFormat());

		int[][] masque = new int[][]
		{{0, 1, 0}, 
		 {0, 1, 0}, 
		 {1, -4, 1}, 
		 {0, 1, 0}
		};
		for(int y = 1; y < img.getHeight() - 1; y++) {
			for(int x = 1; x < img.getWidth() - 1; x++) {
				 for(int y1 = -1; y1 < 1; y1++) {
				 	for(int x1 = -1; x1 < 1; x1++) {
				 		px = new Pixel(
				 			img.r(x1 + x, y1 + y),
				 			img.g(x1 + x, y1 + y),
				 			img.b(x1 + x, y1 + y));
				 		px.multiply(masque[x1+1][y1+1]);

				 		img2.setPixel(x1 + x, y1 + y, px);
				 	}
				 }
			}
		}
	}
}