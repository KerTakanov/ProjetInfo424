package Oryphis.transfos;

import Oryphis.filtres.RedimVoisin;
import Oryphis.PPMImage;

public class MelangeImage extends Transformation {
	private PPMImage trans;

	public MelangeImage(PPMImage trans) {
		this.trans = trans;
	}

	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage(img.getWidth(), img.getHeight(), "P3");
		PPMImage tmp = new PPMImage(trans);
		if(img.getWidth() != trans.getWidth() ||
		   img.getHeight() != trans.getHeight()) {
			tmp = new RedimVoisin((double)img.getWidth()/trans.getWidth(),
							  (double)img.getHeight()/trans.getHeight()).appliquer(tmp);
		}

		double moy;
		for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
            	for(int c = 0; c < 2; c++) {

            		moy = tmp.getColor(c, x, y)
            		+ img.getColor(c, x, y);
            		moy /= 2;

            		img2.setColor(c, x, y, moy);
            	}
            }
        }

        img2.calcMaxRGB();

        return img2;
	}
}