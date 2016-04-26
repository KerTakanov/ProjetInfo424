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

        double max = Math.max(r, Math.max(g, b));
        double min = Math.min(r, Math.min(g, b));

        double delta = max - min;

        //Calcul de la valeur
        res.v = max;

        //Delta est très proche de 0, pixel noir
        if(delta < 0.00001) {
            res.s = 0.0;
            res.h = 0.0;

            return res;
        }

        //Calcul de la saturation
        if(max > 0.0)
            //max /= 0
            res.s = delta/max;
        else {
            //max = 0
            res.s = 0.0;
            res.h = Double.NaN;

            return res;
        }

        //Calcul de la teinte (hue)
        if(r >= max)
            res.h = ((g - b) / delta) % 6;
        else {
            if(g >= max)
                res.h = 2.0 + (b - r) / delta;
            else
                res.h = 4.0 + (r - g) / delta;
        }

        // * 60°
        res.h *= 60.0;

        //Tentative de correction d'erreur
        if(res.h < 0.0)
            res.h += 360.0;

        return res;
    }

    /**
     * Multiplie toutes les composantes d'un pixel par un coefficient.
     *
     * @param      coeff  le coefficient par lequel on multiplie
     */
    public void multiply(double coeff) {
        r *= coeff;
        g *= coeff;
        b *= coeff;
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