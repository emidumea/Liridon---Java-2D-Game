package GameDev.Tiles;

import GameDev.Entities.Skeleton;
import GameDev.Game;
import GameDev.Graphics.Assets;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TileManager {
	public Tile grass1, grass2, grass3;
	Game game;
	Tile[] tile;
	int[][] mapTile;


//	private BufferedImage backgroundImg()
//	{
//		backgroundImg() =
//	}
	public TileManager(Game game) {
		this.game = game;
		tile = new Tile[48];
		mapTile = new int[game.maxWorldRow][game.maxWorldCol];
		//mapTile = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];

		for (int i = 0; i <Assets.land_lv1.length; i++)
		{
			tile[i] = new Tile(Assets.land_lv1[i]);
		}

		loadMap("/maps/map1.txt");
	}

	public void printMap()
	{
		for (int i = 0; i < mapTile.length; i++)
		{
			for (int j = 0; j < mapTile[i].length;j++)
			{
				System.out.print(mapTile[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	public int[][] getMapTile()
	{
		return mapTile;
	}

	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));


			int col = 0;
			int row = 0;


			while (col < Game.maxWorldCol && row < Game.maxWorldRow) {


				String line = br.readLine();


				while (col < Game.maxWorldCol) {


					String numbers[] = line.split(" ");


					int num = Integer.parseInt(numbers[col]);


					mapTile[row][col] = num;
					col++;
				}
				if (col == Game.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {


		}
	}
	/*
		public void draw(Graphics g)
		{
			int col = 0, row = 0, x = 0, y = 0;
			while ( col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT)
			{
				int tileNum = mapTile[row][col];

				if (tileNum != -1)
				{g.drawImage(tile[tileNum].sprite, x, y, Game.TILES_DEFAULT_SIZE,Game.TILES_DEFAULT_SIZE,null);}
				col++;
				x += Game.TILES_DEFAULT_SIZE;

				if (col == Game.TILES_IN_WIDTH)
				{
					col = 0;
					x = 0;
					row++;
					y += Game.TILES_DEFAULT_SIZE;
				}
			}
		}*/
	public void draw(Graphics g)
	{

		int worldCol = 0;
		int worldRow = 0;


		while (worldCol < game.maxWorldCol && worldRow < game.maxWorldRow) {


			int tileNum = mapTile[worldRow][worldCol];


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
					g.drawImage(tile[tileNum].sprite, screenX, screenY, game.TILES_SIZE, game.TILES_SIZE, null);
			}


			worldCol++;


			if(worldCol == game.maxWorldCol){
				worldCol=0;
				worldRow++;
			}
		}
	}
}