package GameDev.Tiles;

import GameDev.Game;
import GameDev.Graphics.Assets;

import java.awt.*;
import java.awt.event.InputEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
	public Tile grass1, grass2, grass3;
	Game game;
	Tile[] tile;
	int[][] mapTile;

	public TileManager(Game game) {
		this.game = game;
		tile = new Tile[37];
		mapTile = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
		//mapTile = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];

		for (int i = 0; i <Assets.land_lv1.length; i++)
		{
			tile[i] = new Tile(Assets.land_lv1[i]);
		}
		/*int i,j;
		for (i = 0; i < Assets.land_grass.length; i++) {
			tile[i] = new Tile(Assets.land_grass[i]);
		}
		for (j = 0; j < Assets.land_stone.length;j++)
		{
			tile[i + j] = new Tile(Assets.land_stone[j]);
		}
		int k = i + j;
		for (i = 0; i < Assets.platforms_grass.length; i++)
		{
			tile[k + i] = new Tile(Assets.platforms_grass[i]);
		}
		int l = k + i + 1;
		for (i = 0; i < Assets.platforms_stone.length; i++)
		{
			tile[k + i] = new Tile(Assets.platforms_stone[i]);
		}*/
		loadMap("/maps/map1.txt");
	}


	/*public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			int col = 0, row = 0;

			while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT) {
				String line = br.readLine();

				while (col < Game.TILES_IN_WIDTH) {
					String numbers[] = line.split(" ");

					int num = Integer.parseInt(numbers[col]);

					mapTile[col][row] = num;
					col++;
				}
				if (col == Game.TILES_IN_WIDTH) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
		}
	}*/

	/*public void loadMap() {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/map1.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row = 0; // Schimbăm coloanele cu rândurile
			while (row < Game.TILES_IN_HEIGHT) { // Înlocuim Game.TILES_IN_WIDTH cu Game.TILES_IN_HEIGHT
				String line = br.readLine();

				//String numbers[] = line.split(" ");
//				for (int col = 0; col < Game.TILES_IN_WIDTH; col++) { // Înlocuim Game.TILES_IN_HEIGHT cu Game.TILES_IN_WIDTH
//					int num = Integer.parseInt(numbers[col]);
//					mapTile[col][row] = num; // Înlocuim row cu col și col cu row pentru a inversa ordinea
//				}
//				row++; // Creștem row în loc de col pentru a inversa ordinea
				while  (col < Game.TILES_IN_WIDTH)
				{
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					mapTile[col][row] = num;
					col++;
				}
				if (col == Game.TILES_IN_WIDTH)
				{
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {
		}
	}*/
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
	/////////// PRINCIPALA
	/*public void render(Graphics g) {
		int col = 0, row = 0, x = 0, y = 0;

	//	while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT) {
		while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT){
			int tileNum = mapTile[col][row];
			int spriteWidth = 0;// = tile[tileNum].getSprite().getWidth();
			int spriteHeight = 0;// = tile[tileNum].getSprite().getHeight();
			if (tileNum >= 0 && tileNum < tile.length && tile[tileNum]!=null) {
				//spriteWidth = tile[tileNum].getSprite().getWidth();
				 //spriteHeight = tile[tileNum].getSprite().getHeight();
				//g.drawImage(tile[tileNum].sprite, x, y, spriteWidth, spriteHeight, null);
				g.drawImage(tile[tileNum].sprite, y, x, Game.TILES_DEFAULT_SIZE, Game.TILES_DEFAULT_SIZE, null);

			}
			col++;
			x += Game.TILES_DEFAULT_SIZE;
		//	x += spriteWidth;

			if (col == Game.TILES_IN_WIDTH) {
				col = 0;
				x = 0;
				row++;
				y += Game.TILES_DEFAULT_SIZE;
			//	y += spriteHeight;
			}
		}
	}*/
	/////////////////////////////////// PRINCIPAAALA
