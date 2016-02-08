import src.Argument;
import java.util.ArrayList;
import java.util.ListIterator;

public class Oryphis
{
	public static void main(String[] args)
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
	}
}