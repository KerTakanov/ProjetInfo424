package src.ppm;

import src.ppm.Pixel;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PPMImage {
	private int width;
	private int height;
	private String format;
	private ArrayList<ArrayList<Pixel>> pixels;

	public PPMImage(String path) 
	throws java.io.FileNotFoundException, java.io.IOException {
		BufferedReader in = new BufferedReader(new FileReader(path));
		
		_getFormat(_nextLine(in));
		_getSize(_nextLine(in));
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return this.height;
	}

	public String getFormat() {
		return this.format;
	}

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
		String line = _nextLine(in);
		while(line != null) {

			line = _nextLine(in);
		}
	}
}