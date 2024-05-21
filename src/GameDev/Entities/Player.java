package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Graphics.ImageLoader;
import GameDev.Utils.Constants;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

//import static GameDev.Utils.Constants.EnemyConstants.*;
import static GameDev.Utils.Constants.GRAVITY;
import static GameDev.Utils.Constants.PlayerConstants.*;
import static GameDev.Utils.HelpMethods.*;

public class Player extends Entity
{
	private Animation animIdle, animUp, animLeft, animRight, animDown, animAttack, animJump, animFall; // 20 29
	private boolean moving = false, attacking = false;
	private int aniSpeed = 25;
	private int playerAction = Constants.PlayerConstants.IDLE;
	private boolean left, right, up, down, jump;
	private float speed = 2.0f;
	private int[][] lvlData;
	private float xDrawOffset = 20 * Game.SCALE;
	private float yDrawOffset = 6 * Game.SCALE;
	public final int screenX;
	public final int screenY;

	//// Jumping and Gravity
	private float airSpeed = 0f;
	private float jumpSpeed = -3.40f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
	private boolean inAir = false;

	//status bar
	private BufferedImage statusBarImg;
	private int statusBarWidth = (int) (1.4 * 192 * Game.SCALE);
	private int statusBarHeight = (int) ( 1.4 * 58 * Game.SCALE);
	private int statusBarX = (int) (10 * Game.SCALE);
	private int statusBarY = (int) (10 * Game.SCALE);

	private int healthBarWidth = (int) (1.4 * 150 * Game.SCALE);
	private int healthBarHeight = (int) (1.4 * 4 * Game.SCALE);
	private int healthBarXStart = (int) (1.4 * 34 * Game.SCALE);
	private int healthBarYStart = (int) (1.4 * 14 * Game.SCALE);
	// health bar ui
	private BufferedImage healthBar = Assets.health_bar[0];

	private int maxHealth = 100;
	private int currentHealth = 100;
	private int healthWidth = healthBarWidth;

	// attack
	private Rectangle2D.Float attackBox;
	private int flipX = 0;
	private int flipW = 1;

	private boolean attackChecked;
	private Playing playing;

	public Player(float x, float y, int width, int height, Playing playing)
	{
		super(x,y,width,height);
		this.playing = playing;
		screenX = Game.GAME_WIDTH/2; //- (gp.tileSize/2);
		screenY = Game.GAME_HEIGHT/2; //- (gp.tileSize/2);

		animIdle = new Animation(Assets.player_idle,100);
		animUp = new Animation(Assets.player_up,100);
		animLeft = new Animation(Assets.player_up,100);
		animRight = new Animation(Assets.player_up,100);
		animAttack = new Animation(Assets.player_attack,100);
		animDown = new Animation(Assets.player_up,100);
		animJump = new Animation(Assets.player_jump,100);
		animFall = new Animation(Assets.player_fall,100);
		statusBarImg = ImageLoader.LoadImage("/hp/health_power_bar.png");
		initHitbox(x, y, 20 * Game.SCALE, 28 * Game.SCALE);
		initAttackBox();
	}

	private void initAttackBox()
	{
		attackBox = new Rectangle2D.Float(x, y, (int) (20 * Game.SCALE), (int) (20 * Game.SCALE));
	}

	public void resetDirBooleans()
	{
		left = false;
		right = false;
		up = false;
		down = false;
		jump = false;
	}

