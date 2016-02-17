package Oryphis;


class Pixel {
	public int r;
	public int g;
	public int b;

	/**
	  * 
	  * Creer un pixel de type RGB
	  *
	  * Etant donnée les données RGB, cette fonction créer un pixel
	  *
	  * @param : r = la valeur de l'intensité de la couleur rouge (red)
	  * @param : g = la valeur de l'intensité de la couleur vert (green)
	  * @param : b = la valeur de l'intensité de la couleur bleu (blue)
	  * 
	  */

	public Pixel(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public void multiply(int coeff) {
		r *= coeff;
		g *= coeff;
		b *= coeff;

		if(r > 255) r = 255;
		if(g > 255) g = 255;
		if(b > 255) b = 255;
	}
}