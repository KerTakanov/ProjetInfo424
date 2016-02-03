package src;
import java.util.ArrayList;
import java.util.ListIterator;

public class Argument
{
	private String argument;
	private ArrayList<String> values;

	public Argument() {
		this.argument = "";
		this.values = new ArrayList<String>();
	}

	public Argument(String argument) {
		this.argument = argument;
		this.values = new ArrayList<String>();
	}

	public Argument(String argument, ArrayList<String> values) {
		this.argument = argument;
		this.values = values;
	}

	public String getArg() {
		return this.argument;
	}

	public ArrayList<String> getValues() {
		return this.values;
	}

	public String getValue(int index) {
		return this.values.get(index);
	}

	public int getIntValue(int index) {
		return Integer.parseInt(this.values.get(index));
	}

	public void setValue(int index, String value) {
		this.values.set(index, value);
	}

	public void addValue(String value) {
		this.values.add(value);
	}

	public String toString() {
		String params = "";
		ListIterator<String> it = this.values.listIterator();
		while (it.hasNext()) {
			params += " " + it.next();
		}

		return this.argument + params;
	}
}