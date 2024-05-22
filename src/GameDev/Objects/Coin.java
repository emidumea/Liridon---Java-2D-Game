package GameDev.Objects;

import GameDev.Game;

public class Coin extends GameObject
{
	public Coin(int x, int y, int objType)
	{
		super(x, y, objType);
		doAnimation = true;
		initHitbox(16,16);
		xDrawOffset = (int) (1 * Game.SCALE);
		yDrawOffset = 0;
	}

	public void update()
	{
		updateAnimationTick();
	}
}
