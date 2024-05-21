package GameDev.Input;

import GameDev.Game;
import GameDev.GameStates.Gamestate;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInput implements KeyListener
{
	private Game game;

	public KeyboardInput(Game game)
	{
		this.game = game;
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

