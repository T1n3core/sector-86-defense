package io.github.T1n3core.entities;

import io.github.T1n3core.game.GameState;

/**
 * Denotes that the implementing class can move.
 */
interface Moves {
	/**
	 * Moves an entity.
	 * Should be called from an update method, not by itself.
	 * The implementation of move should depend entirely on internal entity state
	 * deciding movement direction, distance, etc.
	 */
	void move(GameState state);
}
