package io.github.T1n3core.entities;

import io.github.T1n3core.game.Input;

/**
 * Denotes that the implementing class can be controlled via input.
 */
interface Controllable {
	/**
	 * Processes an input for an entity.
	 * Should set state so that {@linkplain io.github.T1n3core.entities.Entity
	 * Entity} knows when to shoot or move
	 * for entities that are allowed to do so.
	 */
	void processInput(Input in);
}
