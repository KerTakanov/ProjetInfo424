package Oryphis.filtres;

import Oryphis.PPMImage;
import Oryphis.Pixel;

/**
 * Permet de gérer un masque qui sera appliqué par un filtre.
 */
public class Masque {
    public int[][] masque;
    public int diviseur;

    public int w;
    public int h;

    /**
     * Permet de créer un nouveau masque de dimension (w, h)
     *
     * @param      w     nombre de lignes du masque
     * @param      h     nombre de colonnes du masque
     */
    public Masque(int w, int h) {
        this.masque = new int[w][h];
    }

    /**
     * Constructeur par défaut.
     */
    public Masque() {
        this(0, 0);
    }

    /**
     * Applique le masque sur un pixel d'une image
     * 
     * @param x La coordonnée x du pixel
     * @param y La coordonnée y du pixel
     * @param imgori L'image d'origine
     * @param imgdest L'image de destination
     */
    public void appliquer(int x, int y, PPMImage imgori, PPMImage imgdest) {
        int[] rgb = {0, 0, 0};

        int offx = (masque.length)/2;
        int offy = (masque[0].length)/2;

        //On boucle sur les 3 composantes
        for(int i = 0; i < 3; i++) {
            //On boucle sur les pixels nous intéressant
            for(int xo = x - offx; xo <= x + offx; xo++) {
                for(int yo = y - offy; yo <= y + offy; yo++) {
                    rgb[i] += imgori.getColor(i, xo, yo)
                              * masque[xo - x + offx][yo - y + offy];
                }
            }
            //pd
            rgb[i] = rgb[i] / diviseur;

            if(rgb[i] < 0)
                rgb[i] = 0;

            imgdest.setColor(i, x, y, rgb[i]);
        }
    }

    //Getters
    /**
     * Retourne le masque.
     *
     * @return     le masque
     */
    public int[][] getMasque() {
        return this.masque;
    }

    //Setters
    /**
     * Modifie une valeur du masque à la position (x, y) selon la valeur val.
     *
     * @param      x     l'abscisse
     * @param      y     l'ordonnée
     * @param      val   la valeur
     */
    public void set(int x, int y, int val) {
        masque[x][y] = val;
        update_div();
    }

    /**
     * Modifie une ligne entière du masque à la position x
     * selon les valeurs vals.
     *
     * @param      x     la ligne à modifier
     * @param      vals  les valeurs
     */
    public void set(int x, int[] vals) {
        masque[x] = vals;
        update_div();
    }
	/**
	 * permet de calculé le diviseur d'un filtre.
	 */
    public void update_div() {
        diviseur = 0;
        for(int x = 0; x < masque.length; ++x) {
            for(int y = 0; y < masque[x].length; ++y) {
                diviseur += masque[x][y];
            }
        }
    }
}