package Oryphis;

import Oryphis.Pixel;
import Oryphis.DrawImage;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Color;

/**
 * Définit une image au format ppm
 */
public class PPMImage {
    private int width;
    private int height;
    private double rgb_max;
    private String format;
    private Pixel[][] pixels;

    /**
     * Constructeur par défaut, créé une image vide.
     */
    public PPMImage() {
        width = 0;
        height = 0;
        format = "P3";
        pixels = new Pixel[width][height];
    }

    /**
     * Constructeur d'image PPM
     *
     * @param      w        largeur de l'image
     * @param      h        hauteur de l'image
     * @param      format   format de l'image
     * 
     */
    public PPMImage(int w, int h, String format) {
        width = w;
        height = h;
        this.format = format;
        pixels = new Pixel[width][height];

        for(int x = 0; x < w; x++) {
            for(int y = 0; y < h; y++) {
                pixels[x][y] = new Pixel();
            }
        }
    }

    /**
     * Fait une copie profonde d'une autre image
     *
     * @param      img    prend une image au format ppm
     * 
     */
    public PPMImage(PPMImage img) {
        this.width = img.getWidth();
        this.height = img.getHeight();
        this.format = img.getFormat();
        this.pixels = new Pixel[width][height];
        for(int i = 0; i < pixels.length; i++) {
            for(int j = 0; j < pixels[0].length; j++) {
                pixels[i][j] = new Pixel(img.pixelAt(i, j).r, img.pixelAt(i, j).g, img.pixelAt(i, j).b);
            }
        }
        this.rgb_max = img.getMaxRGB();
    }

    /**
     * Permet de récupérer la largeur, la hauteur et les pixels RGB d'une image
     *
     * @param      path  addresse où se trouve l'image
     * 
     */
    public PPMImage(String path) 
    throws java.io.FileNotFoundException, java.io.IOException {
        BufferedReader in = new BufferedReader(new FileReader(path));
        
        _getFormat(_nextLine(in));
        _getSize(_nextLine(in));
        this.pixels = new Pixel[width][height];
        _createPixelMap(in);
    }

    /**
     * Permet de sauvegarder une image
     *
     * @param      path   Adresse ou se trouve l'image
     *
     * @throws     java   IOException
     * 
     */
    public void save(String path)
    throws java.io.FileNotFoundException, java.io.IOException {
        File file = new File(path);
        if (!file.exists())
            file.createNewFile();

        BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
        _savePixelMap(out);

        System.out.println("Image sauvegardée (" + path + ")");
    }

    /**
     * Met à jour la valeur max pour le rgb
     * 
     * @param      max   La valeur rgb max
     *
     */
    public void setMaxRGB(double max) {
        this.rgb_max = max;
    }

    /**
     * Retourne la valeur RGB max
     * 
     * @return La valeur rgb max
     */
    public double getMaxRGB() {
        return this.rgb_max;
    }

    /**
     * Calcule le RGB max
     */
    @Deprecated
    public void calcMaxRGB() {
        for(int x = 0; x < getWidth(); x++) {
            for(int y = 0; y < getHeight(); y++) {
                if(rgb_max < r(x, y))
                    rgb_max = r(x, y);
                if(rgb_max < g(x, y))
                    rgb_max = g(x, y);
                if(rgb_max < b(x, y))
                    rgb_max = b(x, y);
            }
        }
    }

    //Accession pixels
    
    /**
     * Permet de récupérer les valeurs RGB 
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     *
     * @return     retourne les valeurs RGB du pixel de coordonnée (x;y)
     * 
     */

    public Pixel pixelAt(int x, int y) {
        return pixels[x][y];
    }

    /**
     * Permet de retourner tous les pixels
     *
     * @return     retourne tous les pixels
     * 
     */

    public Pixel[][] pixelMap() {
        return pixels;
    }

