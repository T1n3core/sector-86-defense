package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.ResourceCache;

/**
 * Tankier and slower version of {@linkplain io.github.T1n3core.entities.Brawler
 * Brawler}.
 */
public class Tank extends Entity implements Moves, Damagable {
	public static final int MOVEMENT_SPEED = 2;
	public static final int MAX_HP = 3;
	private int health;
	private double preciseX;
	private double preciseY;

	public Tank(int x, int y) {
		super(x, y, ResourceCache.TANK, Team.ENEMY);
		health = MAX_HP;
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
	public void damage(GameState state) {
		health--;
		if (health <= 0)
			state.kill(this);
	}

	@Override
	protected void doUpdate(GameState state) {
		// TODO Implement doUpdate
	}
}
