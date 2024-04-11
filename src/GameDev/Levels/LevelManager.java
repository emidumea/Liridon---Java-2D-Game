package GameDev.Levels;

import GameDev.Game;
import GameDev.Graphics.Assets;
import GameDev.Utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LevelManager
{
	private Game game;
	private BufferedImage[] levelSprite;
	private Level levelOne;

	public void importSprites() {
		// Inițializare array de sprite-uri pentru teren
		//levelSprites = new BufferedImage[Assets.land_grass.length];
		//for (int i = 0; i < levelSprites.length; i++) {
		//	levelSprites[i] = Assets.land_grass[i]; // Încărcăm sprite-urile din Assets
		//}
		levelSprite = Assets.land_grass;
	}
	public LevelManager(Game game) {
		this.game = game;
		importSprites();
		levelOne = new Level(LoadSave.GetLevelData());
	}

	public void render(Graphics g) {
		for (int j = 0; j < game.TILES_IN_HEIGHT; j++) {
			for (int i = 0; i < game.TILES_IN_WIDTH; i++) {
				int spriteIndex = levelOne.getSpriteIndex(i, j); // Obține indexul sprite-ului pentru dala curentă
				BufferedImage sprite = levelSprite[spriteIndex]; // Obține sprite-ul corespunzător
				//g.drawImage(sprite, i * game.TILES_SIZE, j * game.TILES_SIZE, null); // Randare sprite-ul
				g.drawImage(sprite, Game.TILES_SIZE * i, Game.TILES_SIZE * j, Game.TILES_SIZE, Game.TILES_SIZE, null);
			}
		}
	}
	public void update() {

	}
}
