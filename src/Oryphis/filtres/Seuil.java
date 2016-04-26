package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

import Oryphis.Pixel;

/**
 * Applique un seuil à une image
 */
public class Seuil extends Filtre {
    private double valeur;

    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Seuil(double valeur) {
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

        double moy;

        for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
                moy = img.r(x, y) + img.g(x, y) + img.b(x, y);
                moy /= 3.0;

                if(moy < valeur)
                    img2.setPixel(x, y, new Pixel(255, 255, 255));
            }
        }

        return img2;
    }
}