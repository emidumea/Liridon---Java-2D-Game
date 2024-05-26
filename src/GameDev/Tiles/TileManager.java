package GameDev.Tiles;

import GameDev.Game;
import GameDev.GameStates.Gamestate;
import GameDev.Graphics.Assets;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileManager {
	Game game;
//	Tile[] tile;
	Tile[][] lvlSprites;
//	int[][] mapTile;
	ArrayList<int[][]> maps;
	ArrayList<Level> levels;
	private int lvlIndex = 0;

	public TileManager(Game game) {
		this.game = game;
		maps = new ArrayList<>(3);
		lvlIndex = 0;

		//lvlSprites = new Tile[3][];
		levels = new ArrayList<>();

		buildAllLevels();
//		loadTiles();
//		loadMaps();
	}

	public void loadNextLevel()
	{
		lvlIndex++;
		if (lvlIndex >= levels.size())
		{
			lvlIndex = 0;
			System.out.println("No more levels");
			Gamestate.state = Gamestate.MENU;
		}

		Level newLevel = levels.get(lvlIndex);
		game.getPlaying().getEnemyManager().initArray(newLevel);
		game.getPlaying().getObjectManager().initObjects(newLevel);
		game.getPlaying().getPlayer().loadLvlData(newLevel.getMapTile());

	}
	private void buildAllLevels()
	{
		levels.add(new Level("/maps/map1.txt", Assets.land_lv1));
		levels.add(new Level("/maps/map2.txt", Assets.land_lv1));
		levels.add(new Level("/maps/map3.txt", Assets.land_lv1));
	}

	public void printMap()
	{
		for (int i = 0; i < levels.get(lvlIndex).mapTile.length; i++)
		{
			for (int j = 0; j < levels.get(lvlIndex).mapTile[i].length;j++)
			{
				System.out.print(levels.get(lvlIndex).mapTile[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public int[][] getMapTile()
	{
		return levels.get(lvlIndex).mapTile;
	}

	public void draw(Graphics g)
	{

		int worldCol = 0;
		int worldRow = 0;


		while (worldCol < game.maxWorldCol && worldRow < game.maxWorldRow) {


			int tileNum = levels.get(lvlIndex).mapTile[worldRow][worldCol];


			int worldX = worldCol * game.TILES_SIZE;
			int worldY = worldRow * game.TILES_SIZE;
			int screenX = worldX - (int)game.getPlaying().getPlayer().getHitboxX() + game.getPlaying().getPlayer().screenX;
			int screenY = worldY - (int)game.getPlaying().getPlayer().getHitboxY() + game.getPlaying().getPlayer().screenY;


			if(worldX + game.TILES_SIZE> game.getPlaying().getPlayer().getHitboxX() - game.getPlaying().getPlayer().screenX &&
					   worldX - game.TILES_SIZE< game.getPlaying().getPlayer().getHitboxX() + game.getPlaying().getPlayer().screenX &&
					   worldY + game.TILES_SIZE> game.getPlaying().getPlayer().getHitboxY() - game.getPlaying().getPlayer().screenY &&
					   worldY - game.TILES_SIZE< game.getPlaying().getPlayer().getHitboxY() + game.getPlaying().getPlayer().screenY)
			{
				if (tileNum != -1)
					g.drawImage(levels.get(lvlIndex).tile[tileNum].sprite, screenX, screenY, game.TILES_SIZE, game.TILES_SIZE, null);
			}


			worldCol++;


			if(worldCol == game.maxWorldCol){
				worldCol=0;
				worldRow++;
			}
		}
	}

	public Level getCurrentLevel()
	{
		return levels.get(lvlIndex);
	}
	public int getAmountOfLevels()
	{
		return levels.size();
	}
	public int getLvlIndex()
	{
		return lvlIndex;
	}

	public void setLvlIndex(int lvlIndex) {
		this.lvlIndex = lvlIndex;
	}
}