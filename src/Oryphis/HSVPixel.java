package Oryphis;

import Oryphis.Pixel;

/**
 * Définit un pixel en mode HSV (hue saturation value / teinte saturation valeur)
 */
public class HSVPixel {
    public double h;
    public double s;
    public double v;

    /**
     * Constructeur par défaut
     */
    public HSVPixel() {
        h = 0.0;
        s = 0.0;
        v = 0.0;
    }

    /**
     * Créé un pixel avec les couleurs HSV.
     *
     * @param      h     l'angle de teinte en degrés
     * @param      s     saturation en pourcentage
     * @param      v     valeur en pourcentage
     */
    public HSVPixel(double h, double s, double v) {
        this.h = h;
        this.s = s;
        this.v = v;
    }

    /**
     * Permet de multiplier la saturation a l'aide d'un facteur
     *
     * @param      factor  { facteur de type double qui permet d'augmenter la saturation }
     */
    public void multiplySaturation(double factor) {
        s *= factor;
        if(s > 1.0) s = 1.0;
        else if(s < 0.0) s = 0.0;
    }

    /**
     * Ajoute de la saturation au pixel
     *
     * @param      sat   { parameter_description }
     */
    public void addSaturation(double sat) {
        s += sat;
        if(s > 1.0) s = 1.0;
        else if(s < 0.0) s = 0.0;
    }

    /**
     * Ajoute de la teinte au pixel
     * 
     * @param hue La teinte à ajouter
     */
    public void addHue(double hue) {
        h += hue;
        h %= 360.0;
    }

    /**
     * Ajoute de la valeur au pixel
     * 
     * @param value La valeur à ajouter
     */
    public void addValue(double value) {
        v += value;
        if(v < 0.0) v = 0.0;
    }

    /**
     * Converti vers un pixel RGB puis le retourne.
     *
     * @return Un pixel RGB
     */
    public Pixel to_rgb() {
        Pixel res = new Pixel();

        double chroma = v * s;
        double hprime = (h%360.0) / 60.0;

        double x = chroma * (1 - Math.abs(hprime % 2 - 1));

        if(Double.isNaN(h)) {
            res.r = 0.0;
            res.g = 0.0;
            res.b = 0.0;
        }
        else if(0 <= hprime && hprime < 1) {
            res.r = chroma;
            res.g = x;
            res.b = 0.0;
        }
        else if(1 <= hprime && hprime < 2) {
            res.r = x;
            res.g = chroma;
            res.b = 0.0;
        }
        else if(2 <= hprime && hprime < 3) {
            res.r = 0.0;
            res.g = chroma;
            res.b = x;
        }
        else if(3 <= hprime && hprime < 4) {
            res.r = 0.0;
            res.g = x;
            res.b = chroma;
        }
        else if(4 <= hprime && hprime < 5) {
            res.r = x;
            res.g = 0.0;
            res.b = chroma;
        }
        else if(5 <= hprime && hprime < 6) {
            res.r = chroma;
            res.g = 0.0;
            res.b = x;
        }

        double m = v - chroma;

        res.r += m;
        res.g += m;
        res.b += m;
 
        return res;
    }

    /**
     * Permet de retourner les valeurs des pixels HSV
     *
     * @return     { retourne les valeurs HSV }
     */
    public String toString() {
        return "h: " + h + ", s: " + s + ", v: " + v;
    }
}