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
		
		getFormat(nextLine(in));
		getSize(nextLine(in));
		}
	}

	private nextLine(BufferedReader in) {
		String line = in.readLine().trim();
		while (line[0] == "#")
			line = in.readLine().trim();

		return line;
	}

	private getFormat(String line) {
		switch(line) {
			case "P1": this.format = Format.P1; break;
			case "P2": this.format = Format.P2; break;
			case "P3": this.format = Format.P3; break;
		default: throw new UnrecognizedFormatException();
	}

	private getSize(String line) {
		int pos = line.indexOf(" ");
		String lvalue = line.substring(0, pos);
		String rvalue = line.substring(pos + 1);

		this.width = Integer.parseValue(lvalue);
		this.height = Integer.parseValue(rvalue);
	}
}