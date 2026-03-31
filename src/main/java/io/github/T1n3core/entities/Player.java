package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.game.Input;
import io.github.T1n3core.main.ResourceCache;

/**
 * Player character.
 */
public class Player extends Entity implements Moves, Shoots, Controllable, Damagable {
	public static final int MAX_HP = 5;
	public static final int FIRING_COOLDOWN = 10;
	private int health;

	/**
	 * Constructs a Player.
	 *
	 * @param x the x coordinate
	 * @param y the y coordinate
	 */
	public Player(int x, int y) {
		super(x, y, ResourceCache.PLAYER, Team.FRIENDLY);
		health = MAX_HP;
	}

	@Override
	public void processInput(Input in) {
		// TODO Implement processInput

	}

	@Override
	public void damage(GameState state) {
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
