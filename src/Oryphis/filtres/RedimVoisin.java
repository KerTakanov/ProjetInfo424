package Oryphis.filtres;

import Oryphis.Pixel;
import Oryphis.PPMImage;

/**
 * Redimensionne une image par la technique du voisin de gauche.
 */
public class RedimVoisin extends Filtre {
	private double wcoeff;
	private double hcoeff;

	public RedimVoisin(double wcoeff, double hcoeff) {
		this.wcoeff = wcoeff;
		this.hcoeff = hcoeff;
	}

	/**
     * Applique le filtre à une image
     *
     * @param      img   image à modifier
     *
     * @return     L'image à qui on a appliqué le filtre
     */
	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage((int)(img.getWidth()*wcoeff), 
			(int)(img.getHeight()*hcoeff), "P3");
		img2.setMaxRGB(img.getMaxRGB());

		int imgx = 0;
		int imgy = 0;

		for(double x = 0; x < img2.getWidth(); x += wcoeff) {
			for(double y = 0; y < img2.getHeight(); y += hcoeff) {
				for(int i = 0; i < (int)(wcoeff+1); i++) {
					for(int j = 0; j < (int)(hcoeff+1); j++) {
						if((int)(i + x) >= img2.getWidth()) break;
						if((int)(j + y) >= img2.getHeight()) break;
						img2.r((int)(x + i), (int)(y + j), img.r(imgx, imgy));
						img2.g((int)(x + i), (int)(y + j), img.g(imgx, imgy));
						img2.b((int)(x + i), (int)(y + j), img.b(imgx, imgy));
					}
				}


				imgy++;
				if(imgy >= img.getHeight())
					imgy = 0;
			}
			imgx++;
			if(imgx >= img.getWidth())
				imgx = img.getWidth() - 1;
		}
		
		return img2;
	}
}