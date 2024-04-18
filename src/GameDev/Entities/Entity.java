package GameDev.Entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity
{
	protected float x,y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;

	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}
	protected void drawHitbox(Graphics g) // pt debug
	{
		g.drawRect((int) hitbox.x, (int) hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	protected void initHitbox(float x, float y, float width, float height)
	{
		hitbox = new Rectangle2D.Float( x, y, width, height);
	}

	public float getHitboxX()
	{
		return hitbox.x;
	}
	public float getHitboxY()
	{
		return hitbox.y;
	}
	public float getHitboxWidth()
	{
		return hitbox.width;
	}
	public float getHitboxHeight()
	{
		return hitbox.height;
	}
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public Rectangle2D.Float getHitbox()
	{
		return hitbox;
	}
	public abstract void tick();
	public abstract void render(Graphics g);
}