package GameDev.Entities;

import GameDev.GameStates.Playing;

public interface EnemyFactory
{
	Enemy createHyena(int x, int y, Playing playing);
	Enemy createSkeleton(int x, int y, Playing playing);
	Enemy createMummy(int x, int y, Playing playing);
	Enemy createUndead(int x, int y, Playing playing);
	Enemy createCentipede(int x, int y, Playing playing);
	Enemy createBloated(int x, int y, Playing playing);
}
