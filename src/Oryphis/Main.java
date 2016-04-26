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
import Oryphis.filtres.Seuil;

//Redimensionnement
import Oryphis.filtres.BicubicResize;
import Oryphis.filtres.RedimVoisin;

//Transfos
import Oryphis.transfos.MelangeImage;
import Oryphis.transfos.MelangeImageTeinte;
import Oryphis.transfos.Rotation;

//col modifs
import Oryphis.filtres.Saturation;
import Oryphis.filtres.Teinte;
import Oryphis.filtres.Luminosite;
import Oryphis.filtres.InverserValeur;
import Oryphis.filtres.Negatif;
import Oryphis.filtres.Courbe_En_S;

import java.util.ArrayList;
import java.util.ListIterator;

import java.io.File;

import Oryphis.Pixel;
import Oryphis.HSVPixel;

public class Main
{
    public static void help(String arg) {
        int val = -1;

/* à améliorer en utilisant par ex. une map */
        if(arg.equals("o"))
            val = 0;
        else if(arg.equals("lp"))
            val = 1;
        else if(arg.equals("es"))
            val = 2;
        else if(arg.equals("nt"))
            val = 3;
        else if(arg.equals("ph"))
            val = 4;
        else if(arg.equals("pb"))
            val = 5;
        else if(arg.equals("moy"))
            val = 6;
        else if(arg.equals("grad"))
            val = 7;
        else if(arg.equals("sat"))
            val = 8;
        else if(arg.equals("hue"))
            val = 9;
        else if(arg.equals("lum"))
            val = 10;
        else if(arg.equals("ival"))
            val = 11;
        else if(arg.equals("neg"))
            val = 12;
        else if(arg.equals("ces"))
            val = 13;
        else if(arg.equals("br"))
            val = 14;
        else if(arg.equals("sel"))
            val = 15;
        else if(arg.equals("red"))
            val = 16;
        else if(arg.equals("mel"))
            val = 17;
        else if(arg.equals("melhue"))
            val = 18;
        else if(arg.equals("rot"))
            val = 19;

/* Formation des strings d'aide */
        String help_header = "//////////////////////////////////////////////////\n"+
"/// Oryphis - Logiciel de manipulation d'image ///\n"+
"///--------------------------------------------///\n"+
"/// Aide                                       ///\n"+
"//////////////////////////////////////////////////\n"+
"Utilisation:\n"+
"<chemin image> -arg <val>\n"+
"-------------------------"+
"\n\n";

        String help = help_header + "Liste des commandes :\n"+
"-o <chemin>\n"+
"-lp\n"+
"-es\n"+
"-nt\n"+
"-ph\n"+
"-pb\n"+
"-moy\n"+
"-grad <direction[0=haut|1=droite|2=bas|3=gauche]>\n"+
"-sat <flottant>\n"+
"-hue <flottant[0 -> 360]>\n"+
"-lum <flottant>\n"+
"-ival\n"+
"-neg\n"+
"-ces <flottant[0->8]>\n"+
"-br (non fonctionnel)\n"+
"-sel <entier[0->255]>\n" +
"-red <flottant[0.5 -> 10 (conseillé)]><flottant[0.5 -> 10]>\n" +
"-mel <chemin>\n" +
"-melhue <chemin>\n" +
"Tapez -help <commande> pour obtenir l'aide concernant une commande en particulier\n\n";
    
        String[] help_cmd = new String[] {
help_header + "-o\n" +
"Modifie le chemin du fichier de sortie",

help_header + "-lp\n"+
"Applique un filtre Laplacien à l'image",

help_header + "-es\n"+
"Applique un filtre Estampage à l'image",

help_header + "-nt\n"+
"Applique un filtre Nettete à l'image",

help_header + "-ph\n"+
"Applique un filtre Passe Haut à l'image",

help_header + "-pb\n"+
"Applique un filtre Passe Bas à l'image",

help_header + "-moy\n"+
"Applique un filtre Moyenne à l'image",

help_header + "-grad <direction[0=haut|1=droite|2=bas|3=gauche]>\n"+
"Applique un filtre Gradient à l'image dans la direction choisie",

help_header + "-sat <flottant>\n"+
"Multiplie la saturation de l'image par une valeur",

help_header + "-hue <flottant[0 -> 360]>\n"+
"Déplace la teinte de l'image",

help_header + "-lum <flottant>\n"+
"Permet d'ajouter de la luminosité à l'image",

help_header + "-ival\n"+
"Inverse la valeur de l'image.",

help_header + "-neg\n"+
"Met l'image en négatif",

help_header + "-ces <flottant[0->10]>\n"+
"Applique un contraste avec une courbe en S",

help_header + "-br\n"+
"N'est pas fonctionnel",

help_header + "-sel <entier[0->255]>\n"+
"Applique un seuil à une image",

help_header + "-red <flottant[0.5 -> 10 (conseillé)]><flottant[0.5 -> 10]>\n"+
"Modifie les dimensions de l'image selon deux facteurs",

help_header + "-mel <chemin>\nMélange deux images selon leur pixels RGB.",
help_header + "-melhue <chemin>\nMélange deux images selon leur teinte.",
help_header + "-rot <entier[0->360]\nApplique une rotation à l'image. [!] Peut faire sortir des pixels du cadre." };

    if(val >= 0)
        System.out.print(help_cmd[val] + "\n");
    else
        System.out.print(help);
    }

