package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;

/**
 * Denotes that the implementing class can shoot.
 */
interface Shoots {
	/**
	 * Fires a proectile from an entity.
	 * Should be called from an update method, not by itself.
	 * The implementation of shoot should depend entirely on the internal entity
	 * state deciding proectile speed, direction, etc.
	 */
	void shoot(GameState state);
}
