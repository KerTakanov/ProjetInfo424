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
	 * Permet de créer une image de largeur w, hauteur h et de format format.
	 * @param w: la largeur de l'image
	 * @param h: la hauteur de l'image
	 * @param format: le format de l'image
	 */
	public PPMImage(int w, int h, String format) {
		width = w;
		height = h;
		format = format;
		pixels = new Pixel[width][height];
	}

	public PPMImage(PPMImage img) {
		this.width = img.getWidth();
		this.height = img.getHeight();
		this.format = img.getFormat();
		this.pixels = new Pixel[width][height];
		this.pixels = img.getPixels();
	}

	public PPMImage(String path) 
	throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		
		_getFormat(_nextLine(in));
		_getSize(_nextLine(in));
		this.pixels = new Pixel[width][height];
		_createPixelMap(in);
	}

	//Sauvegarde
	public void save(String path)
	throws java.io.FileNotFoundException, java.io.IOException {
		File file = new File(path);
		if (!file.exists())
			file.createNewFile();

		BufferedWriter out = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
		_savePixelMap(out);
	}

	//Accession pixels
	public Pixel pixelAt(int x, int y) {
		return pixels[x][y];
	}

	public Pixel[][] pixelMap() {
		return pixels;
	}

	public int r(int x, int y) {
		return pixels[x][y].r;
	}

	public int g(int x, int y) {
		return pixels[x][y].g;
	}

	public int b(int x, int y) {
		return pixels[x][y].b;
	}

	//Manipulation pixels
	public void setPixel(int x, int y, Pixel p) {
		pixels[x][y] = p;
	}

	public void r(int x, int y, int _r) {
		pixels[x][y].r = _r;
	}

	public void g(int x, int y, int _g) {
		pixels[x][y].g = _g;
	}

	public void b(int x, int y, int _b) {
		pixels[x][y].b = _b;
	}

	//Accesseurs
	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public String getFormat() {
		return this.format;
	}

	public Color colorAt(int x, int y) {
		return new Color(pixels[x][y].r, pixels[x][y].g, pixels[x][y].b);
	}

	public Pixel[][] getPixels() {
		return pixels;
	}

	//Privés
	private String _nextLine(BufferedReader in) throws java.io.IOException {
		String line = in.readLine().trim();
		while (line.charAt(0) == '#')
			line = in.readLine().trim();

		return line;
	}

	private void _getFormat(String line) {
		this.format = line;
	}

	private void _getSize(String line) {
		int pos = line.indexOf(" ");
		String lvalue = line.substring(0, pos);
		String rvalue = line.substring(pos + 1);

		this.width = Integer.parseInt(lvalue);
		this.height = Integer.parseInt(rvalue);
	}

	private void _createPixelMap(BufferedReader in) throws java.io.IOException {
		int x = 0;
		int y = 0;

		int nbPixels = width * height;
		for (int i = 0; i < nbPixels; i++) {
			pixels[x][y] = new Pixel(Integer.parseInt(_nextLine(in)),
									 Integer.parseInt(_nextLine(in)),
									 Integer.parseInt(_nextLine(in)));

			x++;
			if(x >= width) {
				x = 0;
				y++;
			}
		}
	}

	private void _savePixelMap(BufferedWriter out) throws java.io.IOException {
		out.write(format + "\n");
		out.write(Integer.toString(width) + " " + Integer.toString(height) + "\n");		

		for(int y = 0; y < width; y++) {
			for(int x = 0; x < width; x++) {
				out.write(Integer.toString(pixels[x][y].r) + "\n"
						+ Integer.toString(pixels[x][y].g) + "\n"
						+ Integer.toString(pixels[x][y].b) + "\n");
			}
		}
		out.close();
	}
}