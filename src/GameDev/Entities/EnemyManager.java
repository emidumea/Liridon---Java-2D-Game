package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.ImageLoader;
import GameDev.Graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static GameDev.Utils.Constants.EnemyConstants.*;

public class EnemyManager
{
	private Playing playing;
	private BufferedImage[][] skeletonArr;
	private ArrayList<Skeleton> skeletons = new ArrayList<>();
	private ArrayList<Hyena> hyenas = new ArrayList<>();
	public EnemyManager(Playing playing)
	{

		this.playing = playing;
		initArray();
		//loadEnemyImgs();
	}
	public void update(int[][] lvlData)
	{
		for (Hyena it : hyenas) {
			it.tick();
			it.update(lvlData);
		}
	}
	public void initArray()
	{
//		skeletons.add(new Skeleton(600,200,playing));
//		skeletons.add(new Skeleton(1200,100,playing));
//		skeletons.add(new Skeleton(1950,100,playing));

		hyenas.add(new Hyena(600,200,playing));
		hyenas.add(new Hyena(1200,100,playing));
		hyenas.add(new Hyena(1950,100,playing));


	}
	public void draw(Graphics g)
	{
		//drawSkeletons(g);
		drawHyenas(g);
	}
	private void drawSkeletons(Graphics g)
	{
		for (Skeleton it : skeletons) {
			it.render(g);
			it.drawHitbox(g);
		}

	}
	private void drawHyenas(Graphics g)
	{
		for (Hyena it : hyenas) {
			it.render(g);
			it.drawHitbox(g);
		}

	}
//	private void loadEnemyImgs()
//	{
//		skeletonArr = new BufferedImage[5][8];
//		SpriteSheet temp = new SpriteSheet(ImageLoader.LoadImage("/lv1/skeleton1/skeleton.png"));
//		for (int j = 0; j < skeletonArr.length; j++)
//		{
//			for (int i = 0; i < skeletonArr[j].length; i++)
//			{
//				skeletonArr[j][i] = temp.crop(i * SKELETON_WIDTH_DEFAULT, j * SKELETON_HEIGHT_DEFAULT, SKELETON_WIDTH_DEFAULT, SKELETON_HEIGHT_DEFAULT);
//			}
//		}
//	}
}
