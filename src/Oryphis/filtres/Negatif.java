package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.filtres.Masque;

import Oryphis.HSVPixel;
import Oryphis.Pixel;

//Modifie la teinte d'une image d'une image (ajoute une valeur à la teinte).
public class Negatif extends Filtre {
    //doc utile : http://xmcvs.free.fr/astroart/Chapitre4.pdf
    public Negatif() {
    }

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