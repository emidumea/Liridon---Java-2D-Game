package GameDev.UI;

import GameDev.GameStates.Gamestate;
import GameDev.Graphics.ImageLoader;
import GameDev.LoadImageException;

import java.awt.*;
import java.awt.image.BufferedImage;

import static GameDev.Graphics.Assets.*;
import static GameDev.Utils.Constants.UI.Buttons.*;

public class MenuButton
{
	private int xPos, yPos, index, btnIndex;
	private int xOffsetCenter = B_WIDTH / 2;
	private Gamestate state;
	private boolean mouseOver, mousePressed;
	private Rectangle bounds;
	private BufferedImage[] imgs;

	public MenuButton(int xPos, int yPos, int btnIndex,Gamestate state) throws LoadImageException {
		this.xPos = xPos;
		this.yPos = yPos;
		this.state = state;
		this.btnIndex = btnIndex;
		loadImgs();
		initBounds();
	}

	private void loadImgs() throws LoadImageException {
		imgs = new BufferedImage[2];
		switch (btnIndex)
		{
			case 0:
				imgs[0] = ImageLoader.LoadImage("/ui/Play Button.png");
				imgs[1] = ImageLoader.LoadImage("/ui/Play col_Button.png");
				break;
			case 1:
				imgs[0] = ImageLoader.LoadImage("/ui/Options Button.png");
				imgs[1] = ImageLoader.LoadImage("/ui/Options  col_Button.png");
				break;
			case 2:
				imgs[0] = ImageLoader.LoadImage("/ui/Quit Button.png");
				imgs[1] = ImageLoader.LoadImage("/ui/Quit  col_Button.png");
				break;
			case 3:
				imgs[0] = ImageLoader.LoadImage("/ui/Load Button.png");
				imgs[1] = ImageLoader.LoadImage("/ui/Load  col_Button.png");
		}
	}

	private void initBounds()
	{
		bounds = new Rectangle(xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT);
	}

	public void draw(Graphics g)
	{
		g.drawImage(imgs[index], xPos - xOffsetCenter, yPos, B_WIDTH, B_HEIGHT, null);
	}
	public void update()
	{
		index = 0;
		if (mouseOver)
		{
			index = 1;
		}
		if (mousePressed)
		{
			index = 1;
		}
	}
	public boolean isMouseOver()
	{
		return mouseOver;
	}

	public void setMouseOver(boolean mouseOver)
	{
		this.mouseOver = mouseOver;
	}

	public void setMousePressed(boolean b)
	{
		mousePressed = b;
	}

	public boolean isMousePressed()
	{
		return mousePressed;
	}

	public Rectangle getBounds()
	{
		return bounds;
	}

	public void applyGamestate()
	{
		Gamestate.state = state;
	}

	public void resetBools()
	{
		mouseOver = false;
		mousePressed = false;
	}

}
