package Oryphis;

import Oryphis.HSVPixel;

public class Pixel {
    public double r;
    public double g;
    public double b;

    /**
     * Constructeur par défaut
     */
    public Pixel() {
        r = 0.0;
        g = 0.0;
        b = 0.0;
    }

    /**
     * Créé un pixel avec les couleurs RGB.
     *
     * @param      r     la composante rouge
     * @param      g     la composante verte
     * @param      b     la composante bleue
     */
    public Pixel(double r, double g, double b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Permet de transformer les pixels rgb en format HSV
     *
     * @return     { retourne la valeur du pixel en format HSV }
     */    
    public HSVPixel to_hsv() {
        HSVPixel res = new HSVPixel();

        double min = Math.min(r, Math.min(g, b));
        double max = Math.max(r, Math.max(g, b));

        double delta = max - min;

        res.v = max;

        if(delta < 0.00001) {
            res.s = 0.0;
            res.h = 0.0;

            return res;
        }

        if(max > 0.0)
            res.s = delta/max;
        else {
            res.s = 0.0;
            res.h = Double.NaN;

            return res;
        }
        if(r >= max)
            res.h = (g - b) / delta;
        else {
            if(g >= max)
                res.h = 2.0 + (b - r) / delta;
            else
                res.h = 4.0 + (r - g) / delta;
        }

        res.h *= 60.0;

        if(res.h < 0.0)
            res.h += 360.0;

        return res;
    }

    /**
     * Multiplie toutes les composantes d'un pixel par un coefficient.
     * Ne permet pas de dépasser 255.
     *
     * @param      coeff  le coefficient par lequel on multiplie
     */
    public void multiply(double coeff) {
        r *= coeff;
        g *= coeff;
        b *= coeff;

        if(r > 255.0) r = 255.0;
        if(g > 255.0) g = 255.0;
        if(b > 255.0) b = 255.0;
    }

    /**
     * Permet de retourner les valeurs des pixels rgb
     *
     * @return     { retourne la valuer des pixels rgb }
     */
    public String toString() {
        return "r: " + r + ", g: " + g + ", b: " + b;
    }
}