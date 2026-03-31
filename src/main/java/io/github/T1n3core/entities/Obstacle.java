package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.ResourceCache;

/**
 * Obstacle that gets in the way of projectiles.
 */
public class Obstacle extends Entity {
	/**
	 * Constructs an obstacle.
	 */
	public Obstacle(int x, int y) {
		super(x, y, ResourceCache.OBSTACLE, Team.NEUTRAL);
	}

	/**
	 * Obstacles have no per frame behaviour, they rely entirely on the collision
	 * detection system.
	 */
	@Override
	protected void doUpdate(GameState state) {
		// do nothing
	}
}
