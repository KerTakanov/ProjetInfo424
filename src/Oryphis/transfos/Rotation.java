package Oryphis.transfos;

import Oryphis.PPMImage;

public class Rotation extends Transformation {
	private int angle;

	public Rotation(int angle) {
		this.angle = angle;
	}

	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage(img.getWidth(), img.getHeight(), "P3");
		img2.setMaxRGB(img.getMaxRGB());
		angle %= 360;
		double rad = - Math.toRadians(angle);

		int x2, y2;

		int w = img2.getWidth() / 2;
		int h = img2.getHeight() / 2;
		for(int y = 0; y < img2.getHeight(); y++) {
			for(int x = 0; x < img2.getWidth(); x++) {
				int x_tmp = x - w;
				int y_tmp = y - h;

				/*
				Pondérer les pixels selon les voisins
				en prenant z = 20.58
				lambda = 0.58
				x = 20
				c=lambda * couleur(px + 1) + (1-lambda) * couleur(px)
				*/
				x2 = w + (int) (x_tmp * Math.cos(rad) - y_tmp * Math.sin(rad));
				y2 = h + (int) (x_tmp * Math.sin(rad) + y_tmp * Math.cos(rad));

				if(x2 < 0 || x2 > img.getWidth() - 1 ||
				   y2 < 0 || y2 > img.getHeight() - 1) {
					img2.r(x, y, 0);
					img2.g(x, y, 0);
					img2.b(x, y, 0);
				}
				else {
					img2.r(x, y, img.r(x2, y2));
					img2.g(x, y, img.g(x2, y2));
					img2.b(x, y, img.b(x2, y2));
				}
			}
		}
		

        return img2;
	}
}