    public static void help() {
        help("");
    }

    public static void main(String[] args)
    throws java.io.FileNotFoundException, java.io.IOException
    {
        ArrayList<Argument> argst = new ArrayList<Argument>();
        Argument actarg = new Argument();
        String actargs;
        String imgpath = "";
        String output = "output.ppm";
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

        if(args.length > 0 && !(args[0].charAt(0) == '-'))
            imgpath = args[0];
        else if (argst.size() == 0)
            help();

        if (imgpath != "")
            img = new PPMImage(imgpath);
        else
            img = new PPMImage(1, 1, "P3");

        ListIterator<Argument> it = argst.listIterator();

        while (it.hasNext()) {
            actarg = it.next();
            if(actarg.getArg().equals("-o")) {
                output = actarg.getParameter(0);
            }
            else if(actarg.getArg().equals("-lp")) {
                img = new Laplacien().appliquer(img);
            }
            else if(actarg.getArg().equals("-es")) {
                img = new Estampage().appliquer(img);
            }
            else if(actarg.getArg().equals("-nt")) {
                img = new Nettete().appliquer(img);
            }
            else if(actarg.getArg().equals("-ph")) {
                img = new PasseHaut().appliquer(img);
            }
            else if(actarg.getArg().equals("-pb")) {
                img = new PasseBas().appliquer(img);
            }
            else if(actarg.getArg().equals("-moy")) {
                img = new Moyenne().appliquer(img);
            }
            else if(actarg.getArg().equals("-grad")) {
                img = new Gradient(Integer.parseInt(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-sat")) {
                img = new Saturation(Double.parseDouble(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-hue")) {
                img = new Teinte(Double.parseDouble(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-lum")) {
                img = new Luminosite(Double.parseDouble(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-ival")) {
                img = new InverserValeur().appliquer(img);
            }
            else if(actarg.getArg().equals("-neg")) {
                img = new Negatif().appliquer(img);
            }
            else if(actarg.getArg().equals("-ces")) {
                img = new Courbe_En_S(Double.parseDouble(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-br")) {
                System.out.println("N'est pas fontionnel !");
                img = new BicubicResize(Double.parseDouble(
                    actarg.getParameter(0)),
                Double.parseDouble(
                    actarg.getParameter(1))).appliquer(img);
            }
            else if(actarg.getArg().equals("-sel")) {
                img = new Seuil(Double.parseDouble(
                    actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-h") || actarg.getArg().equals("-help")) {
                if (actarg.getParameters().size() == 0)
                    help();
                else
                    help(actarg.getParameter(0));
            }
            else if(actarg.getArg().equals("-red")) {
                img = new RedimVoisin(Double.parseDouble(
                    actarg.getParameter(0)),
                Double.parseDouble(
                    actarg.getParameter(1))).appliquer(img);
            }
            else if(actarg.getArg().equals("-mel")) {
                img = new MelangeImage(new PPMImage(actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-melhue")) {
                img = new MelangeImageTeinte(new PPMImage(actarg.getParameter(0))).appliquer(img);
            }
            else if(actarg.getArg().equals("-rot")) {
                img = new Rotation(Integer.parseInt(
                    actarg.getParameter(0))).appliquer(img);
            }
        }

        if (imgpath != "")
            img.save(output);
    }
}