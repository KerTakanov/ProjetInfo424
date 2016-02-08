package Oryphis;

import Oryphis.PPMImage;
import Oryphis.DrawImage;
import Oryphis.Argument;

import java.util.ArrayList;
import java.util.ListIterator;

public class Main
{
	public static void main(String[] args)
	throws java.io.FileNotFoundException, java.io.IOException
	{
		ArrayList<Argument> argst = new ArrayList<Argument>();
		Argument actarg = new Argument();
		String actargs;
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
			System.out.println(it.next().toString());
		}

		DrawImage di = new DrawImage("src/ppm/pbmlib.ppm");
	}
}