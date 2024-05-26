package GameDev.Objects;

import GameDev.GameStates.Playing;
import GameDev.Graphics.ImageLoader;
import GameDev.Graphics.SpriteSheet;
import GameDev.Tiles.Level;
import GameDev.Utils.Constants;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GameDev.Utils.Constants.ObjectConstants.*;

public class ObjectManager
{
	private Playing playing;
	private BufferedImage[][] coinImgs;
	private BufferedImage[] heartImgs;
	private BufferedImage[] LiridonImgs;
	private ArrayList<Coin> coins;
	private ArrayList <Heart> hearts;
	public ObjectManager(Playing playing)
	{
		this.playing = playing;
		loadImgs();
		coins = new ArrayList<>();
		hearts = new ArrayList<>();

	}
	public void checkHeartTouched(Rectangle2D.Float hitbox)
	{
		for (Heart h : hearts)
		{
			if (h.isActive())
			{
				if (hitbox.intersects(h.getHitbox()))
				{
					h.setActive(false);
					applyEffectToPlayer(h);

				}
			}
		}
	}

	public void applyEffectToPlayer(Heart h)
	{
		if (h.getObjType() == HEART)
		{
			playing.getPlayer().changeHealth(HEART_VALUE);
		}

	}

	public void checkCoinTouched(Rectangle2D.Float hitbox)
	{
		for (Coin c : coins)
		{
			if (c.isActive())
			{
				if (hitbox.intersects(c.getHitbox()))
				{
					c.setActive(false);
					int scoreToAdd = (c.getObjType() == SLIVER_COIN) ? 30 : 50;
					playing.increaseScore(scoreToAdd);
				}
			}
		}
	}

