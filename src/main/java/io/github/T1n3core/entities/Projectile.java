package io.github.T1n3core.entities;

import java.awt.image.BufferedImage;
import io.github.T1n3core.game.GameState;
import io.github.T1n3core.main.MainFrame;
import io.github.T1n3core.main.ResourceCache;

/**
 * Projectile that flies in a set direction.
 * This class is used for both friendly and enemy projectiles, with
 * {@linkplain Team} to distinguish between them.
 */
public class Projectile extends Entity implements Moves {
	private static final double SPEED = 5.0;
	private final double stepX;
	private final double stepY;
	private double preciseX;
	private double preciseY;

	/**
	 * Constructs a projectile moving towards a point.
	 *
	 * @param x    the x coordinate of the Projectile
	 * @param y    the y coordinate of the Projectile
	 * @param dx   the x coordinate of the target
	 * @param dy   the y coordinate of the target
	 * @param team the team this Projectile belongs to
	 *
	 * @throws IllegalArgumentException if passed an invalid team
	 */
	public Projectile(int x, int y, int dx, int dy, Team team) {
		BufferedImage sprite = switch (team) {
			case Team.FRIENDLY -> ResourceCache.PLAYER_PROJECTILE;
			case Team.ENEMY -> ResourceCache.SHOOTER_PROJECTILE;
			default -> throw new IllegalArgumentException("Projectile team must be either friendly or neutral");
		};
		super(x, y, sprite, team);

		preciseX = (double) x;
		preciseY = (double) y;

		double dirX = dx - x;
		double dirY = dy - y;
		double len = Math.sqrt(dirX * dirX + dirY * dirY);

		stepX = dirX / len * SPEED;
		stepY = dirY / len * SPEED;
	}

	@Override
	public void move(GameState state) {
		preciseX += stepX;
		preciseY += stepY;
		setX((int) Math.round(preciseX));
		setY((int) Math.round(preciseY));
	}

	@Override
	protected void doUpdate(GameState state) {
		if (getX() < 0 || getX() > MainFrame.SCREEN_WIDTH || getY() < 0 || getY() > MainFrame.SCREEN_HEIGHT)
			state.kill(this);
	}
}
