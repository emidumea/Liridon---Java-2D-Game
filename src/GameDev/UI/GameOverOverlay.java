package GameDev.UI;

import GameDev.Game;
import GameDev.GameStates.Gamestate;
import GameDev.GameStates.Playing;

import java.awt.*;
import java.awt.event.KeyEvent;

public class GameOverOverlay
{
	private Playing playing;
	public GameOverOverlay(Playing playing)
	{
		this.playing = playing;
	}

	public void draw(Graphics g)
	{
		g.setColor(new Color(0, 0, 0, 200));
		g.fillRect(0,0, Game.GAME_WIDTH, Game.GAME_HEIGHT);

		g.setColor(Color.white);
		g.drawString("Game over", Game.GAME_WIDTH / 2, 150);
		g.drawString("Press ENTER to enter main menu",Game.GAME_WIDTH / 2, 300);
	}

	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			playing.resetAll();
			Gamestate.state = Gamestate.MENU;
		}
	}
}
