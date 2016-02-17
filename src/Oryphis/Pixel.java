package Oryphis;

public class Pixel {
	public int r;
	public int g;
	public int b;

	/**
	 * Créé un pixel avec les couleurs RGB.
	 *
	 * @param      r     la composante rouge
	 * @param      g     la composante verte
	 * @param      b     la composante bleue
	 */
	public Pixel(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	/**
	 * Multiplie toutes les composantes d'un pixel par un coefficient.
	 * Ne permet pas de dépasser 255.
	 *
	 * @param      coeff  le coefficient par lequel on multiplie
	 */
	public void multiply(int coeff) {
		r *= coeff;
		g *= coeff;
		b *= coeff;

		if(r > 255) r = 255;
		if(g > 255) g = 255;
		if(b > 255) b = 255;
	}
}