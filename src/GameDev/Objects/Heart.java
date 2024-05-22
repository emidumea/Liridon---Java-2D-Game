package GameDev.Objects;

import GameDev.Game;

public class Heart extends GameObject
{
	public Heart(int x, int y, int objType)
	{
		super(x, y, objType);
		this.aniSpeed = 25;
		initHitbox(32,32);

		xDrawOffset = (int) ( 3 * Game.SCALE);
		yDrawOffset = (int) (2 * Game.SCALE);

	}

	public void update()
	{
		updateAnimationTick();
	}
}
