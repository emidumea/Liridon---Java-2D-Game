	package GameDev.GameStates;

	import GameDev.Entities.EnemyManager;
	import GameDev.Entities.Player;
	import GameDev.Game;
	import GameDev.GameWindow.GameWindow;
	import GameDev.Graphics.Assets;
	import GameDev.Input.KeyboardInput;
	import GameDev.Input.MouseInput;
	import GameDev.Tiles.Tile;
	import GameDev.Tiles.TileManager;

	import javax.swing.plaf.nimbus.State;
	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.awt.event.MouseEvent;
	import java.awt.image.BufferStrategy;
	import java.awt.image.BufferedImage;

	import static GameDev.Graphics.Assets.*;

	public class Playing extends States implements Statemethods
	{
		private Player player;
		private TileManager tileM;
		private EnemyManager enemyManager;
		private MouseInput mouseInput;
		private GameWindow      wnd;
		private BufferStrategy bs;
		private BufferedImage backgroundImg;
		public int xLvlOffset = 500;

		public Player getPlayer()
		{
			return player;
		}

		public Playing(Game game)
		{
			super(game);
			InitGame();
		}
		private void InitGame()
		{

			Assets.init();
			player = new Player(200,200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE));
			tileM = new TileManager(game);
			enemyManager = new EnemyManager(this);
			player.loadLvlData(tileM.getMapTile());
			tileM.printMap();
		}

		@Override
		public void update() {
			player.tick();
			enemyManager.update(tileM.getMapTile());
		}

		@Override
		public void draw(Graphics g)
		{

			//g.drawImage(sky, 0, 0, Game.GAME_WIDTH,Game.GAME_HEIGHT,null );
			//drawClouds(g);
			drawBackground(g);
			//g.drawImage(Assets.background1[2],0,0, Assets.background1[2].getWidth(),Assets.background1[2].getHeight(),null );
			tileM.draw(g);
			player.render(g);
			player.tick();
			enemyManager.draw(g);
			enemyManager.update(tileM.getMapTile());

		}

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouse clic");
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseMoved(MouseEvent e) {

		}

		@Override
		public void keyPressed(KeyEvent e)
		{
			//keys[e.getKeyCode()] = true;
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_A:
					player.setLeft(true);
					break;
				case KeyEvent.VK_S:
					player.setDown(true);
					break;
				case KeyEvent.VK_D:
					player.setRight(true);
					break;
				case KeyEvent.VK_R:
					player.setAttacking(true);
					break;
				case KeyEvent.VK_W:
					player.setJump(true);
					break;
				case KeyEvent.VK_ESCAPE:
					Gamestate.state = Gamestate. MENU;
					break;
			}
		}


		@Override
		public void keyReleased(KeyEvent e)
		{
			//keys[e.getKeyCode()] = true;
			switch (e.getKeyCode())
			{
				case KeyEvent.VK_A:
					player.setLeft(false);
					break;
				case KeyEvent.VK_S:
					player.setDown(false);
					break;
				case KeyEvent.VK_D:
					player.setRight(false);
					break;
				case KeyEvent.VK_R:
					player.setAttacking(false);
					break;
				case KeyEvent.VK_W:
					player.setJump(false);
					break;
			}
		}

		private void drawClouds(Graphics g)
		{
			for (int i = 0; i < 3; i++) {
				g.drawImage(clouds,  i * clouds.getWidth(), (int) (204 * Game.SCALE), clouds.getWidth(), clouds.getHeight(), null);
			}
		}

		private void drawBackground(Graphics g)
		{
			g.drawImage(sky, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
			// ----------------------------------------------------------------------------------------------------------------------
			int cloudY = (int) (200 * Game.SCALE); // inaltimea la care vor fi pusi norii
			for (int i = 0; i < 3; i++)
			{
				g.drawImage(clouds, i * clouds.getWidth(), cloudY, clouds.getWidth(), clouds.getHeight(), null);
			}
			// ----------------------------------------------------------------------------------------------------------------------
			int seaY = cloudY + clouds.getHeight(); // y pt mare va si sub nori
			g.drawImage(sea, 0, seaY, Game.GAME_WIDTH, Game.GAME_HEIGHT - seaY, null);
			// ----------------------------------------------------------------------------------------------------------------------
			int farGroundsY = Game.GAME_HEIGHT - grounds.getHeight(); // Y-ul elementelor de pe fundal va fi josul ferestrei de joc
			for (int i = 0; i < 3; i++)
			{
				g.drawImage(grounds, i * grounds.getWidth(), farGroundsY, grounds.getWidth(), grounds.getHeight(), null);
			}
		}
	}
