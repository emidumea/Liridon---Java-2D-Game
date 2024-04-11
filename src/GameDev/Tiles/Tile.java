package GameDev.Tiles;

import java.awt.image.BufferedImage;

public class Tile
{
	public BufferedImage sprite;
	public boolean collision = false;

	public Tile(BufferedImage img)
	{
		this.sprite = img;
	}

	public BufferedImage getSprite()
	{
		return sprite;
	}
}
