package GameDev.Entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity
{
	protected float x,y;
	protected int width, height;
	protected Rectangle2D.Float hitbox;
	protected Rectangle hb;
	public Entity(float x, float y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		initHb();
	}
	private void initHb()
	{
		hb = new Rectangle((int) x, (int) y, width, height);
	}
	protected void drawHb(Graphics g) // pt debug
	{
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	protected void updateHb()
	{
		hb.x = (int) x;
		hb.y = (int) y;
	}

	public Rectangle getHb()
	{
		return hb;
	}





	protected void drawHitbox(Graphics g)
	{
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	public void initHitbox(float x, float y, float width, float height)
	{
		hitbox = new Rectangle2D.Float( x,  y, width, height);
	}

//	public void updateHitbox()
//	{
//		hitbox.x = (int) x;
//		hitbox.y = (int) y;
//	}

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public abstract void tick();
	public abstract void render(Graphics g);
}
