package Oryphis.filtres;

import Oryphis.filtres.Masque;
import Oryphis.PPMImage;

/**
 * Courbe en S: Applique un contraste à l'image à l'aide de la courbe en S.
 */
public class Courbe_En_S extends Filtre{
	private double d;

	/**
	 * @param d Le contraste à appliquer
	 */
	public Courbe_En_S(double d){
		this.d = d;
	}

	/**
     * Applique le filtre à une image
     *
     * @param      img   image à modifier
     *
     * @return     L'image à qui on a appliqué le filtre
     */
	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage(img);
		img2.setMaxRGB(img.getMaxRGB());

		//Calcule de la moyenne de chaque composante
        double moy[] = new double[3];
        moy[0] = 0.0;
        moy[1] = 0.0;
        moy[2] = 0.0;
		double res = 0.0;

		for(int y = 0; y < img.getWidth(); y++) {
			for(int x = 0; x < img.getHeight(); x++) {
				moy[0] += img.r(x, y);
				moy[1] += img.g(x, y);
				moy[2] += img.b(x, y);
			}
		}

		for(int i = 0; i < 3; i++) {
			moy[i] = moy[i] / (img.getWidth() * img.getHeight());
		}	

		//Calcul de la courbe en S.
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
		return img2;
    }
}