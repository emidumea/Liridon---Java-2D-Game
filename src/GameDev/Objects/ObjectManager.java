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
	private ArrayList<Coin> coins;
	private ArrayList <Heart> hearts;
	public ObjectManager(Playing playing)
	{
		this.playing = playing;
		loadImgs();
		coins = new ArrayList<>();
		hearts = new ArrayList<>();

		coins.add(new Coin(300,300,0));
		coins.add(new Coin(400,400,1));

		hearts.add(new Heart(200,200,HEART));

	}
	public void checkObjectTouched(Rectangle2D.Float hitbox)
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

		if (level.getPath().equals("/maps/map1.txt")) {
			coins.add(new Coin(200, 300, 0));
			coins.add(new Coin(400, 200, 1));

			hearts.add(new Heart(200, 200, HEART));
			hearts.add(new Heart(500, 450, HEART));
		}
		else if (level.getPath().equals("/maps/map2.txt"))
		{
			coins.add(new Coin(400, 300, 0));
			coins.add(new Coin(500, 300, 1));

			hearts.add(new Heart(600, 300, HEART));
			hearts.add(new Heart(700, 300, HEART));
		}
		else if (level.getPath().equals("/maps/map3.txt")) {
			coins.add(new Coin(300, 200, 0));
			coins.add(new Coin(300, 300, 1));

			hearts.add(new Heart(300, 400, HEART));
			hearts.add(new Heart(300, 500, HEART));
		}
	}

	private void loadImgs()
	{
		SpriteSheet goldCoinSprites = new SpriteSheet(ImageLoader.LoadImage("/Objects/MonedaD.png"));
		SpriteSheet silverCoinSprites = new SpriteSheet(ImageLoader.LoadImage("/Objects/MonedaP.png"));
		coinImgs = new BufferedImage[2][5];

		for (int i = 0; i < coinImgs[0].length; i++)
		{
			coinImgs[0][i] = goldCoinSprites.crop(16 * i, 0, 16, 16);
			coinImgs[1][i] = silverCoinSprites.crop(16 * i, 0, 16, 16);
		}

		heartImgs = new BufferedImage[2];
		heartImgs[0] = ImageLoader.LoadImage("/Objects/Heart1.png");
		heartImgs[1] = ImageLoader.LoadImage("/Objects/Heart2.png");

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
