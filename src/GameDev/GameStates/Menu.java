package GameDev.GameStates;

import GameDev.Game;
import GameDev.Graphics.ImageLoader;
import GameDev.UI.MenuButton;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends States implements Statemethods
{

	private MenuButton[] buttons = new MenuButton[3];
	private BufferedImage backgroundImg = ImageLoader.LoadImage("/ui/backgroundMenu.png");
	private int menuX, menuY, menuWidth, menuHeight;
	public Menu(Game game)
	{
		super(game);
		loadButtons();
		loadBackground();
	}

	private void loadBackground()
	{
		menuWidth = (int) (backgroundImg.getWidth() * Game.SCALE);
		menuHeight = (int) (backgroundImg.getHeight() * Game.SCALE);
		menuX = Game.GAME_WIDTH / 2 - menuWidth / 2;
		menuY = (int) ( 45 * Game.SCALE);
	}

	private void loadButtons()
	{
		buttons[0] = new MenuButton(Game.GAME_WIDTH / 2, (int) (150 * Game.SCALE), 0, Gamestate.PLAYING);
		buttons[1] = new MenuButton(Game.GAME_WIDTH / 2, (int) (290 * Game.SCALE), 1 ,Gamestate.OPTIONS);
		buttons[2] = new MenuButton(Game.GAME_WIDTH / 2, (int) (430 * Game.SCALE), 2 ,Gamestate.QUIT);
	}

	@Override
	public void update()
	{
		for (MenuButton mb : buttons)
		{
			mb.update();
		}
	}

	@Override
	public void draw(Graphics g)
	{
		g.drawImage(backgroundImg, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
		for (MenuButton mb : buttons)
		{
			mb.draw(g);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		for (MenuButton mb : buttons)
		{
			if (isIn(e,mb))
			{
				mb.setMousePressed(true);
				break;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		for (MenuButton mb : buttons)
		{
			if (isIn(e,mb)) // vedem daca suntem pe buton
			{
				if (mb.isMousePressed())
				{
					mb.applyGamestate();
				}
				break;
			}
		}
		resetButtons();
	}

	private void resetButtons()
	{
		for (MenuButton mb : buttons)
		{
			mb.resetBools();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		for (MenuButton mb : buttons)
		{
			mb.setMouseOver(false);
		}
		for (MenuButton mb : buttons)
		{
			if (isIn(e,mb))
			{
				mb.setMouseOver(true);
				break;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			Gamestate.state = Gamestate.PLAYING;
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}
}
