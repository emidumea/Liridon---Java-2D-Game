package GameDev.Tiles;

import GameDev.Entities.Hyena;
import GameDev.Game;
import GameDev.Graphics.Assets;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Level
{
	private String path;
	Tile[] tile;
	int[][] mapTile;
	//private ArrayList<Hyena> hyenas;

	public Level(String path, BufferedImage[] sprites)
	{
		this.path = path;
		tile = new Tile[sprites.length + 1];
		mapTile = new int[Game.maxWorldRow][Game.maxWorldCol];
		//mapTile = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];


		for (int i = 0; i <sprites.length; i++)
		{
			tile[i] = new Tile(sprites[i]);

		}

		loadMap(path);
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
//	private void createEnemies()
//	{
//		hyenas.add()
//	}
	public int[][] getMapTile()
	{
		return mapTile;
	}

	public void loadMap(String filePath)
	{
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

	public String getPath()
	{
		return path;
	}
}