package io.github.T1n3core.game;

/**
 * Wrapper for all needed inputs for the program.
 */
public class Input {
	private final boolean[] keys;
	private final boolean[] mouse;
	private int mouseX;
	private int mouseY;

	public Input() {
		keys = new boolean[256];
		mouse = new boolean[4];
		setMousePosition(0, 0);
	}

	public void setKey(int keyCode, boolean pressed) {
		keys[keyCode] = pressed;
	}

	public void setMouse(int button, boolean pressed) {
		mouse[button] = pressed;
	}

	public void setMousePosition(int x, int y) {
		mouseX = x;
		mouseY = y;
	}

	public boolean getKey(int keyCode) {
		return keys[keyCode];
	}

	public boolean getMouse(int button) {
		return mouse[button];
	}

	public int getMouseX() {
		return mouseX;
	}

	public int getMouseY() {
		return mouseY;
	}
}
