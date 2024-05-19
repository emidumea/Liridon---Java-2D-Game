package GameDev.GameStates;

import GameDev.Game;
import GameDev.UI.MenuButton;

import java.awt.event.MouseEvent;

public class States
{
	protected Game game;
	public States(Game game)
	{
		this.game = game;
	}

	public boolean isIn(MouseEvent e, MenuButton mb)
	{
		return mb.getBounds().contains(e.getX(), e.getY());
	}

	public Game getGame()
	{
		return game;
	}
}
