package io.github.T1n3core.main;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

/**
 * Class for handling window work.
 */
public class MainFrame extends JFrame {
	/**
	 * Setup constructor, exists so main is not cluttered with window work.
	 */
	public MainFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setUndecorated(true);
		setResizable(false);

		GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		gd.setFullScreenWindow(this);

		setVisible(true);
	}
}
