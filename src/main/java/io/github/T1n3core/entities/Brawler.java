package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.ResourceCache;

/**
 * Basic melee only enemy.
 */
public class Brawler extends Entity implements Moves {
	public static final double MOVEMENT_SPEED = 3.0;
	private double preciseX;
	private double preciseY;

	public Brawler(int x, int y) {
		super(x, y, ResourceCache.BRAWLER, Team.ENEMY);
		preciseX = x;
		preciseY = y;
	}

	@Override
	public void move(GameState state) {
		Player p = state.getPlayer();
		double dx = p.getX() - preciseX;
		double dy = p.getY() - preciseY;
		double len = Math.sqrt(dx * dx + dy * dy);
		preciseX += dx / len * MOVEMENT_SPEED;
		preciseY += dy / len * MOVEMENT_SPEED;
		setX((int) Math.round(preciseX));
		setY((int) Math.round(preciseY));
	}

	@Override
	protected void doUpdate(GameState state) {
		// TODO Implement doUpdate
	}
}
