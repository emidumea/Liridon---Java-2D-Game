package GameDev.Entities;

import GameDev.Database.EnemyData;
import GameDev.Database.DatabaseManager;
import GameDev.GameStates.Playing;
import GameDev.Tiles.Level;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class EnemyManager {
	private Playing playing;
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private EnemyFactory enemyFactory;

	public EnemyManager(Playing playing) {
		this.playing = playing;
	}

	public void setEnemyFactory(EnemyFactory factory) {
		this.enemyFactory = factory;
	}

	public void update(int[][] lvlData, Player player) {
		boolean isAnyActive = false;
		for (Enemy enemy : enemies) {
			if (enemy.isActive()) {
				enemy.tick();
				enemy.update(lvlData, player);
				isAnyActive = true;
			}
		}
		if (!isAnyActive) {
			playing.setLevelCompleted(true);
		}
	}

	public void initArray(Level level) {
		enemies.clear();

		if (level.getPath().equals("/maps/map1.txt"))
		{
			setEnemyFactory(new Lv1EnemyFactory());
		}
		else if (level.getPath().equals("/maps/map2.txt"))
		{
			setEnemyFactory(new Lv2EnemyFactory());
		}
		else if (level.getPath().equals("/maps/map3.txt"))
		{
			setEnemyFactory(new Lv3EnemyFactory());
		}

		if (level.getPath().equals("/maps/map1.txt")) {
			enemies.add(enemyFactory.createHyena(600, 200, playing));
			enemies.add(enemyFactory.createHyena(1100, 450, playing));
			enemies.add(enemyFactory.createHyena(2700, 300, playing));
			enemies.add(enemyFactory.createHyena(2300, 400, playing));
			enemies.add(enemyFactory.createHyena(2150, 460, playing));
			enemies.add(enemyFactory.createHyena(2500, 460, playing));
			enemies.add(enemyFactory.createSkeleton(800, 465, playing));
			enemies.add(enemyFactory.createSkeleton(2000, 200, playing));
			enemies.add(enemyFactory.createSkeleton(2500, 150, playing));
			enemies.add(enemyFactory.createSkeleton(970, 230, playing));
		} else if (level.getPath().equals("/maps/map2.txt")) {
			enemies.add(enemyFactory.createMummy(1350, 50, playing));
			enemies.add(enemyFactory.createMummy(1650, 50, playing));
			enemies.add(enemyFactory.createMummy(2550, 40, playing));
			enemies.add(enemyFactory.createMummy(2000, 50, playing));
			enemies.add(enemyFactory.createMummy(2850, 400, playing));
			enemies.add(enemyFactory.createUndead(500, 250, playing));
			enemies.add(enemyFactory.createUndead(900, 200, playing));
			enemies.add(enemyFactory.createUndead(1500, 300, playing));
			enemies.add(enemyFactory.createUndead(900, 450, playing));
			enemies.add(enemyFactory.createUndead(2750, 50, playing));
		} else if (level.getPath().equals("/maps/map3.txt")) {
			enemies.add(enemyFactory.createBloated(900, 250, playing));
			enemies.add(enemyFactory.createBloated(1500, 50, playing));
			enemies.add(enemyFactory.createBloated(2200, 530, playing));
			enemies.add(enemyFactory.createBloated(2750, 50, playing));
			enemies.add(enemyFactory.createBloated(2750, 50, playing));
			enemies.add(enemyFactory.createCentipede(1300, 530, playing));
			enemies.add(enemyFactory.createCentipede(1100, 530, playing));
			enemies.add(enemyFactory.createCentipede(1800, 530, playing));
			enemies.add(enemyFactory.createCentipede(2750, 430, playing));
			enemies.add(enemyFactory.createCentipede(450, 150, playing));
		}
	}

	public void draw(Graphics g) {
		for (Enemy enemy : enemies) {
			if (enemy.isActive()) {
				enemy.render(g);
			}
		}
	}

	public void checkEnemyHit(Rectangle2D.Float attackBox) {
		for (Enemy enemy : enemies) {
			if (enemy.isActive() && attackBox.intersects(enemy.getHitbox())) {
				enemy.hurt(10);
				return;
			}
		}
	}

	public void resetAllEnemies() {
		for (Enemy enemy : enemies) {
			enemy.resetEnemy();
		}
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	public void loadEnemiesFromDatabase()
	{
		enemies.clear();
		ArrayList<EnemyData> enemiesData = DatabaseManager.getEnemiesData();
		for (EnemyData data : enemiesData)
		{
			int x = data.getX();
			int y = data.getY();
			int type = data.getType();

			// Aici poți folosi o fabrică de inamici pentru a crea inamicul potrivit în funcție de tipul dat
			switch (type) {
				case 0:
					enemies.add(enemyFactory.createHyena(x,y,playing));
					break;
				case 1:
					enemies.add(enemyFactory.createSkeleton(x,y,playing));
					break;
				case 2:
					enemies.add(enemyFactory.createMummy(x,y,playing));
					break;
				case 3:
					enemies.add(enemyFactory.createUndead(x,y,playing));
					break;
				case 4:
					enemies.add(enemyFactory.createCentipede(x,y,playing));
					break;
				case 5:
					enemies.add(enemyFactory.createBloated(x,y,playing));
					break;
				default:
					break;
			}
		}
	}
}
