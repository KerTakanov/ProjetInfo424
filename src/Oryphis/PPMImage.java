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

public class PPMImage {
	private int width;
	private int height;
	private String format;
	private Pixel[][] pixels;

	/**
	 * Constrtucteur d'image PPM
	 *
	 * @param      w        largeur de l'image
	 * @param      h        hauteur de l'image
	 * @param      format   format de l'image
	 * 
	 */

	public PPMImage(int w, int h, String format) {
		width = w;
		height = h;
		format = format;
		pixels = new Pixel[width][height];
	}

	/**
	 * Construteur d'image bis
	 *
	 * @param      img    prend une image au format ppm
	 * 
	 */
	
	public PPMImage(PPMImage img) {
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.format = img.getFormat();
		this.pixels = new Pixel[width][height];
		this.pixels = img.pixelMap();
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

	public int r(int x, int y) {
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

	public int g(int x, int y) {
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

	public int b(int x, int y) {
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

	public int getColor(int c, int x, int y) {
		return c == 0 ? pixels[x][y].r : c == 1 ? pixels[x][y].g : pixels[x][y].b;
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
		pixels[x][y] = p;
	}

	/**
	 * Permet de modifier la valeur rouge (red) du pixel (x;y)
	 *
	 * @param      x     coordonnée x du pixel
	 * @param      y     coordonnée y du pixel
	 * @param      _r     valeur du pixel rouge (red)
	 * 
	 */

	public void r(int x, int y, int _r) {
		pixels[x][y].r = _r;
	}

	/**
	 * Permet de modifier la valeur vert (green) du pixel (x;y)
	 *
	 * @param      x     coordonnée x du pixel
	 * @param      y     coordonnée y du pixel
	 * @param      _g     valeur du pixel vert (green)
	 * 
	 */

	public void g(int x, int y, int _g) {
		pixels[x][y].g = _g;
	}

	public void setColor(int c, int x, int y, int val) {
		if (c == 0) pixels[x][y].r = val;
		else if (c == 1) pixels[x][y].g = val;
		else if (c == 2) pixels[x][y].b = val;
	}

	/**
	 * Permet de modifier la valeur bleu (blue) du pixel (x;y)
	 *
	 * @param      x     coordonnée x du pixel
	 * @param      y     coordonnée y du pixel
	 * @param      _b     valeur du pixel bleu (blue)
	 * 
	 */

	public void b(int x, int y, int _b) {
		pixels[x][y].b = _b;
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
		return new Color(pixels[x][y].r, pixels[x][y].g, pixels[x][y].b);
	}

	//Privés
	
	/**
	 * Permet de récupérer la prochaine ligne sans les espaces et les retours chariot
	 * des côtés extrêmes droite et gauche		
	 *
	 * @param      in    BufferedReader
	 *
	 * @return     La prochaine ligne sans les espaces, retour chariot 
	 * 			   des côtés extrême droite et gauche
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

		ArrayList<Integer> rgb = new ArrayList<Integer>();
		String line;
		while((line = in.readLine()) != null) {
			String[] result = line.split(" ");
			for (int i = 0; i < result.length; i++) {
				rgb.add(Integer.parseInt(result[i]));
				if (rgb.size() == 3) {
					coords = __savePixel(rgb, coords);
				}
			}
		}
	}

	private int[] __savePixel(ArrayList<Integer> rgb, int[] coords) {
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
		out.write(format + "\n");
		out.write(Integer.toString(width) + " " + Integer.toString(height) + "\n");		

		for(int y = 0; y < width; y++) {
			for(int x = 0; x < width; x++) {
				out.write(Integer.toString(pixels[x][y].r) + " "
						+ Integer.toString(pixels[x][y].g) + " "
						+ Integer.toString(pixels[x][y].b) + "\n");
			}
		}
		out.close();
	}
}