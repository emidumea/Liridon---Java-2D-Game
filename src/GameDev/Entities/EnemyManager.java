package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Tiles.Level;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.lang.reflect.Array;
import java.util.ArrayList;
import static GameDev.Utils.Constants.EnemyConstants.*;

public class EnemyManager
{
	private Playing playing;
	private ArrayList<Hyena> hyenas = new ArrayList<>();
	private ArrayList<Skeleton> skeletons = new ArrayList<>();
	private ArrayList<Mummy> mummies = new ArrayList<>();
	private ArrayList<Undead> undeads = new ArrayList<>();
	private ArrayList<Centipede> centipedes = new ArrayList<>();
	private ArrayList<Bloated> bloateds = new ArrayList<>();
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

		for (Skeleton it : skeletons)
		{
			if (it.isActive())
			{
				it.tick();
				it.update(lvlData, player);
				isAnyActive = true;
			}
		}

		for (Mummy it : mummies)
		{
			if (it.isActive())
			{
				it.tick();
				it.update(lvlData, player);
				isAnyActive = true;
			}

		}

		for (Undead it : undeads)
		{
			if (it.isActive())
			{
				it.tick();
				it.update(lvlData, player);
				isAnyActive = true;
			}

		}
		for (Centipede it : centipedes)
		{
			if (it.isActive())
			{
				it.tick();
				it.update(lvlData, player);
				isAnyActive = true;
			}

		}
		for (Bloated it : bloateds)
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
	public void initArray(Level level)
	{
		hyenas.clear();
		skeletons.clear();
		mummies.clear();
		undeads.clear();
		centipedes.clear();
		bloateds.clear();
		// Curăță lista existentă de inamici
		// Adaugă inamici specifici acestui nivel
		// Exemplu: Pentru simplitate, adăugăm poziții hardcoded
		if (level.getPath().equals("/maps/map1.txt")) {
			hyenas.add(new Hyena(600, 200, playing));
			hyenas.add(new Hyena(1100, 450, playing));
			hyenas.add(new Hyena(2700, 300, playing));
			hyenas.add(new Hyena(2300, 400, playing));
			hyenas.add(new Hyena(2150, 460, playing));
			hyenas.add(new Hyena(2500, 460, playing));
			skeletons.add(new Skeleton(800,465,playing));
			skeletons.add(new Skeleton(2000,200,playing));
			skeletons.add(new Skeleton(2500,150,playing));
			skeletons.add(new Skeleton(970,230,playing));
			//skeletons.add(new Skeleton(2500,150,playing));
			//mummies.add(new Mummy(500,465,playing));
			//undeads.add(new Undead(500,300,playing));
			//centipedes.add(new Centipede(400,300,playing));
			//bloateds.add(new Bloated(400,300,playing));
		}
		else if (level.getPath().equals("/maps/map2.txt"))
		{
			//hyenas.add(new Hyena(1300, 150, playing));
			//hyenas.add(new Hyena(1700, 300, playing));
			mummies.add(new Mummy(1350,50,playing));
			mummies.add(new Mummy(1650,50,playing));

			mummies.add(new Mummy(2550,40,playing));
			mummies.add(new Mummy(2000,50,playing));
			mummies.add(new Mummy(2850,400,playing));

			undeads.add(new Undead(500,250,playing));
			undeads.add(new Undead(900,200,playing));
			undeads.add(new Undead(1500,300,playing));

			undeads.add(new Undead(900,450,playing));
			undeads.add(new Undead(2750,50,playing));


		}
		else if (level.getPath().equals("/maps/map3.txt"))
		{
			bloateds.add(new Bloated(900,250,playing));
			bloateds.add(new Bloated(1500,50,playing));
			bloateds.add(new Bloated(2200,530,playing));
			bloateds.add(new Bloated(2750,50,playing));
			bloateds.add(new Bloated(2750,50,playing));

			centipedes.add(new Centipede(1300,530,playing));
			centipedes.add(new Centipede(1100,530,playing));
			centipedes.add(new Centipede(1800,530,playing));
			centipedes.add(new Centipede(2750,430,playing));
			centipedes.add(new Centipede(350,150,playing));
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
			//	it.drawAttackBox(g);
			}
		}
		for (Skeleton it : skeletons)
		{
			if (it.isActive())
			{
				it.render(g);
			//	it.drawAttackBox(g);
				//it.drawHitbox(g);
			}
		}

		for (Mummy it : mummies)
		{
			if (it.isActive())
			{
				it.render(g);
			//	it.drawAttackBox(g);
				//it.drawHitbox(g);
			}
		}

		for (Undead it : undeads)
		{
			if (it.isActive())
			{
				it.render(g);
				//it.drawAttackBox(g);
				//it.drawHitbox(g);
			}
		}
		for (Centipede it : centipedes)
		{
			if (it.isActive())
			{
				it.render(g);
			//	it.drawAttackBox(g);
				//it.drawHitbox(g);
			}
		}
		for (Bloated it : bloateds)
		{
			if (it.isActive())
			{
				it.render(g);
				//it.drawAttackBox(g);
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

		for (Skeleton it : skeletons)
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

		for (Mummy it : mummies)
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
		for (Undead it : undeads)
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
		for (Centipede it : centipedes)
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
		for (Bloated it : bloateds)
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

		for (Skeleton it : skeletons)
			it.resetEnemy();

		for (Mummy it : mummies)
			it.resetEnemy();

		for (Undead it : undeads)
			it.resetEnemy();

		for (Centipede it : centipedes)
			it.resetEnemy();

		for (Bloated it : bloateds)
			it.resetEnemy();

	}

	public ArrayList<Hyena> getHyenas() {
		return hyenas;
	}

	public ArrayList<Skeleton> getSkeletons() {
		return skeletons;
	}
}