    /**
     * Permet de récupérer la valeur de la couleur rouge (red)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     *
     * @return     retourne la valeur rouge (red) de coordonnées (x;y)
     * 
     */

    public double r(int x, int y) {
        return pixels[x][y].r;
    }

    /**
     * Permet de récupérer la valeur de la couleur vert (green)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     *
     * @return     retourne la valeur vert (green) de coordonnées (x;y)
     * 
     */

    public double g(int x, int y) {
        return pixels[x][y].g;
    }

    /**
     * Permet de récupérer la valeur de la couleur bleu (blue)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     *
     * @return     retourne la valeur bleu (blue) de coordonnées (x;y)
     * 
     */

    public double b(int x, int y) {
        return pixels[x][y].b;
    }

    /**
     * Permet de récupérer la valeur d'une composante
     * 0 = rouge
     * 1 = vert
     * 2 = bleu
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     * @param      c     numéro de la composante
     *
     * @return     la valeur de la composante c de coordonnées (x;y)
     *
     */

    public double getColor(int c, int x, int y) {
        return c == 0 ? pixels[x][y].r : c == 1 ? pixels[x][y].g : pixels[x][y].b;
    }

    /**
     * Permet de définir la valeur d'une composante
     * 0 = rouge
     * 1 = vert
     * 2 = bleu
     * 
     * @param c numéro de la composante
     * @param x coordonnée x du pixel
     * @param y coordonnée y du pixel
     * @param val la nouvelle valeur de la composante
     */
    public void setColor(int c, int x, int y, double val) {
        if (c == 0) r(x, y, val);
        else if (c == 1) g(x, y, val);
        else if (c == 2) b(x, y, val);
    }

    //Manipulation pixels
    
    /**
     * Permet de modifier la valeur RGB du pixel (x;y)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     * @param      p     valeur du pixel RGB 
     * 
     */

    public void setPixel(int x, int y, Pixel p) {
        r(x, y, p.r);
        g(x, y, p.g);
        b(x, y, p.b);
    }

    /**
     * Permet de contraindre la valeur de val entre 0 et rgb_max
     * 
     * @param val La valeur a tester
     * @return La valeur entre 0 et rgb_max
     */
    private double __bound(double val) {
        if (val < 0) return 0;
        if (val > rgb_max) return rgb_max;
        return val;
    }

    /**
     * Permet de modifier la valeur rouge (red) du pixel (x;y)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     * @param      _r     valeur du pixel rouge (red)
     * 
     */

    public void r(int x, int y, double _r) {
        pixels[x][y].r = __bound(_r);
    }

    /**
     * Permet de modifier la valeur vert (green) du pixel (x;y)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     * @param      _g     valeur du pixel vert (green)
     * 
     */

    public void g(int x, int y, double _g) {
        pixels[x][y].g = __bound(_g);
    }

    /**
     * Permet de modifier la valeur bleu (blue) du pixel (x;y)
     *
     * @param      x     coordonnée x du pixel
     * @param      y     coordonnée y du pixel
     * @param      _b     valeur du pixel bleu (blue)
     * 
     */
    public void b(int x, int y, double _b) {
        pixels[x][y].b = __bound(_b);
    }

    //Accesseurs
    
    /**
     * Permet de récupérer la largeur de l'image
     *
     * @return     La largeur de l'image
     * 
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Permet de récupérer la hauteur de l'image
     *
     * @return     La hauteur de l'image
     * 
     */

    public int getHeight() {
        return this.height;
    }

    /**
     * Permet de récupérer le format de l'image
     *
     * @return     Le format de l'image
     * 
     */
    public String getFormat() {
        return this.format;
    }

    /**
     * Permet de récupérer la valuer de chaque couleur de coordonnées (x;y)
     *
     * @param      x     coordonnée x
     * @param      y     coordonnée y
     *
     * @return     la valeur rouge (red), vert (green) et bleu (blue)
     */
    public Color colorAt(int x, int y) {
        return new Color((int)(pixels[x][y].r+0.5), 
                         (int)(pixels[x][y].g+0.5), 
                         (int)(pixels[x][y].b+0.5));
    }

