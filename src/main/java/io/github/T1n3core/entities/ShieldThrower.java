package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.ResourceCache;

/**
 * ShieldThrower
 */
public class ShieldThrower extends Entity implements Moves, Shoots {
	public ShieldThrower(int x, int y) {
		super(x, y, ResourceCache.OBSTACLE_THROWER, Team.ENEMY);
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
}
