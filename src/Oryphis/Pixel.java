package Oryphis;

public class Pixel {
	public int r;
	public int g;
	public int b;

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