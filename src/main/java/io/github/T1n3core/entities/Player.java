package io.github.T1n3core.entities;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.game.Input;
import io.github.T1n3core.main.ResourceCache;

/**
 * Player character.
 */
public class Player extends Entity implements Moves, Shoots, Parries, Controllable, Damagable {
	public static final int MAX_HP = 5;
	public static final int FIRING_COOLDOWN = 10;
	public static final int INVINCIBILITY_DURATION = 3;
	public static final int INVINCIBILITY_COOLDOWN = 20;
	private int mouseX;
	private int mouseY;
	private int health;
	private int firingCooldown;
	private int invincibility;
	private int invincibilityCooldown;
	private boolean invincible;
	private boolean moveUp;
	private boolean moveDown;
	private boolean moveLeft;
	private boolean moveRight;
	private boolean shoot;
	private boolean parry;

	/**
	 * Constructs a Player.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Player(int x, int y) {
		super(x, y, ResourceCache.PLAYER, Team.FRIENDLY);
		health = MAX_HP;
		firingCooldown = 0;
		mouseX = 0;
		mouseY = 0;
		invincibility = INVINCIBILITY_DURATION;
		invincibilityCooldown = INVINCIBILITY_COOLDOWN;
		invincible = true;
		moveUp = false;
		moveDown = false;
		moveLeft = false;
		moveRight = false;
		shoot = false;
		parry = false;
	}

	@Override
	public void processInput(Input in) {
		if (in.getKey(KeyEvent.VK_W) || in.getKey(KeyEvent.VK_UP)) {
			moveUp = true;
		} else {
			moveUp = false;
		}

		if (in.getKey(KeyEvent.VK_S) || in.getKey(KeyEvent.VK_DOWN)) {
			moveDown = true;
		} else {
			moveDown = false;
		}

		if (in.getKey(KeyEvent.VK_A) || in.getKey(KeyEvent.VK_LEFT)) {
			moveLeft = true;
		} else {
			moveLeft = false;
		}

		if (in.getKey(KeyEvent.VK_D) || in.getKey(KeyEvent.VK_RIGHT)) {
			moveRight = true;
		} else {
			moveRight = false;
		}

		if (in.getMouse(MouseEvent.BUTTON1) || in.getKey(KeyEvent.VK_SPACE)) {
			shoot = true;
		} else {
			shoot = false;
		}

		if (in.getMouse(MouseEvent.BUTTON2) || in.getKey(KeyEvent.VK_SHIFT)) {
			parry = true;
		} else {
			parry = false;
		}

		mouseX = in.getMouseX();
		mouseY = in.getMouseY();
	}

	@Override
	public void damage(GameState state) {
		if (invincible)
			return;

		health--;

		if (health <= 0)
			state.kill(this);
	}

	@Override
	public void move(GameState state) {
		// TODO Implement move

	}

	@Override
	public void shoot(GameState state) {
		// TODO Implement shoot

	}

	@Override
	public void parry() {
		if (invincibilityCooldown > 0) {
			invincibilityCooldown--;
		}

		if (invincibility > 0) {
			invincibility--;
		} else {
			invincible = false;
		}

		if (invincibilityCooldown != 0)
			return;

		if (!parry)
			return;

		invincibility = INVINCIBILITY_DURATION;
		invincibilityCooldown = INVINCIBILITY_COOLDOWN;
		invincible = true;
	}

	@Override
	protected void doUpdate(GameState state) {
		// TODO Implement doUpdate

	}

	/**
	 * Getter for health.
	 *
	 * @return health of the player
	 */
	public int getHealth() {
		return health;
	}
}