	public void initObjects(Level level) {
		coins.clear();
		hearts.clear();

		if (level.getPath().equals("/maps/map1.txt"))
		{
			coins.add(new Coin(200, 500, 0));
			coins.add(new Coin(350, 500, 1));
			coins.add(new Coin(500, 500, 0));
			coins.add(new Coin(650, 500, 1));
			coins.add(new Coin(800, 500, 0));
			coins.add(new Coin(950, 500, 1));


			coins.add(new Coin(550, 270, 1));
			coins.add(new Coin(50, 360, 0));
			coins.add(new Coin(20, 360, 0));

			coins.add(new Coin(870, 270, 0));
			coins.add(new Coin(920, 270, 0));
			coins.add(new Coin(970, 270, 0));
			coins.add(new Coin(1020, 270, 0));
			coins.add(new Coin(1070, 270, 0));
			coins.add(new Coin(1120, 270, 0));

			coins.add(new Coin(1200, 70, 1));
			coins.add(new Coin(1250, 70, 1));
			coins.add(new Coin(1350, 70, 1));
			coins.add(new Coin(1400, 70, 1));

			coins.add(new Coin(1850, 500, 1));
			coins.add(new Coin(1950, 500, 1));
			coins.add(new Coin(2050, 500, 1));
			coins.add(new Coin(2150, 500, 1));
			coins.add(new Coin(2250, 500, 1));
			coins.add(new Coin(2350, 500, 1));

			coins.add(new Coin(2000, 270, 0));
			coins.add(new Coin(2100, 270, 0));
			coins.add(new Coin(2200, 270, 0));


			hearts.add(new Heart(250, 260, HEART));
			//hearts.add(new Heart(500, 450, HEART));
			hearts.add(new Heart(1740, 310, HEART));
			hearts.add(new Heart(1300, 60, HEART));
			hearts.add(new Heart(2270, 60, HEART));
		}
		else if (level.getPath().equals("/maps/map2.txt"))
		{
			coins.add(new Coin(100, 170, 1));
			coins.add(new Coin(100, 200, 0));
			coins.add(new Coin(100, 230, 1));
			coins.add(new Coin(100, 260, 0));
			coins.add(new Coin(100, 290, 0));

			coins.add(new Coin(400, 350, 0));
			coins.add(new Coin(500, 350, 1));

			coins.add(new Coin(350, 130, 0));
			coins.add(new Coin(450, 130, 0));
			coins.add(new Coin(350, 80, 1));
			coins.add(new Coin(450, 80, 1));

			coins.add(new Coin(700, 500, 0));
			coins.add(new Coin(750, 500, 1));
			coins.add(new Coin(800, 500, 0));
			coins.add(new Coin(850, 500, 1));
			coins.add(new Coin(900, 500, 0));
			coins.add(new Coin(950, 500, 1));
			coins.add(new Coin(1000, 500, 0));

			coins.add(new Coin(1350, 120, 0));
			coins.add(new Coin(1400, 120, 0));
			coins.add(new Coin(1450, 120, 0));
			coins.add(new Coin(1500, 120, 0));
			coins.add(new Coin(1550, 120, 0));
			coins.add(new Coin(1600, 120, 0));
			coins.add(new Coin(1650, 120, 0));


			coins.add(new Coin(1770, 500, 1));
			coins.add(new Coin(1800, 480, 1));
			coins.add(new Coin(1820, 450, 1));
			coins.add(new Coin(1850, 430, 1));
			coins.add(new Coin(1870, 400, 1));
			coins.add(new Coin(1900, 380, 1));
			coins.add(new Coin(1920, 350, 1));

			coins.add(new Coin(1950, 350, 1));
			coins.add(new Coin(1980, 380, 1));
			coins.add(new Coin(2010, 410, 1));
			coins.add(new Coin(2040, 440, 1));
			coins.add(new Coin(2070, 470, 1));
			coins.add(new Coin(2100, 500, 1));


			coins.add(new Coin(2150, 500, 0));
			coins.add(new Coin(2350, 500, 0));
			coins.add(new Coin(2400, 500, 1));
			coins.add(new Coin(2500, 500, 0));
			coins.add(new Coin(2550, 500, 1));
			coins.add(new Coin(2600, 500, 1));
			coins.add(new Coin(2650, 500, 0));

			coins.add(new Coin(2600, 100,1));
			coins.add(new Coin(2700, 100, 1));
			coins.add(new Coin(2800, 100, 1));

			hearts.add(new Heart(600, 300, HEART));
			hearts.add(new Heart(390, 70, HEART));
			hearts.add(new Heart(600, 300, HEART));
			hearts.add(new Heart(700, 300, HEART));
			hearts.add(new Heart(1200, 330, HEART));
			hearts.add(new Heart(1200, 150, HEART));
			hearts.add(new Heart(2500, 150, HEART));
		}
		else if (level.getPath().equals("/maps/map3.txt"))
		{
			coins.add(new Coin(5, 100, 0));
			coins.add(new Coin(5, 60, 1));
			coins.add(new Coin(100, 100, 0));
			coins.add(new Coin(100, 60, 1));



			coins.add(new Coin(400, 210, 1));
			coins.add(new Coin(450, 210, 1));
			coins.add(new Coin(500, 210, 1));
			coins.add(new Coin(550, 210, 1));

			coins.add(new Coin(870, 545, 0));
			coins.add(new Coin(940, 545, 0));
			coins.add(new Coin(1010, 545, 0));
			coins.add(new Coin(1080, 545, 0));
			coins.add(new Coin(1150, 545, 1));
			coins.add(new Coin(1220, 545, 0));
			coins.add(new Coin(1290, 545, 0));
			coins.add(new Coin(1360, 545, 0));
			coins.add(new Coin(1430, 545, 1));


			coins.add(new Coin(940, 245, 0));
			coins.add(new Coin(1010, 245, 0));
			coins.add(new Coin(1080, 245, 0));
			coins.add(new Coin(1150, 245, 0));

			coins.add(new Coin(1500, 25, 0));
			coins.add(new Coin(1570, 10, 0));
			coins.add(new Coin(1640, 10, 0));
			coins.add(new Coin(1710, 25, 0));


			coins.add(new Coin(1240, 320, 1));
			coins.add(new Coin(1240, 350, 1));
			coins.add(new Coin(1340, 320, 1));
			coins.add(new Coin(1340, 350, 1));

			coins.add(new Coin(1850, 545, 1));
			coins.add(new Coin(1950, 545, 1));

			coins.add(new Coin(2250, 545, 1));
			coins.add(new Coin(2350, 545, 1));

			coins.add(new Coin(2450, 5, 1));
			coins.add(new Coin(2500, 5, 1));
			coins.add(new Coin(2550, 5, 1));
			coins.add(new Coin(2600, 5, 1));

			coins.add(new Coin(2000, 280, 0));
			coins.add(new Coin(2050, 280, 0));
			coins.add(new Coin(2100, 280, 0));

			coins.add(new Coin(2650, 445, 0));
			coins.add(new Coin(2700, 445, 0));
			coins.add(new Coin(2750, 445, 0));
			coins.add(new Coin(2800, 445, 0));


			coins.add(new Coin(2030, 100, 0));
			coins.add(new Coin(2090, 100, 0));
			coins.add(new Coin(2150, 100, 0));
			coins.add(new Coin(2210, 100, 0));

			coins.add(new Coin(1275, 170, 0));
			coins.add(new Coin(1275, 130, 0));
			coins.add(new Coin(1275, 90, 0));
			coins.add(new Coin(1275, 50, 0));



			hearts.add(new Heart(45, 100, HEART));
			//hearts.add(new Heart(500, 450, HEART));

			hearts.add(new Heart(1270, 200, HEART));
			hearts.add(new Heart(1290, 350, HEART));

			hearts.add(new Heart(2270, 60, HEART));

			hearts.add(new Heart(2160, 340, HEART));

			hearts.add(new Heart(2460, 280, HEART));
		}
	}

