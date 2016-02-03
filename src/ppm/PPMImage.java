package src.ppm;

import java.util.ArrayList;
import src.ppm.Pixel;

public enum Format {
	P1,
	P2,
	P3
}
//P1 : PBM
//P2 : PGM
//P3 : PPM

class UnrecognizedFormatException extends Exception {
	public UnrecognizedFormatException() {
		System.out.println("Format non reconnu !");
	}
}

class PPMImage {
	private int width;
	private int height;
	private Format format;
	private ArrayList<ArrayList<Pixel>> pixels;

	public PPMImage(String path) {
		BufferedReader in = new BufferedReader(new FileReader(path));
		String line;
		getFormat(in.readLine().trim());
		}
	}

	private getFormat(String line) {
		switch(line) {
			case "P1": this.format = Format.P1; break;
			case "P2": this.format = Format.P2; break;
			case "P3": this.format = Format.P3; break;
		default: throw new UnrecognizedFormatException();
	}
}