    //Privés
    
    /**
     * Permet de récupérer la prochaine ligne sans les espaces et les retours chariot
     * des côtés extrêmes droite et gauche      
     *
     * @param      in    BufferedReader
     *
     * @return     La prochaine ligne sans les espaces, retour chariot 
     *             des côtés extrême droite et gauche
     *
     * @throws     java  IOException
     * 
     */
    private String _nextLine(BufferedReader in) throws java.io.IOException {
        String line = in.readLine().trim();
        while (line.charAt(0) == '#')
            line = in.readLine().trim();

        return line;
    }

    /**
     * Permet de récupérer la ligne du fichier ou est écrit le format de l'image
     *
     * @param      line    Une ligne d'un fichier ou est écrit le format de l'image 
     * 
     */
    private void _getFormat(String line) {
        this.format = line;
    }

    /**
     * Permet de récupérer les dimensions d'une image
     *
     * @param      line  Une ligne d'un fichier ou est écrit les dimensions de l'image
     * 
     */
    private void _getSize(String line) {
        int pos = line.indexOf(" ");
        String lvalue = line.substring(0, pos);
        String rvalue = line.substring(pos + 1);

        this.width = Integer.parseInt(lvalue);
        this.height = Integer.parseInt(rvalue);
    }

    /**
     * Créé la map de pixels à partir d'un BufferedReader (fichier)
     *
     * @param      in    Le BufferedReader
     *
     * @throws     java  IOException
     * 
     */

    private void _createPixelMap(BufferedReader in) throws java.io.IOException {
        int[] coords = {0, 0};
        boolean rgb_max_value = false;

        ArrayList<Integer> rgb = new ArrayList<Integer>();
        String line;
        while((line = in.readLine()) != null) {
            String[] result = line.split(" ");
            for (int i = 0; i < result.length; i++) {
                if(rgb_max_value) {
                    rgb.add(Integer.parseInt(result[i]));
                    if (rgb.size() == 3) {
                        coords = __savePixel(rgb, coords);
                    }
                }
                else {
                    this.rgb_max = Integer.parseInt(result[i]);
                    rgb_max_value = true;
                }
            }
        }
    }

    /**
     * Sauvegarde un pixel dans la map de pixels.
     * 
     * @param rgb Liste des 3 composantes du pixel
     * @param coords Tableau des 2 coordonnées
     * @return Retourne les coordonnées du *prochain* pixel
     */
    private int[] __savePixel(ArrayList<Integer> rgb, int[] coords) {
        //Créé un nouveau pixel, puis l'assigne à *cette* PPMImage
        int x = coords[0];
        int y = coords[1];

        pixels[x][y] =
        new Pixel(rgb.get(0), rgb.get(1), rgb.get(2));
        rgb.clear();

        x++;
        if (x >= width) { y++; x = 0; }
        coords[0] = x;
        coords[1] = y;
        return coords;
    }

    /**
     * Permet de sauvegarder la map de pixels à partir d'un BufferedWritter
     *
     * @param      out   BufferedWritter
     *
     * @throws     java  IOException
     * 
     */

    private void _savePixelMap(BufferedWriter out) throws java.io.IOException {
        int _rgbmax = (int)(this.rgb_max+0.5);
        if(_rgbmax == 0)
            _rgbmax = 255;

        out.write(format + "\n");
        out.write(Integer.toString(width) + " " + Integer.toString(height) + "\n");
        out.write(Integer.toString(_rgbmax) + "\n");

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                out.write(Integer.toString((int)(pixels[x][y].r + 0.5)) + " "
                        + Integer.toString((int)(pixels[x][y].g + 0.5)) + " "
                        + Integer.toString((int)(pixels[x][y].b + 0.5)) + "\n");
            }
        }
        out.close();
    }
}