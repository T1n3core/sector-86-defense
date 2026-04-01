package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.ResourceCache;

/**
 * Basic melee only enemy.
 */
public class Brawler extends Entity implements Moves {
	public static final int MOVEMENT_SPEED = 3;
	private double preciseX;
	private double preciseY;

	public Brawler(int x, int y) {
		super(x, y, ResourceCache.BRAWLER, Team.ENEMY);
	}

	@Override
	public void move(GameState state) {
		// TODO Implement move

	}

	@Override
	protected void doUpdate(GameState state) {
		// TODO Implement doUpdate

	}
}
