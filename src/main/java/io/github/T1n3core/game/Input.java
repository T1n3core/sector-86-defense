package io.github.T1n3core.game;

/**
 * Wrapper for all needed inputs for the program.
 */
public class Input {
	private final boolean[] keys = new boolean[256];
	private final boolean[] mouse = new boolean[4];
	private int mouseX;
	private int mouseY;

	public void setKey(int keyCode, boolean pressed) {
		keys[keyCode] = pressed;
	}

	public void setMouse(int button, boolean pressed) {
		mouse[button] = pressed;
	}

	public boolean getKey(int keyCode) {
		return keys[keyCode];
	}

	public boolean getMouse(int button) {
		return mouse[button];
	}
}
