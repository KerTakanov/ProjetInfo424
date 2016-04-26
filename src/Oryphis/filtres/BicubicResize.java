package Oryphis.filtres;

import Oryphis.Pixel;
import Oryphis.PPMImage;
import Oryphis.filtres.Moyenne;

/**
 * Classe non fonctionnelle, ne pas utiliser
 */
public class BicubicResize extends Filtre {
	private double wcoeff;
	private double hcoeff;

	public BicubicResize(double wcoeff, double hcoeff) {
		this.wcoeff = wcoeff;
		this.hcoeff = hcoeff;

		double a = -0.5;

		this.masque = new Masque();
	}

	private double getValue (double[] p, double x) {
		return p[1] + 0.5 * x*(p[2] - p[0] + x*(2.0*p[0] - 5.0*p[1] + 4.0*p[2] - p[3] + x*(3.0*(p[1] - p[2]) + p[3] - p[0])));
	}

	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage((int)(img.getWidth()*wcoeff), 
			(int)(img.getHeight()*hcoeff), "P3");
		img2.setMaxRGB(img.getMaxRGB());

		int imgx = 0;
		int imgy = 0;

		for(double x = 0; x < img2.getWidth(); x += wcoeff) {
			for(double y = 0; y < img2.getHeight(); y += hcoeff) {
				img2.r((int)x, (int)y, img.r(imgx, imgy));
				img2.g((int)x, (int)y, img.g(imgx, imgy));
				img2.b((int)x, (int)y, img.b(imgx, imgy));

				imgy++;
				if(imgy >= img.getHeight())
					imgy = 0;
			}
			imgx++;
		}
/* A FAIRE */
		
		return img2;
	}
}