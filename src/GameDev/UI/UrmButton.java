package GameDev.UI;

import GameDev.Graphics.ImageLoader;
import GameDev.Graphics.SpriteSheet;
import GameDev.LoadImageException;

import java.awt.*;
import java.awt.image.BufferedImage;
import static GameDev.Utils.Constants.UI.URMButtons.*;

public class UrmButton extends PauseButton
{
	private BufferedImage[] imgs;
	private int rowIndex, index;
	private boolean mouseOver, mousePressed;

	public UrmButton(int x, int y, int width, int height, int rowIndex) throws LoadImageException {
		super(x, y, width, height);
		this.rowIndex = rowIndex;
		loadImgs();
	}

	private void loadImgs() throws LoadImageException {
		SpriteSheet temp = new SpriteSheet(ImageLoader.LoadImage("/ui/urm_buttons.png"));
		imgs = new BufferedImage[3];

		for (int i = 0; i < imgs.length; i++)
		{
			imgs[i] = temp.crop(i * URM_DEFAULT_SIZE, rowIndex * URM_DEFAULT_SIZE, URM_DEFAULT_SIZE, URM_DEFAULT_SIZE);
		}
	}

	public void update()
	{
		index = 0;
		if (mouseOver)
			index = 1;
		if (mousePressed)
			index = 2;

	}

	public void draw(Graphics g)
	{
		g.drawImage(imgs[index], x, y, URM_SIZE, URM_SIZE, null);
	}

	public void resetBools()
	{
		mouseOver = false;
		mousePressed = false;
	}

	public boolean isMousePressed() {
		return mousePressed;
	}

	public void setMousePressed(boolean mousePressed) {
		this.mousePressed = mousePressed;
	}

	public boolean isMouseOver() {
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver) {
		this.mouseOver = mouseOver;
	}
}
