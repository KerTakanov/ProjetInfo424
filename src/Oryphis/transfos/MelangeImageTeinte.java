package Oryphis.transfos;

import Oryphis.filtres.RedimVoisin;
import Oryphis.PPMImage;

import Oryphis.HSVPixel;
import Oryphis.Pixel;

public class MelangeImageTeinte extends Transformation {
	private PPMImage trans;

	public MelangeImageTeinte(PPMImage trans) {
		this.trans = trans;
	}

	public PPMImage appliquer(PPMImage img) {
		PPMImage img2 = new PPMImage(img.getWidth(), img.getHeight(), "P3");
		img2.setMaxRGB(img.getMaxRGB());
		PPMImage tmp = new PPMImage(trans);
		if(img.getWidth() != trans.getWidth() ||
		   img.getHeight() != trans.getHeight()) {
			tmp = new RedimVoisin((double)img.getWidth()/trans.getWidth(),
							  (double)img.getHeight()/trans.getHeight()).appliquer(tmp);
		}

		double moy;
		HSVPixel hpx;

		for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
            	for(int c = 0; c < 2; c++) {
            		hpx = img.pixelAt(x, y).to_hsv();

            		moy = hpx.h + tmp.pixelAt(x, y).to_hsv().h;
            		moy /= 2;

            		hpx.h = moy;

            		img2.setPixel(x, y, hpx.to_rgb());
            	}
            }
        }

        return img2;
	}
}