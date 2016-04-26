package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

import Oryphis.HSVPixel;
import Oryphis.Pixel;

/**
 * Permet de mettre une image en négatif
 */
public class Negatif extends Filtre {
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Negatif() {
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
        Pixel rgbp;

        for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
                rgbp = img.pixelAt(x, y);

                rgbp.r = img.getMaxRGB() - rgbp.r;
                rgbp.g = img.getMaxRGB() - rgbp.g;
                rgbp.b = img.getMaxRGB() - rgbp.b;

                img2.setPixel(x, y, rgbp);
            }
        }

        return img2;
    }
}