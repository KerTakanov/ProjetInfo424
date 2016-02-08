package Oryphis;
import java.util.ArrayList;
import java.util.ListIterator;

public class Argument
{
	private String argument;
	private ArrayList<String> parameters;

	public Argument() {
		this.argument = "";
		this.parameters = new ArrayList<String>();
	}

	public Argument(String argument) {
		this.argument = argument;
		this.parameters = new ArrayList<String>();
	}

	public Argument(String argument, ArrayList<String> parameters) {
		this.argument = argument;
		this.parameters = parameters;
	}

	public String getArg() {
		return this.argument;
	}

	public ArrayList<String> getParameters() {
		return this.parameters;
	}

	public String getParameter(int index) {
		return this.parameters.get(index);
	}

	public int getIntParameter(int index) {
		return Integer.parseInt(this.parameters.get(index));
	}

	public void setParameter(int index, String parameter) {
		this.parameters.set(index, parameter);
	}

	public void addParameter(String parameter) {
		this.parameters.add(parameter);
	}

	public String toString() {
		String params = "";
		ListIterator<String> it = this.parameters.listIterator();
		while (it.hasNext()) {
			params += " " + it.next();
		}

		return this.argument + params;
	}
}