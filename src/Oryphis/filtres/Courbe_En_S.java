package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

import java.lang.Math;

public class Courbe_En_S extends Filtre{
	private double d;

	public Courbe_En_S(double d){
		this.d = d;
	}

	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage(img);

        double moy[] = new double[3];
        moy[0] = 0;
        moy[1] = 0;
        moy[2] = 0;
		int tmp = 0;
		double res;

		for(int y = 1; y < img.getWidth() - 1; y++) {
			for(int x = 1; x < img.getHeight() - 1; x++) {
				moy[0] += img.r(x, y);
				moy[1] += img.g(x, y);
				moy[2] += img.b(x, y);
				tmp +=1;
			}
		}

		for(int i = 0; i < 3; i++) moy[i] = moy[i] / tmp;

		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < img.getWidth(); j++) {
				for(int k = 0; k < img.getHeight(); k++) {
					if (img.getColor(i, j, k) <= moy[i] ) {
			           res = img.getColor(i, j, k) / moy[i];
			           res = Math.pow( res, d );
			           img2.setColor(i, j, k, res * moy[i]);
			        }

			        else {
			           res = 1.0 - ((img.getColor(i, j, k) - moy[i]) / (1.0-moy[i]) );
			           res = Math.pow( res, d );
			           img2.setColor(i, j, k, (1.0-res)*(1.0-moy[i]) + moy[i]);
			        }
				}
			}
		}

		img2.calcMaxRGB();

		return img2;
    }
}