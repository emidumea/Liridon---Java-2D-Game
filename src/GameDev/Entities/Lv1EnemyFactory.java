package GameDev.Entities;

import GameDev.GameStates.Playing;

public class Lv1EnemyFactory implements EnemyFactory
{
	public Enemy createHyena(int x, int y, Playing playing) {
		return new Hyena(x, y, playing);
	}

	public Enemy createSkeleton(int x, int y, Playing playing) {
		return new Skeleton(x, y, playing);
	}

	public Enemy createMummy(int x, int y, Playing playing) {
		return new Mummy(x, y, playing);
	}

	public Enemy createUndead(int x, int y, Playing playing) {
		return new Undead(x, y, playing);
	}

	public Enemy createCentipede(int x, int y, Playing playing) {
		return new Centipede(x, y, playing);
	}

	public Enemy createBloated(int x, int y, Playing playing) {
		return new Bloated(x, y, playing);
	}
}
