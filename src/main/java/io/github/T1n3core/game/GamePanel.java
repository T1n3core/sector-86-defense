package io.github.T1n3core.game;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

/**
 * GamePanel
 */
public class GamePanel extends JPanel implements Runnable {
	private Input input;

	public GamePanel() {
		// TODO Make this class
		setFocusable(true);
		SwingUtilities.invokeLater(this::requestFocusInWindow);
	}

	private void setupKeyBindings() {
		InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();

		bindKey(im, am, "W", KeyEvent.VK_W);
		bindKey(im, am, "S", KeyEvent.VK_S);
		bindKey(im, am, "A", KeyEvent.VK_A);
		bindKey(im, am, "D", KeyEvent.VK_D);
		bindKey(im, am, "up", KeyEvent.VK_UP);
		bindKey(im, am, "down", KeyEvent.VK_DOWN);
		bindKey(im, am, "left", KeyEvent.VK_LEFT);
		bindKey(im, am, "right", KeyEvent.VK_RIGHT);
	}

	private void bindKey(InputMap im, ActionMap am, String key, int keyCode) {
		im.put(KeyStroke.getKeyStroke("pressed " + key), key + "_down");
		im.put(KeyStroke.getKeyStroke("released " + key), key + "_up");

		am.put(key + "_down", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.set(keyCode, true);
			}
		});

		am.put(key + "_up", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				input.set(keyCode, false);
			}
		});
	}

	@Override
	public void run() {
		// TODO Game loop goes here
	}
}
