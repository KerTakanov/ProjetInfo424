package Oryphis;

import Oryphis.PPMImage;
import Oryphis.DrawImage;
import Oryphis.Argument;

import Oryphis.filtres.PasseHaut;
import Oryphis.filtres.PasseBas;
import Oryphis.filtres.Laplacien;
import Oryphis.filtres.Estampage;
import Oryphis.filtres.Nettete;
import Oryphis.filtres.Moyenne;
import Oryphis.filtres.Gradient;

import java.util.ArrayList;
import java.util.ListIterator;

import java.io.File;

/*
 * A finir : RGB->HSV pour inverser couleurs (filtre gradient par ex.)
 */

public class Main
{
	public static void main(String[] args)
	throws java.io.FileNotFoundException, java.io.IOException
	{
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

		img = new PPMImage();
		ListIterator<Argument> it = argst.listIterator();
		while (it.hasNext()) {
			actarg = it.next();
			if(actarg.getArg().equals("-p")) {
				imgpath = actarg.getParameter(0);
				img = new PPMImage(imgpath);
			}

			else if(actarg.getArg().equals("-lp")) {
				img = new Laplacien().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-es")) {
				img = new Estampage().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-nt")) {
				img = new Nettete().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-ph")) {
				img = new PasseHaut().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-pb")) {
				img = new PasseBas().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-moy")) {
				img = new Moyenne().appliquer_masque(img);
			}
			else if(actarg.getArg().equals("-grad")) {
				img = new Gradient(Integer.parseInt(
					actarg.getParameter(0))).appliquer_masque(img);
			}
		}			

		img.save("assets/output.ppm");
	}
}