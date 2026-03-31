package io.github.T1n3core.main;

import java.awt.image.BufferedImage;

/**
 * This class stores resources the rest of the program uses.
 */
public final class ResourceCache {
	public static final BufferedImage BACKGROUND;
	public static final BufferedImage OBSTACLE;
	public static final BufferedImage PLAYER;
	public static final BufferedImage BRAWLER;
	public static final BufferedImage SHOOTER;
	public static final BufferedImage OBSTACLE_THROWER;
	public static final BufferedImage PLAYER_PROJECTILE;
	public static final BufferedImage SHOOTER_PROJECTILE;

	static {

	} // images

	/**
	 * Private constructor to prevent instantiation.
	 */
	private ResourceCache() {
		throw new UnsupportedOperationException("Class is static and can not be instantiated");
	}
}
