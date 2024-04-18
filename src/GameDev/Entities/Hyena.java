package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Graphics.ImageLoader;
import GameDev.Graphics.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

import static GameDev.Graphics.Assets.skeletonArr;
import static GameDev.Utils.Constants.EnemyConstants.*;

public class Hyena extends Enemy
{

	private void initAnimations()
	{
		BufferedImage[] idle,up,left,right,attack,down,jump,fall;
		int i;
//		attack = new BufferedImage[8];
//		for (i = 0; i < skeletonArr[0].length; i++)
//			attack[i] = skeletonArr[0][i];
//		animAttack = new Animation(attack, 100);
//
//		idle = new BufferedImage[3];
//		for (i = 0; i < 3; i++)
//			idle[i] = skeletonArr[3][i];
//		animIdle = new Animation(idle,100);
//
//		left = new BufferedImage[6];
//		right = new BufferedImage[6];
//		for (i = 0; i < 5; i++)
//		{
//			left[i] = skeletonArr[4][i];
//			right[i] = skeletonArr[4][i];
//		}
//		animLeft = new Animation(left, 100);
//		animRight = new Animation(right, 100);
		animLeft = new Animation(Assets.skeleton_walk, 100);
		animRight = new Animation(Assets.skeleton_walk, 100);
	}
	//	public Skeleton(float x, float y, Playing playing) {
//		super(x, y, SKELETON_WIDTH, SKELETON_HEIGHT, SKELETON1,playing);
//		initAnimations();
//	}
	public Hyena(float x, float y, Playing playing) {
		super(x, y, HYENA_WIDTH, HYENA_HEIGHT, HYENA, playing);
		initAnimations();
		initHitbox(x,y,(int) (40 * Game.SCALE),(int) (24 * Game.SCALE));
	}

	@Override
	public void tick()
	{
		animLeft.tick();
	}

//	@Override
//	public void render(Graphics g)
//	{
//		//int screenX = (int) (x - getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
//	//	int screenY = (int) (y - getPlaying().getPlayer().getHitboxY() +getPlaying().getPlayer().screenY);
//		//g.drawImage(animIdle.getCurrentFrame(), screenX, screenY, SKELETON_WIDTH, SKELETON_HEIGHT, null);
//	}
}
