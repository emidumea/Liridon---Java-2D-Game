package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static GameDev.Utils.Constants.Directions.LEFT;
import static GameDev.Utils.Constants.Directions.RIGHT;
import static GameDev.Utils.Constants.EnemyConstants.*;
import static GameDev.Utils.Constants.EnemyConstants.MUMMY_HEIGHT_DEFAULT;

public class Mummy extends Enemy
{

	private void initAnimations() {
		BufferedImage[] idle, up, left, right, attack, down, jump, fall;
		int i;

		animIdle = new Animation(Assets.mummy_walk, 100);
		animLeft = new Animation(Assets.mummy_walk, 100);
		animRight = new Animation(Assets.mummy_walk, 100);
		animAttack = new Animation(Assets.mummy_attack, 100);
		animHit = new Animation(Assets.mummy_hit, 100);
		animDie = new Animation(Assets.mummy_die,100);

	}

	public Mummy(float x, float y, Playing playing) {
		super(x, y, MUMMY_WIDTH, MUMMY_HEIGHT, MUMMY, playing);
		//	super(x, y, HYENA_WIDTH, HYENA_HEIGHT, SKELETON, playing);
		initAnimations();
	//	initHitbox(x, y, (45 * Game.SCALE),(45 * Game.SCALE));
		initHitbox(x, y, (int) (25 * Game.SCALE), (int) (30 * Game.SCALE));
		initAttackBox();
	}

	private void initAttackBox()
	{
		attackBox = new Rectangle2D.Float(x, y, (int)(30 * Game.SCALE), (int)(30 * Game.SCALE));
		attackBoxOffsetX = (int) (Game.SCALE * 10);
	}

	public void update(int[][] lvlData, Player player) {
		updateBehavior(lvlData, player);
		updateAnimationTick();
		//System.out.println(aniIndex);
		animLeft.tick();
		updateAttackBox();
	}
	private void updateAttackBox()
	{
		attackBox.x = hitbox.x - attackBoxOffsetX;
		attackBox.y = hitbox.y;
	}

	private void updateBehavior(int[][] lvlData, Player player)
	{
		if (enemyState == DEAD)
			return;

		if (firstUpdate)
		{
			firstUpdateCheck(lvlData);
		}

		if (inAir)
		{
			updateInAir(lvlData);
		}
		else
		{
			switch (enemyState)
			{
				case IDLE:
					newState(RUNNING);
					break;
				case RUNNING:
					if (canSeePlayer(lvlData, player)) {
						turnTowardsPlayer(player);

						if (isPlayerCloseForAttack(player))
							newState(ATTACK);
					}
					move(lvlData);
					break;
				case ATTACK:
					if (aniIndex == 0)
						attackChecked = false;

					if (aniIndex == 2 && !attackChecked)
						checkEnemyHit(attackBox,player);
					break;
				case HIT:
					break;
			}
		}


	}

	@Override
	public void tick() {

		animIdle.tick();
		if (enemyState == ATTACK)
		{
			animAttack.tick();
//			if (animAttack.isAnimationFinished())
//			{
//				enemyState = IDLE; // reset la starea IDLE dupa atac
//				// Resetarea animației la starea idle
//				animIdle.setCurrentFrame(0); // reset la primul frame idle
//			}
			if (aniIndex == 3)
			{
				enemyState = IDLE;
			}

		}
		else if (enemyState == HIT)
		{
			animHit.tick();
			if (animHit.isAnimationFinished())
				enemyState = IDLE;
		}
		else if (enemyState == DEAD)
		{
			animDie.tick();
			if (animDie.isAnimationFinished())
			{
				active = false;
			}

		}
	}

	@Override
	public void render(Graphics g) {
		int screenX = (int) (getHitbox().x - getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
		int screenY = (int) (getHitbox().y - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
		this.screenX = screenX;
		this.screenY = screenY;
		switch (enemyState) {
			case DEAD:
				g.drawImage(animDie.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				break;
			case IDLE:
				g.drawImage(animIdle.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				break;
			case RUNNING:
				if (walkDir == LEFT) {
					g.drawImage(animLeft.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				} else {
					g.drawImage(animLeft.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				}
				break;
			case ATTACK:

				g.drawImage(animAttack.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				break;
			case HIT:
				g.drawImage(animHit.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				break;
			default:
				g.drawImage(animIdle.getCurrentFrame(), screenX - MUMMY_DRAWOFFSET_X + flipX(), screenY - MUMMY_DRAWOFFSET_Y, MUMMY_WIDTH_DEFAULT * flipW(), MUMMY_HEIGHT_DEFAULT, null);
				break;
		}
		//drawHitbox(g);
		//drawAttackBox(g);
	}
	//	@Override
//	public void render(Graphics g) {
//		int screenX = (int) (getHitbox().x - getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
//		int screenY = (int) (getHitbox().y - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
//		this.screenX = screenX;
//		this.screenY = screenY;
//		switch (enemyState) {
//			case DEAD:
//				g.drawImage(animDie.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				break;
//			case IDLE:
//				g.drawImage(animIdle.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				break;
//			case RUNNING:
//				if (walkDir == LEFT) {
//					g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				} else {
//					g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				}
//				break;
//			case ATTACK:
//
//				g.drawImage(animAttack.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				break;
//			case HIT:
//				g.drawImage(animHit.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				break;
//			default:
//				g.drawImage(animIdle.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
//				break;
//		}
//		//drawHitbox(g);
//		//drawAttackBox(g);
//	}
	public void drawAttackBox(Graphics g)
	{
		g.setColor(Color.red);
		g.drawRect((int)attackBox.x,(int) attackBox.y, (int)attackBox.width, (int)attackBox.height);
	}
	public int flipX()
	{
		if (walkDir == RIGHT)
			return width;
		else
			return 0;
	}

	public int flipW()
	{
		if (walkDir == RIGHT)
			return -1;
		else
			return 1;
	}
}
