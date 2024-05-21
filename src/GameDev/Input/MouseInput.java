package GameDev.Input;


import GameDev.Game;
import GameDev.GameStates.Gamestate;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener
{
	private Game game;
	public MouseInput(Game game)
	{
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		switch (Gamestate.state)
		{
			case PLAYING:
				game.getPlaying().mouseClicked(e);
				break;
			default:
				break;
		}

	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		switch (Gamestate.state) {
			case MENU:
				game.getMenu().mousePressed(e);
				break;
			case PLAYING:
				game.getPlaying().mousePressed(e);
				break;
			default:
				break;

		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		switch (Gamestate.state) {
			case MENU:
				game.getMenu().mouseReleased(e);
				break;
			case PLAYING:
				game.getPlaying().mouseReleased(e);
				break;
			default:
				break;

		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		switch (Gamestate.state) {
			case PLAYING:
				game.getPlaying().mouseDragged(e);
				break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		switch (Gamestate.state)
		{
			case MENU:
				game.getMenu().mouseMoved(e);
				break;
			case PLAYING:
				game.getPlaying().mouseMoved(e);
				break;
			default:
				break;

		}
	}
}
