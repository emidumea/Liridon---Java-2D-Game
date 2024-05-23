package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Tiles.Level;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import static GameDev.Utils.Constants.EnemyConstants.*;

public class EnemyManager
{
	private Playing playing;
	private ArrayList<Hyena> hyenas = new ArrayList<>();
	public EnemyManager(Playing playing)
	{

		this.playing = playing;
		//initArray();
	}
	public void update(int[][] lvlData, Player player)
	{
		boolean isAnyActive = false;
		for (Hyena it : hyenas)
		{
			if (it.isActive())
			{
				it.tick();
				it.update(lvlData, player);
				isAnyActive = true;
			}
		}
		if (!isAnyActive)
			playing.setLevelCompleted(true);
	}
//	public void initArray(Level level)
//	{
//	//	hyenas.add(new Hyena(600,200,playing));
//		hyenas.add(new Hyena(1200,100,playing));
////		hyenas.add(new Hyena(1950,100,playing));
////		hyenas.add(new Hyena(700,350,playing));
////		hyenas.add(new Hyena(2500,400,playing));
////		hyenas.add(new Hyena(2200,500,playing));
////		hyenas.add(new Hyena(2000,500,playing));
////		hyenas.add(new Hyena(900,150,playing));
//	}
	public void initArray(Level level) {
		hyenas.clear();  // Curăță lista existentă de inamici
		// Adaugă inamici specifici acestui nivel
		// Exemplu: Pentru simplitate, adăugăm poziții hardcoded
		if (level.getPath().equals("/maps/map1.txt")) {
			hyenas.add(new Hyena(600, 200, playing));
			hyenas.add(new Hyena(1200, 100, playing));
		} else if (level.getPath().equals("/maps/map2.txt")) {
			hyenas.add(new Hyena(1300, 150, playing));
			hyenas.add(new Hyena(1700, 300, playing));
		} else if (level.getPath().equals("/maps/map3.txt")) {
			hyenas.add(new Hyena(900, 250, playing));
			hyenas.add(new Hyena(1500, 400, playing));
		}
	}
	public void draw(Graphics g)
	{
		drawHyenas(g);
	}

	private void drawHyenas(Graphics g)
	{
		for (Hyena it : hyenas)
		{
			if (it.isActive())
			{
				it.render(g);
				//it.drawHitbox(g);
			}
		}

	}

	public void checkEnemyHit(Rectangle2D.Float attackBox)
	{
		for (Hyena it : hyenas)
		{
			if (it.isActive())
			{
				if (attackBox.intersects(it.getHitbox()))
				{
					it.hurt(10);
					return;
				}
			}
		}
	}

	public void resetAllEnemies()
	{
		for (Hyena it : hyenas)
			it.resetEnemy();
	}

	public ArrayList<Hyena> getHyenas() {
		return hyenas;
	}
}
