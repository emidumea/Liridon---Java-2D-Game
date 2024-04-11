package GameDev.Input;

import GameDev.Game;

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
		//System.out.println("apas o tasta");
		keys[e.getKeyCode()] = true;
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				game.getPlayer().setUp(true);
				break;
			case KeyEvent.VK_A:
				game.getPlayer().setLeft(true);
				break;
			case KeyEvent.VK_S:
				game.getPlayer().setDown(true);
				break;
			case KeyEvent.VK_D:
				game.getPlayer().setRight(true);
				break;
			case KeyEvent.VK_R:
				game.getPlayer().setAttacking(true);
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	//	System.out.println("apas o tasta");
		keys[e.getKeyCode()] = false;
		switch (e.getKeyCode())
		{
			case KeyEvent.VK_W:
				game.getPlayer().setUp(false);
				break;
			case KeyEvent.VK_A:
				game.getPlayer().setLeft(false);
				break;
			case KeyEvent.VK_S:
				game.getPlayer().setDown(false);
				break;
			case KeyEvent.VK_D:
				game.getPlayer().setRight(false);
				break;
			case KeyEvent.VK_R:
				game.getPlayer().setAttacking(false);
				break;
		}
	}
}