//	public void render(Graphics g) {
//		int col = 0, row = 0, x = 0, y = 0;
//
//		//	while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT) {
//		while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT){
//			int tileNum = mapTile[col][row];
//			int spriteWidth = 0;// = tile[tileNum].getSprite().getWidth();
//			int spriteHeight = 0;// = tile[tileNum].getSprite().getHeight();
//			if (tileNum >= 0 && tileNum < tile.length && tile[tileNum]!=null) {
//				//spriteWidth = tile[tileNum].getSprite().getWidth();
//				//spriteHeight = tile[tileNum].getSprite().getHeight();
//				//g.drawImage(tile[tileNum].sprite, x, y, spriteWidth, spriteHeight, null);
//				g.drawImage(tile[tileNum].sprite, y, x, Game.TILES_DEFAULT_SIZE, Game.TILES_DEFAULT_SIZE, null);
//
//			}
//			col++;
//			x += Game.TILES_DEFAULT_SIZE;
//			//	x += spriteWidth;
//
//			if (col == Game.TILES_IN_WIDTH) {
//				col = 0;
//				x = 0;
//				row++;
//				y += Game.TILES_DEFAULT_SIZE;
//				//	y += spriteHeight;
//			}
//		}
//	}
//////////////	public void render(Graphics g) {
//		int col = 0, row = 0, x = 0, y = 0;
//
//		//	while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT) {
//		while (col < Game.TILES_IN_HEIGHT && row < Game.TILES_IN_WIDTH){
//			int tileNum = mapTile[col][row];
//			int spriteWidth = 0;// = tile[tileNum].getSprite().getWidth();
//			int spriteHeight = 0;// = tile[tileNum].getSprite().getHeight();
//			if (tileNum >= 0 && tileNum < tile.length && tile[tileNum]!=null) {
//				//spriteWidth = tile[tileNum].getSprite().getWidth();
//				//spriteHeight = tile[tileNum].getSprite().getHeight();
//				//g.drawImage(tile[tileNum].sprite, x, y, spriteWidth, spriteHeight, null);
//				g.drawImage(tile[tileNum].sprite, y, x, Game.TILES_DEFAULT_SIZE, Game.TILES_DEFAULT_SIZE, null);
//
//			}
//			col++;
//			x += Game.TILES_DEFAULT_SIZE;
//			//	x += spriteWidth;
//
//			if (col == Game.TILES_IN_HEIGHT) {
//				col = 0;
//				x = 0;
//				row++;
//				y += Game.TILES_DEFAULT_SIZE;
//				//	y += spriteHeight;
//			}
//		}
//	}
//	public void render(Graphics g) {
//		int col = 0, row = 0, x = 0, y = 0;
//		int spaceBetweenSprites = 2; // Spațiul între sprite-uri
//
//		while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT){
//			int tileNum = mapTile[col][row];
//
//			if (tileNum >= 0 && tileNum < tile.length && tile[tileNum] != null) {
//				// Ajustează coordonatele de desenare pentru fiecare sprite
//				int spriteWidth = tile[tileNum].getSprite().getWidth();
//				int spriteHeight = tile[tileNum].getSprite().getHeight();
//				g.drawImage(tile[tileNum].sprite, x, y, spriteWidth, spriteHeight, null);
//			}
//
//			col++;
//			x += Game.TILES_DEFAULT_SIZE - spaceBetweenSprites; // Adaugă spațiul între sprite-uri
//
//			if (col == Game.TILES_IN_WIDTH) {
//				col = 0;
//				x = 0;
//				row++;
//				y += Game.TILES_DEFAULT_SIZE - spaceBetweenSprites; // Adaugă spațiul între sprite-uri
//			}
//		}
//	}

	public int[][] getMapTile()
	{
		return mapTile;
	}
//}

	/*public void render(Graphics g) {
		int x = 0 , y = 0;
		for (int row = 0; row < mapTile.length; row++) {
			for (int col = 0; col < mapTile[row].length; col++) {
				int tileNum = mapTile[row][col];
				// Verificăm dacă valoarea din matrice nu reprezintă spațiul liber
				if (tileNum != -1 && tileNum >= 0 && tileNum < tile.length) {
					// Desenăm sprite-ul corespunzător la poziția curentă
					 x = x + Game.TILES_DEFAULT_SIZE;
					if (col == Game.TILES_IN_WIDTH) {
						x = 0;
						y = y +  Game.TILES_DEFAULT_SIZE;
					}
					g.drawImage(tile[tileNum].sprite, x, y, Game.TILES_DEFAULT_SIZE, Game.TILES_DEFAULT_SIZE, null);
				}
			}
		}
	}*/
	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));


			int col = 0;
			int row = 0;


			while (col < Game.TILES_IN_WIDTH && row < Game.TILES_IN_HEIGHT) {


				String line = br.readLine();


				while (col < Game.TILES_IN_WIDTH) {


					String numbers[] = line.split(" ");


					int num = Integer.parseInt(numbers[col]);


					mapTile[row][col] = num;
					col++;
				}
				if (col == Game.TILES_IN_WIDTH) {
					col = 0;
					row++;
				}
			}
			br.close();
		} catch (Exception e) {


		}
	}

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
	}
}
