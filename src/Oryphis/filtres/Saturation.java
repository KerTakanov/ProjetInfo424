package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

import Oryphis.HSVPixel;
import Oryphis.Pixel;

//Multiplie la saturation d'une image par un facteur.
public class Saturation extends Filtre {
    private double valeur;

    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Saturation(double valeur) {
        this.valeur = valeur;
    }
    
    /**
     * applique le filtre à une image
     *
     * @param      img   { image à modifier }
     *
     * @return     { applique le filtre }
     */
    public PPMImage appliquer(PPMImage img) {
        PPMImage img2 = new PPMImage(img);
        HSVPixel p;
        Pixel rgbp;

        for(int y = 0; y < img.getWidth(); y++) {
            for(int x = 0; x < img.getHeight(); x++) {
                p = img.pixelAt(x, y).to_hsv(img.getMaxRGB());
                p.multiplySaturation(valeur);
                rgbp = p.to_rgb();

                img2.setPixel(x, y, rgbp);

                if(rgbp.r > img2.getMaxRGB())
                    img2.setMaxRGB(rgbp.r);
                if(rgbp.g > img2.getMaxRGB())
                    img2.setMaxRGB(rgbp.g);
                if(rgbp.b > img2.getMaxRGB())
                    img2.setMaxRGB(rgbp.b);
            }
        }

        return img2;
    }
}