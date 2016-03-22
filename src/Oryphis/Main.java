package Oryphis;

import Oryphis.PPMImage;
import Oryphis.DrawImage;
import Oryphis.Argument;

import Oryphis.filtres.Laplacien;

import java.util.ArrayList;
import java.util.ListIterator;

import java.io.File;

public class Main
{
	public static void main(String[] args)
	throws java.io.FileNotFoundException, java.io.IOException
	{
		boolean laplacien = false;

		ArrayList<Argument> argst = new ArrayList<Argument>();
		Argument actarg = new Argument();
		String actargs, imgpath = "";
		PPMImage img;

		for(int i = 0; i < args.length; i++) {
			actargs = args[i];

			if(actargs.charAt(0) == '-') {
				actarg = new Argument(actargs);
				argst.add(actarg);
			}
			else {
				actarg.addParameter(actargs);
			}
		}

		System.out.println("Il y a " + argst.size() + " arguments :");

		ListIterator<Argument> it = argst.listIterator();
		while (it.hasNext()) {
			actarg = it.next();
			if(actarg.getArg().equals("-p")) {
				imgpath = actarg.getParameter(0);
			}
			if(actarg.getArg().equals("lp")) {
				laplacien = true;
			}
		}
		img = new PPMImage(imgpath);
		img = new Laplacien().appliquer_masque(img);

		img.save("assets/output.ppm");
	}
}