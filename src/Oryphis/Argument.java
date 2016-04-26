package Oryphis;

import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Classe gérant un argument de la ligne de commande
 */
public class Argument
{
	
	private String argument;
	private ArrayList<String> parameters;

	/**
	 * Constructeur par défaut
	 */
	public Argument() {
		this.argument = "";
		this.parameters = new ArrayList<String>();
	}

	/**
	 * Créé un Argument ayant comme argument argument.
	 *
	 * @param      argument  l'argument
	 */
	public Argument(String argument) {
		this.argument = argument;
		this.parameters = new ArrayList<String>();
	}

	/**
	 * Créé un Argument ayant comme argument argument et comme paramètres
	 * parameters.
	 *
	 * @param      argument    l'argument
	 * @param      parameters  les paramètres
	 */
	public Argument(String argument, ArrayList<String> parameters) {
		this.argument = argument;
		this.parameters = parameters;
	}

	/**
	 * Retourne l'argument.
	 *
	 * @return     l'argument
	 */
	public String getArg() {
		return this.argument;
	}

	/**
	 * Retourne la liste des paramètres.
	 *
	 * @return     ArrayList des paramètres
	 */
	public ArrayList<String> getParameters() {
		return this.parameters;
	}

	/**
	 * Retourne le paramètre à l'index index.
	 *
	 * @param      index  l'index du paramètre recherché
	 *
	 * @return     le paramètre à l'index index
	 */
	public String getParameter(int index) {
		return this.parameters.get(index);
	}

	/**
	 * Change le paramètre à l'index index.
	 *
	 * @param      index      l'index du paramètre à modifier
	 * @param      parameter  le nouveau paramètre
	 */
	public void setParameter(int index, String parameter) {
		this.parameters.set(index, parameter);
	}

	/**
	 * Ajoute un paramètre à l'argument.
	 *
	 * @param      parameter  le paramètre à ajouter
	 */
	public void addParameter(String parameter) {
		this.parameters.add(parameter);
	}

	/**
	 * Converti en String l'argument de sorte à être affiché/écrit.
	 *
	 * @return     un String représentant l'argument
	 */
	public String toString() {
		String params = "";
		ListIterator<String> it = this.parameters.listIterator();
		while (it.hasNext()) {
			params += " " + it.next();
		}

		return this.argument + params;
	}
}