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

public class DrawImage extends JFrame {
	private Container c;
	private PPMImage img;

	public DrawImage(String path) 
	throws java.io.FileNotFoundException, java.io.IOException {
		super();
		img = new PPMImage(path);
		this.initialize();
		this.setVisible(true);
	}

	private void initialize() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		JPanel panel = new ImagePanel();
		panel.setPreferredSize(new Dimension(img.getWidth()+5, img.getHeight()+5));
		c.add(panel);
	}

	class ImagePanel extends JPanel {
		private BufferedImage pimg;

		public ImagePanel() {
			super();
			this.initialize();
		}

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

		public void paint(Graphics g) {
			g.drawImage(pimg, 0, 0, null);
		}
	}
}