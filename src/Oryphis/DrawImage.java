package Oryphis;
import Oryphis.PPMImage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Permet d'afficher facilement une image.
 * Exemple d'utilisation:
 * DrawImage("assets/pbmimg.ppm");
 */
public class DrawImage extends JFrame {
	private Container c;
	private PPMImage img;

	/**
	 * Constructeur affichant directement l'image située au chemin path.
	 *
	 * @param      path  le chemin de l'image
	 */
	public DrawImage(String path) 
	throws java.io.FileNotFoundException, java.io.IOException {
		super();
		img = new PPMImage(path); 
		this.initialize();
		this.setVisible(true);
		this.setSize(new Dimension(img.getWidth()+15, img.getHeight()+15));
	}

	/**
	 * Constructeur affichant directement l'image img.
	 *
	 * @param      img   l'image
	 */
	public DrawImage(PPMImage img)
	throws java.io.FileNotFoundException, java.io.IOException {
		super();
		this.img = img;
		this.initialize();
		this.setVisible(true);
		this.setSize(new Dimension(img.getWidth()+15, img.getHeight()+15));
	}

	/**
	 * Initialise la JFrame.
	 */
	private void initialize() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		JPanel panel = new ImagePanel();
		panel.setSize(new Dimension(img.getWidth()+5, img.getHeight()+5));
		c.add(panel);
	}

	/**
	 * Conteneur de l'image
	 */
	class ImagePanel extends JPanel {
		private BufferedImage pimg;

		/**
		 * Constructeur initialisant le JPanel.
		 */
		public ImagePanel() {
			super();
			this.initialize();
		}

		/**
		 * Initialise le JPanel avec l'image.
		 */
		private void initialize() {
			pimg = new BufferedImage(img.getWidth(), img.getHeight(), 
				BufferedImage.TYPE_INT_ARGB);

			for (int y = 0; y < img.getHeight(); y++) {
				for (int x = 0; x < img.getWidth(); x++) {
					pimg.setRGB(x, y, img.colorAt(x, y).getRGB());
				}
			}
			repaint();
		}

		/**
		 * Dessine l'image dans le panel, appelé régulièrement par la JFrame
		 * automatiquement.
		 *
		 * @param      g     Graphics sur lequel on travaille
		 */
		public void paint(Graphics g) {
			g.drawImage(pimg, 0, 0, null);
		}
	}
}