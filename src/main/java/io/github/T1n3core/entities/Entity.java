package io.github.T1n3core.entities;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import io.github.T1n3core.game.Input;
import io.github.T1n3core.game.GameState;

/**
 * Base superclass for all entities in the game.
 * Can not be instantiated by itself, must be subclassed.
 * Only defines the rules each subclass must follow, use additional interfaces
 * for unique behaviour.
 */
public abstract class Entity {
	private final Team team;
	private final BufferedImage sprite;
	private final Rectangle hitbox;
	private int x;
	private int y;

	/**
	 * Main constructor for Entity, protected as it is not meant to be instantiated
	 * by itself, only subclassed.
	 *
	 * @param x      the starting x coordinate
	 * @param y      the starting y coordinate
	 * @param width  width of the hitbox
	 * @param height height of the hitbox
	 * @param sprite image to draw
	 * @param team   the team to which this entity belongs
	 */
	protected Entity(int x, int y, int width, int height, BufferedImage sprite, Team team) {
		this.x = x;
		this.y = y;
		this.hitbox = new Rectangle(x, y, width, height);
		this.sprite = sprite;
		this.team = team;
	}

	/**
	 * Shorthand constructor that infers hitbox dimensions from the sprite.
	 *
	 * @param x      the starting x coordinate
	 * @param y      the starting y coordinate
	 * @param sprite image to draw and infer hitbox dimensions from
	 * @param team   the team to which this entity belongs
	 */
	protected Entity(int x, int y, BufferedImage sprite, Team team) {
		this.x = x;
		this.y = y;
		this.hitbox = new Rectangle(x, y, sprite.getWidth(), sprite.getHeight());
		this.sprite = sprite;
		this.team = team;
	}

	/**
	 * This method should define what each entity does every frame update.
	 *
	 * @param state game state that includes data entities need to update
	 * @param in    inputs to process if the entity is capable of doing that
	 */
	public final void update(GameState state, Input in) {
		if (this instanceof Controllable c) {
			c.processInput(in);
		}

		if (this instanceof Moves m) {
			m.move(state);
		}

		if (this instanceof Shoots s) {
			s.shoot(state);
		}

		if (this instanceof Parries p) {
			p.parry();
		}

		doUpdate(state);
	}

	/**
	 * Extension of {@linkplain #update(GameState, Input) update} that defines
	 * entity specific behaviour.
	 *
	 * @param state game state that includes data entities need to update
	 */
	protected abstract void doUpdate(GameState state);

	/**
	 * Getter for x.
	 *
	 * @return x coordinate of the entity
	 */
	public int getX() {
		return x;
	}

	/**
	 * Getter for y.
	 *
	 * @return y coordinate of the entity
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter for hitbox.
	 *
	 * @return hitbox of the entity
	 */
	public Rectangle getHitbox() {
		return hitbox;
	}

	/**
	 * Getter for sprite.
	 *
	 * @return image belonging to the entity
	 */
	public BufferedImage getSprite() {
		return sprite;
	}

	/**
	 * Getter for team.
	 *
	 * @return team this entity belongs to
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Setter for x.
	 * Only ever to be called in
	 * {@linkplain io.github.T1n3core.entities.Moves#move(GameState) move}, never by
	 * itself.
	 *
	 * @param x the new x coordinate
	 */
	protected void setX(int x) {
		this.x = x;
	}

	/**
	 * Setter for y.
	 * Only ever to be called in
	 * {@linkplain io.github.T1n3core.entities.Moves#move(GameState) move}, never by
	 * itself.
	 *
	 * @param y the new y coordinate
	 */
	protected void setY(int y) {
		this.y = y;
	}
}
