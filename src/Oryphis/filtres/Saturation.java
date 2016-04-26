package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

import Oryphis.HSVPixel;
import Oryphis.Pixel;

/**
 * Multiplie la saturation par une valeur
 */
public class Saturation extends Filtre {
    private double valeur;

    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Saturation(double valeur) {
        this.valeur = valeur;
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
        HSVPixel p;
        Pixel rgbp;

        for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
                p = img.pixelAt(x, y).to_hsv();
                p.multiplySaturation(valeur);
                rgbp = p.to_rgb();

                img2.setPixel(x, y, rgbp);
            }
        }

        return img2;
    }
}