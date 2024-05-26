	package GameDev.GameStates;

	import GameDev.Database.DatabaseManager;
	import GameDev.Entities.EnemyManager;
	import GameDev.Entities.Player;
	import GameDev.Game;
	import GameDev.GameWindow.GameWindow;
	import GameDev.Graphics.Assets;
	import GameDev.Input.KeyboardInput;
	import GameDev.Input.MouseInput;
	import GameDev.Objects.ObjectManager;
	import GameDev.Tiles.Tile;
	import GameDev.Tiles.TileManager;
	import GameDev.UI.GameOverOverlay;
	import GameDev.UI.LevelCompletedOverlay;
	import GameDev.UI.PauseOverlay;

	import javax.swing.plaf.nimbus.State;
	import javax.xml.crypto.Data;
	import java.awt.*;
	import java.awt.event.KeyEvent;
	import java.awt.event.MouseEvent;
	import java.awt.geom.Rectangle2D;
	import java.awt.image.BufferStrategy;
	import java.awt.image.BufferedImage;

	import static GameDev.Graphics.Assets.*;

	public class Playing extends States implements Statemethods
	{
		private Player player;
		private TileManager tileM;
		private EnemyManager enemyManager;
		private ObjectManager objectManager;
	//	private DatabaseManager databaseManager;
		private GameOverOverlay gameOverOverlay;
		private LevelCompletedOverlay levelCompletedOverlay;
		private PauseOverlay pauseOverlay;
		private boolean gameOver;
		private boolean lvlCompleted = false;
		private boolean paused = false;
		private boolean dataSaved = false;
		private int score;


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
			player = new Player(200,200, (int) (64 * Game.SCALE), (int) (40 * Game.SCALE), this);
			tileM = new TileManager(game);
			enemyManager = new EnemyManager(this);
			objectManager = new ObjectManager(this);
//			databaseManager = new DatabaseManager();
//			databaseManager.createDatabase();
			player.loadLvlData(tileM.getMapTile());
			//tileM.printMap();
			gameOverOverlay = new GameOverOverlay(this);
			pauseOverlay = new PauseOverlay(this);
			levelCompletedOverlay = new LevelCompletedOverlay(this);
			loadStartLevel();
		}

		public void loadNextLevel()
		{
			resetAll();
			tileM.loadNextLevel();
			dataSaved = false;
			//objectManager.resetAllObjects();
		}

		private void loadStartLevel()
		{
			resetScore();
			enemyManager.initArray(tileM.getCurrentLevel());
			objectManager.initObjects(tileM.getCurrentLevel());
		}

		@Override
		public void update()
		{
//			if (player.getHitboxY() >= 500)
//			{
//				gameOver = true;
//			}
			if (paused)
			{
				pauseOverlay.update();
			}
			else if (lvlCompleted)
			{
				if (!dataSaved)
				{
					DatabaseManager.saveCompletedLevelData(tileM.getLvlIndex(), score, player.getCurrentHealth(), objectManager.getRemainingObjects());
					dataSaved = true;
				}
				levelCompletedOverlay.update();
			}
			else if (gameOver)
			{
				gameOverOverlay.update();
			}
			else if (!gameOver)
			{
				objectManager.update();
				player.tick();
				enemyManager.update(tileM.getMapTile(), player);
			}

		}

		@Override
		public void draw(Graphics g)
		{
			drawBackground(g,tileM.getLvlIndex());
			tileM.draw(g);
			player.render(g);
			player.tick();
			enemyManager.draw(g);
			objectManager.draw(g);
			drawScore(g);

			if (!gameOver)
				enemyManager.update(tileM.getMapTile(), player);
//			if (gameOver)
//				gameOverOverlay.draw(g);

			if (paused)
			{
				pauseOverlay.draw(g);
			}
			else if (gameOver)
			{
				gameOverOverlay.draw(g);
			}
			else if (lvlCompleted)
			{
				levelCompletedOverlay.draw(g);
			}


		}

		private void drawScore(Graphics g)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.PLAIN, 32));
			g.drawString("Score: " + score, Game.GAME_WIDTH - 180, 30);
		}

		public void mouseDragged(MouseEvent e)
		{
			if (paused)
			{
				pauseOverlay.mouseDragged(e);
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouse clic");
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			if (!gameOver)
			{
				if (paused)
					pauseOverlay.mousePressed(e);
				else if (lvlCompleted)
					levelCompletedOverlay.mousePressed(e);
			}
			else
			{
				gameOverOverlay.mousePressed(e);
			}
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			if (!gameOver)
			{
				if (paused)
					pauseOverlay.mouseReleased(e);
				else if (lvlCompleted)
					levelCompletedOverlay.mouseReleased(e);
			}
			else
			{
				gameOverOverlay.mouseReleased(e);
			}
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			if (!gameOver)
			{
				if (paused)
					pauseOverlay.mouseMoved(e);
				else if (lvlCompleted)
					levelCompletedOverlay.mouseMoved(e);
			}
			else
			{
				gameOverOverlay.mouseMoved(e);
			}
		}


		@Override
		public void keyPressed(KeyEvent e)
		{
			if (gameOver)
			{
				gameOverOverlay.keyPressed(e);

			}
			else {
				switch (e.getKeyCode()) {
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
					case KeyEvent.VK_Q:
						player.powerAttack();
						break;
					case KeyEvent.VK_ESCAPE:
						paused = !paused;
						break;
					case KeyEvent.VK_O:
						DatabaseManager.clearTables();
						DatabaseManager.savePlayerData(player,score);
						DatabaseManager.saveEnemiesData(enemyManager);
						DatabaseManager.saveObjectsData(objectManager);
						DatabaseManager.saveLevelData(tileM.getLvlIndex());

				}
			}
		}


		@Override
		public void keyReleased(KeyEvent e)
		{
			if (!gameOver) {

				switch (e.getKeyCode()) {
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
		}
		public void resetAll()
		{
			gameOver = false;
			paused = false;
			lvlCompleted = false;
			dataSaved = false;
			resetScore();
			player.resetAll();
			enemyManager.resetAllEnemies();
			objectManager.resetAllObjects();
		}
		public void setGameOver(boolean gameOver)
		{
			this.gameOver = gameOver;
		}
		public void checkEnemyHit(Rectangle2D.Float attackBox)
		{
			enemyManager.checkEnemyHit(attackBox);
		}
		public void checkObjTouched(Rectangle2D.Float hitbox)
		{
			objectManager.checkHeartTouched(hitbox);
			objectManager.checkCoinTouched(hitbox);
		}
		private void drawBackground(Graphics g, int currentLevel)
		{

			switch (currentLevel) {
				case 0:
					drawBackgroundLevel1(g);
					break;
				case 1:
					drawBackgroundLevel2(g);
					break;
				case 2:
					drawBackgroundLevel3(g);
					break;
				default:
					break;
			}

		}
		private void drawBackgroundLevel1(Graphics g)
		{
			g.drawImage(sky, 0, 0, Game.GAME_WIDTH, Game.GAME_HEIGHT, null);
			// ----------------------------------------------------------------------------------------------------------------------
			int cloudY = (int) (200 * Game.SCALE); // inaltimea la care vor fi pusi norii
			for (int i = 0; i < 3; i++)
			{
				g.drawImage(clouds, i * clouds.getWidth(), cloudY, clouds.getWidth(), clouds.getHeight(), null);
			}
			// ----------------------------------------------------------------------------------------------------------------------
			int seaY = cloudY + clouds.getHeight(); // y pt mare va fi sub nori
			g.drawImage(sea, 0, seaY, Game.GAME_WIDTH, Game.GAME_HEIGHT - seaY, null);
			// ----------------------------------------------------------------------------------------------------------------------
			int farGroundsY = Game.GAME_HEIGHT - grounds.getHeight(); // Y-ul elementelor de pe fundal va fi josul ferestrei de joc
			for (int i = 0; i < 3; i++)
			{
				g.drawImage(grounds, i * grounds.getWidth(), farGroundsY, grounds.getWidth(), grounds.getHeight(), null);
			}
		}
		private void drawBackgroundLevel2(Graphics g)
		{
			// Desenează fundalul desert_sky
			for (int i = 0; i < 10; i++)
			{
				g.drawImage(desert_sky, i * desert_sky.getWidth(), 0 ,desert_sky.getWidth(), Game.GAME_HEIGHT, null);
			}

			// Așază bg_sun la jumătatea de jos a ecranului
			int sunHeight = bg_sun.getHeight();
			int sunY = (int) (Game.GAME_HEIGHT * 0.45);
			g.drawImage(bg_sun, (Game.GAME_WIDTH - bg_sun.getWidth()) / 2, sunY, bg_sun.getWidth(), bg_sun.getHeight(), null);
			int duneY = sunY + (int)(bg_sun.getHeight() * 0.60);
			for (int i = 0; i < 10; i++)
			{
				g.drawImage(bg_ground, i * bg_ground.getWidth(), duneY, bg_ground.getWidth(),(int)(Game.GAME_HEIGHT / 1.5),null );
			}
//			for (int i = 0; i < 2; i++)
//			{
//				g.drawImage(dunes8, i * dunes8.getWidth(), duneY, dunes8.getWidth(), dunes8.getHeight()*2 , null);
//			}
			duneY += dunes8.getHeight()* 2;
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes7, i * dunes7.getWidth(), duneY, dunes7.getWidth(), dunes7.getHeight()*2, null);
			}
			duneY += dunes7.getHeight()*2;
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes6, i * dunes6.getWidth(), duneY, dunes6.getWidth(), dunes6.getHeight()* 2, null);
			}
			duneY += dunes6.getHeight()*2;
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes5, i * dunes5.getWidth(), duneY, dunes5.getWidth(), dunes5.getHeight()* 2, null);
			}
			duneY += (int)(dunes5.getHeight()* 1.5);

			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes4, i * dunes4.getWidth(), duneY, dunes4.getWidth(), dunes4.getHeight()*2, null);
			}
			duneY += dunes4.getHeight();
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes3, i * dunes3.getWidth(), duneY, dunes3.getWidth(), dunes3.getHeight()*2, null);
			}
			duneY += dunes3.getHeight();
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes2, i * dunes2.getWidth(), duneY, dunes2.getWidth(), dunes2.getHeight()*2, null);
			}
			duneY += dunes2.getHeight();
			for (int i = 0; i < 2; i++)
			{
				g.drawImage(dunes1, i * dunes1.getWidth(), duneY, dunes1.getWidth(), dunes1.getHeight()*3, null);
			}
			duneY += dunes1.getHeight();


		}

		private void drawBackgroundLevel3(Graphics g)
		{
			g.drawImage(bg3, 0,0, bg3.getWidth(), Game.GAME_HEIGHT,null);
			g.drawImage(bg2, 0,0, bg2.getWidth(), Game.GAME_HEIGHT,null);
			g.drawImage(bg1, 0,0,(int) (bg2.getWidth() * 1.2), Game.GAME_HEIGHT, null);

		}
		public void unpauseGame()
		{
			paused = false;
		}

		public EnemyManager getEnemyManager()
		{
			return enemyManager;
		}

		public void setLevelCompleted(boolean levelCompleted)
		{
			this.lvlCompleted = levelCompleted;
		}

		public ObjectManager getObjectManager()
		{
			return objectManager;
		}

		public void increaseScore(int amount) {
			score += amount;
		}

		public void resetScore() {
			score = 0;
		}

		public TileManager getTileM() {
			return tileM;
		}
	}
