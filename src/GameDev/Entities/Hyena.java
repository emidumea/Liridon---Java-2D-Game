package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Graphics.ImageLoader;
import GameDev.Graphics.SpriteSheet;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import static GameDev.Utils.Constants.Directions.LEFT;
import static GameDev.Utils.Constants.Directions.*;
import static GameDev.Utils.Constants.EnemyConstants.*;
import static GameDev.Utils.HelpMethods.*;

public class Hyena extends Enemy {
	private Rectangle2D.Float attackBox;
	private int attackBoxOffsetX;
	private void initAnimations() {
		BufferedImage[] idle, up, left, right, attack, down, jump, fall;
		int i;
		animIdle = new Animation(Assets.hyena_walk, 100);
		animLeft = new Animation(Assets.hyena_walk, 100);
		animRight = new Animation(Assets.hyena_walk, 100);
		animAttack = new Animation(Assets.hyena_attack, 100);
		animHit = new Animation(Assets.hyena_hit, 100);
		animDie = new Animation(Assets.hyena_die,100);
	}

	public Hyena(float x, float y, Playing playing) {
		super(x, y, HYENA_WIDTH, HYENA_HEIGHT, HYENA, playing);
		initAnimations();
		initHitbox(x, y, (int) (40 * Game.SCALE), (int) (24 * Game.SCALE));
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
					if (canSeePlayer(lvlData, player))
					{
						turnTowardsPlayer(player);
					}
					if (isPlayerCloseForAttack(player))
						newState(ATTACK);
					move(lvlData);
					break;
				case ATTACK:
					if (aniIndex == 0)
						attackChecked = false;

					if (aniIndex == 1 && !attackChecked)
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
			if (animAttack.isAnimationFinished())
			{
				enemyState = IDLE; // reset la starea IDLE dupa atac
				// Resetarea animației la starea idle
				animIdle.setCurrentFrame(0); // reset la primul frame idle
			}
		}
		else if (enemyState == HIT)
		{
			animHit.tick();
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

		switch (enemyState) {
			case IDLE:
				g.drawImage(animIdle.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				break;
			case RUNNING:
				if (walkDir == LEFT) {
					g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				} else {
					g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				}
				break;
			case ATTACK:

				g.drawImage(animAttack.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				break;
			case HIT:
				g.drawImage(animHit.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				break;
			case DEAD:
				g.drawImage(animDie.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
			default:
				g.drawImage(animIdle.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X + flipX(), screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT * flipW(), HYENA_HEIGHT_DEFAULT, null);
				break;
		}
		//drawHitbox(g);
		//drawAttackBox(g);
	}
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
