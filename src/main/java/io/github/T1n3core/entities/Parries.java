package io.github.T1n3core.entities;

/**
 * Denotes that the implementing class can initiate a parry.
 */
public interface Parries {
	/**
	 * Makes an entity invincible for a short while.
	 * Should be called from an update method, never by itself.
	 * Implementation of parry is entity specific and does not have any standard
	 * defining how it should look.
	 */
	public void parry();
}
