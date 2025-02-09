package GameDev.Objects;

import GameDev.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static GameDev.Utils.Constants.ObjectConstants.*;

public class GameObject
{
	protected int x, y, objType;
	protected Rectangle2D.Float hitbox;
	protected boolean doAnimation, active = true;
	protected int aniTick, aniIndex;
	protected int xDrawOffset, yDrawOffset;
	protected int aniSpeed = 5;

	public GameObject(int x, int y, int objType)
	{
		this.x = x;
		this.y = y;
		this.objType = objType;
	}

	protected void updateAnimationTick()
	{
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(objType)) {
				aniIndex = 0;
			}
		}
	}

	public void reset()
	{
		aniIndex = 0;
		aniTick = 0;
		active = true;

		//doAnimation = true;
	}
	protected void initHitbox(int width, int height)
	{
		hitbox = new Rectangle2D.Float(x, y, (int) (width * Game.SCALE), (int) (height * Game.SCALE));
	}

	public void drawHitbox(Graphics g) // pt debug
	{
		g.drawRect((int) hitbox.x, (int) hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}

	public int getObjType() {
		return objType;
	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setAnimation(boolean doAnimation) {
		this.doAnimation = doAnimation;
	}

	public int getxDrawOffset() {
		return xDrawOffset;
	}

	public int getyDrawOffset() {
		return yDrawOffset;
	}

	public int getAniIndex() {
		return aniIndex;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
