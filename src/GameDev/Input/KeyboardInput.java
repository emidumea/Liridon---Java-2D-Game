package GameDev.Input;

import GameDev.Game;
import GameDev.GameStates.Gamestate;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener
{
	private Game game;
	private boolean[] keys;

	private boolean left;
	private boolean right;
	private boolean up;
	private boolean esc;
	private boolean one;
	private boolean two;
	private boolean attack;

	public KeyboardInput(Game game)
	{
		this.game = game;
		keys = new boolean[256];
		left = false;
		right = false;
		up = false;
		esc = false;
		one = false;
		two = false;
	}

	public void updateKeyboardInput()
	{
		esc = keys[KeyEvent.VK_ESCAPE];
		one = keys[KeyEvent.VK_1];
		two = keys[KeyEvent.VK_2];
		up = keys[KeyEvent.VK_SPACE];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];
		attack = keys[KeyEvent.VK_R];
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		switch (Gamestate.state)
		{
			case MENU:
				game.getMenu().keyPressed(e);
				break;
			case PLAYING:
				game.getPlaying().keyPressed(e);
				break;
			default:
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		switch (Gamestate.state)
		{
			case MENU:
				game.getMenu().keyReleased(e);
				break;
			case PLAYING:
				game.getPlaying().keyReleased(e);
				break;
			default:
				break;
		}
	}
}

