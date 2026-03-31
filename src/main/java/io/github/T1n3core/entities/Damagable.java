package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;

/**
 * Denotes that the implementing class must take multiple hits before dying.
 */
interface Damagable {
	/**
	 * This method should be called instead of
	 * {@linkplain io.github.T1n3core.game.GameState#kill(Entity) kill} for entities
	 * that take multiple hits to kill.
	 */
	void damage(GameState state);
}