	private void loadImgs()
	{
		SpriteSheet goldCoinSprites = new SpriteSheet(ImageLoader.LoadImage("/Objects/MonedaD.png"));
		SpriteSheet silverCoinSprites = new SpriteSheet(ImageLoader.LoadImage("/Objects/MonedaP.png"));
		SpriteSheet LiridonSprites = new SpriteSheet(ImageLoader.LoadImage("/Objects/Liridon.png"));
		coinImgs = new BufferedImage[2][5];

		for (int i = 0; i < coinImgs[0].length; i++)
		{
			coinImgs[0][i] = goldCoinSprites.crop(16 * i, 0, 16, 16);
			coinImgs[1][i] = silverCoinSprites.crop(16 * i, 0, 16, 16);
		}

		heartImgs = new BufferedImage[2];
		heartImgs[0] = ImageLoader.LoadImage("/Objects/Heart1.png");
		heartImgs[1] = ImageLoader.LoadImage("/Objects/Heart2.png");

		LiridonImgs = new BufferedImage[4];
		for (int i = 0; i < 4; i++)
		{
			LiridonImgs[i] = LiridonSprites.crop(32 * i, 0, 32, 32);
		}

	}
	public void update()
	{
		for (Coin c : coins)
		{
			if (c.isActive())
			{
				c.update();
			}
		}
		for (Heart h : hearts)
		{
			if (h.isActive())
			{
				h.update();
			}
		}
	}

	public void draw (Graphics g)
	{
		drawCoins(g);
		drawHearts(g);
	}

	private void drawCoins(Graphics g)
	{
		for (Coin c : coins)
		{
			int screenX = (int) (c.getHitbox().x - playing.getPlayer().getHitboxX() + playing.getPlayer().screenX);
			int screenY = (int) (c.getHitbox().y - playing.getPlayer().getHitboxY() + playing.getPlayer().screenY);

			if (c.isActive())
			{
				int type = 0;
				if (c.getObjType() == SLIVER_COIN)
				{
					type = 1;
				}
				g.drawImage(coinImgs[type][c.getAniIndex()], (int)(screenX - c.getxDrawOffset()), (int)(screenY- c.getyDrawOffset()), COIN_WIDTH, COIN_HEIGHT, null);

			}
		}
	}

	private void drawHearts(Graphics g)
	{
		for (Heart h : hearts)
		{
			int screenX = (int) (h.getHitbox().x - playing.getPlayer().getHitboxX() + playing.getPlayer().screenX);
			int screenY = (int) (h.getHitbox().y - playing.getPlayer().getHitboxY() + playing.getPlayer().screenY);
			if (h.isActive())
			{
				g.drawImage(heartImgs[h.getAniIndex()], (int)(screenX - h.getxDrawOffset()), (int)(screenY - h.getyDrawOffset()), HEART_WIDTH, HEART_HEIGHT, null);
			}
		}
	}



	public void resetAllObjects()
	{
		for (Coin c : coins)
		{
			c.reset();
		}
		for (Heart h : hearts)
		{
			h.reset();
		}
	}
	public ArrayList<GameObject> getObjects() {
		ArrayList<GameObject> objects = new ArrayList<>();

		objects.addAll(coins);
		objects.addAll(hearts);

		return objects;
	}
	public int getRemainingObjects()
	{
		int i = 0;
		for (Coin c : coins)
		{
			if (c.isActive())
			{
				i++;
			}
		}
		return i;
	}
}
