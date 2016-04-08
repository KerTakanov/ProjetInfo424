package Oryphis.filtres;

import Oryphis.Filtre;
import Oryphis.PPMImage;

import java.lang.Math;

public class Courbe_En_S extends Filtre{



	public Courbe_En_S(int d){

		int moy = 0;
		int tmp = 0;
		int res;

		for(int y = 1; y < img.getWidth() - 1; y++) {
			for(int x = 1; x < img.getHeight() - 1; x++) {
				moy += PPMImage.pixelAt(x,y);
				tmp +=1;
			}
		}

		moy = moy / tmp;

		if ( x <= moy ) {
           res = x/moy;
           res = Math.pow( res, d );
           y = res*moy;
        } 

        else {
           res = 1.0 - ( (x-moy) / (1.0-moy) );
           res = Math.pow( res, d );
           y = (1.0-res)*(1.0-moy) + moy;
        }
	}

	public PPMImage appliquer(PPMImage img) {
        return this.appliquer_masque(img);
    }
}