	private void updatePos()
	{
		moving = false;

		if (jump)
		{
			jump();
		}
		if (!left && !right && !inAir)
			return;

		float dx = 0;
		if (left)
		{
			dx = -speed;
			flipX = width;
			flipW = -1;
		}
		else if (right)
		{
			dx += speed;
			flipX = 0;
			flipW = 1;
		}
		if (!inAir)
		{
			if (!IsEntityOnFloor(hitbox, lvlData))
			{
				inAir = true;
			}
		}
		if (inAir)
		{
			if (CanMoveHere(hitbox.x, hitbox.y + airSpeed, hitbox.width, hitbox.height, lvlData))
			{
				hitbox.y += airSpeed;
				airSpeed += GRAVITY;
				updateXPos(dx);
			}
			else
			{
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, airSpeed);
				if (airSpeed > 0)
				{
					resetInAir();
				}
				else
				{
					airSpeed = fallSpeedAfterCollision;
					updateXPos(dx);
				}
			}
		}
		else
		{
			updateXPos(dx);
		}
		moving = true;
		//x += dx;
	}

	private void jump()
	{
		if(inAir)
			return;
		inAir = true;
		airSpeed = jumpSpeed;
	}

	private void resetInAir()
	{
		inAir = false;
		airSpeed = 0;
	}

	public void changeHealth(int val)
	{
		currentHealth += val;
		if (currentHealth <= 0 )
		{
			currentHealth = 0;
		}
		else if (currentHealth >= maxHealth)
		{
			currentHealth = maxHealth;
		}
	}
	private void updateXPos(float dx)
	{
		if(CanMoveHere(hitbox.x + dx, hitbox.y, hitbox.width , hitbox.height ,lvlData))
		{
			hitbox.x += dx;
		}
		else
		{
			hitbox.x = GetEntityXPosNextToWall(hitbox, dx);
		}
	}

	@Override
	public void tick()
	{
		updateHealthBar();
		if (currentHealth <= 0)
		{
			playing.setGameOver(true);
			return;
		}

		updateAttackBox();

		updatePos();
		if (attacking)
			checkAttack();

		animIdle.tick();
		if (moving)
		{
			if (left)
			{
				animLeft.tick();
			}
			else if (right)
			{
				animRight.tick();
			}
			else if (up)
			{
				animUp.tick();
			}
			else if (down)
			{
				animDown.tick();
			}

		}
		if (inAir)
		{
			if (airSpeed < 0)
				animJump.tick();
			else
				animFall.tick();
		}
		if (attacking)
		{
			animAttack.tick();
		}
		updateAnimationTick();

	}
	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(playerAction)) {
				aniIndex = 0;
				attacking = false;
				attackChecked = false;
			}

		}

	}
	private void checkAttack()
	{
		if (attackChecked || aniIndex != 2)
			return;
		attackChecked = true;
		playing.checkEnemyHit(attackBox);
	}

	private void updateAttackBox()
	{
		if (right)
		{
			attackBox.x = hitbox.x + hitbox.width + (int)(Game.SCALE * 10);
		}
		else if (left)
		{
			attackBox.x = hitbox.x - hitbox.width - (int)(Game.SCALE * 10);
		}
		attackBox.y = hitbox.y + (Game.SCALE * 10);
	}

	private void updateHealthBar()
	{
		healthWidth = (int)((currentHealth / (float)maxHealth) * healthBarWidth);
	}

	private void drawUI(Graphics g)
	{
		g.drawImage(statusBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);
		g.setColor(Color.red);
		g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, healthWidth, healthBarHeight);
	}
	public void render(Graphics g)
	{

		if (inAir)
		{
			if (airSpeed < 0)
				g.drawImage(animJump.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			else
				g.drawImage(animFall.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
		}
		else if (attacking)
		{
			g.drawImage(animAttack.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
		}
		else if (moving)
		{
			if (left)
			{
				g.drawImage(animLeft.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			}
			else if (right)
			{
				g.drawImage(animRight.getCurrentFrame(),   (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			}
			else if (up)
			{
				g.drawImage(animUp.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			}
			else if (down)
			{
				g.drawImage(animDown.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			}
			else
			{
				// daca nu se misca sau nu face altceva, afisam animatia de idle
				g.drawImage(animIdle.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
			}
		}
		else
		{
			// daca nu se misca, afisam animatia de idle
			g.drawImage(animIdle.getCurrentFrame(),  (int) (screenX - xDrawOffset) + flipX ,(int) (screenY - yDrawOffset), width * flipW, height, null);
		}

		drawUI(g);
		//drawHitbox(g);
		//drawAttackBox(g);
	}

	private void drawAttackBox(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.drawRect((int)attackBox.x, (int)attackBox.y, (int)attackBox.width, (int)attackBox.height);
	}

//	private void drawUI(Graphics g)
//	{
//		g.drawImage(healthBar, healthBarXStart,healthBarYStart,healthBarWidth,healthBarHeight,null);
//		g.setColor(Color.red);
//	}
	public void loadLvlData(int [][] lvlData)
	{
		this.lvlData = lvlData;
		if (!IsEntityOnFloor(hitbox, lvlData))
			inAir = true;
	}
	public void moveLeft() {
		x = -speed;
		moving = true;
	}

	public void moveRight() {
		x = speed;
		moving = true;
	}

	public void moveUp() {
		y = -speed;
		moving = true;
	}

	public void moveDown() {
		y = speed;
		moving = true;
	}

	public void stopMoving() {
		x = 0;
		y = 0;
		moving = false;
	}
	public boolean isLeft()
	{
		return left;
	}

	public void setLeft(boolean left)
	{
		this.left = left;
	}

	public boolean isRight()
	{
		return right;
	}

	public void setRight(boolean right)
	{
		this.right = right;
	}

	public boolean isUp()
	{
		return up;
	}

	public void setUp(boolean Up)
	{
		this.up = Up;
	}

	public boolean isDown()
	{
		return down;
	}

	public void setDown(boolean Down)
	{
		this.down = Down;
	}

	public void setAttacking(boolean attacking)
	{
		this.attacking = attacking;
	}
	public boolean getAttacking()
	{
		return this.attacking;
	}
	public void setJump(boolean jump)
	{
		this.jump = jump;
	}

	public void resetAll()
	{
		resetDirBooleans();
		inAir = false;
		attacking = false;
		moving = false;
		playerAction = IDLE;
		currentHealth = maxHealth;

		hitbox.x = x;
		hitbox.y = y;

		if (!IsEntityOnFloor(hitbox,lvlData))
			inAir = true;
	}
}