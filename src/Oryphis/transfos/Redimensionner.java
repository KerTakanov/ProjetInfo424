package Oryphis.transfos;

import Oryphis.PPMImage;

class Redimensionner extends Transformation {
	private double wcoeff;
	private double hcoeff;

	public Redimensionner(double wcoeff, double hcoeff) {
		this.wcoeff = wcoeff;
		this.hcoeff = hcoeff;
	}

	public PPMImage appliquer(PPMImage img) {
		
	}
}