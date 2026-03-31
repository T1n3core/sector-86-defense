package io.github.T1n3core.game;

import java.util.ArrayList;
import java.util.List;
import io.github.T1n3core.entities.Entity;

/**
 * GameState
 */
public class GameState {
	private final List<Entity> entities;
	private final List<Entity> spawnQueue;
	private final List<Entity> killQueue;

	public GameState() {
		entities = new ArrayList<>();
		spawnQueue = new ArrayList<>();
		killQueue = new ArrayList<>();
	}

	public List<Entity> getEntities() {
		return List.copyOf(entities);
	}

	public void spawn(Entity e) {
		spawnQueue.add(e);
	}

	public void kill(Entity e) {
		killQueue.add(e);
	}

	public void update(Input input) {
		for (Entity e : entities) {
			e.update(this, input);
		}

		for (Entity e : killQueue) {
			entities.remove(e);
		}

		for (Entity e : spawnQueue) {
			entities.add(e);
		}

		killQueue.clear();
		spawnQueue.clear();
	}
}
