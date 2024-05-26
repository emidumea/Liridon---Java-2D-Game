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
	private Animation animIdle, animUp, animLeft, animRight, animDown, animAttack, animJump, animFall, animPowerAttack, animDie; // 20 29
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
	private int maxHealth = 100;
	private int currentHealth = 100;
	private int healthWidth = healthBarWidth;


	private int powerBarWidth = (int) (1.4 * 104 * Game.SCALE);
	private int powerBarHeight = (int) (1.5 * 2 * Game.SCALE);
	private int powerBarXStart = (int) (1.4 * 44 * Game.SCALE);
	private int powerBarYStart = (int) (1.4 * 34 * Game.SCALE);
	private int powerWidth = powerBarWidth;
	private int powerMaxValue = 200;
	private int powerValue = powerMaxValue;


	// attack
	private Rectangle2D.Float attackBox;
	private int flipX = 0;
	private int flipW = 1;

	private boolean attackChecked;
	private Playing playing;
	private boolean powerAttackActive;
	private int powerAttackTick;
	private int powerGrowSpeed = 15;
	private int powerGrowTick;

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
		animDie = new Animation(Assets.player_die,200);
		animPowerAttack = new Animation(Assets.player_powerAttack, 100);
		statusBarImg = ImageLoader.LoadImage("/hp/health_power_bar.png");
		initHitbox(x, y, 20 * Game.SCALE, 28 * Game.SCALE);
		initAttackBox();
	}

	private void initAttackBox()
	{
		attackBox = new Rectangle2D.Float(x, y, (int) (20 * Game.SCALE), (int) (20 * Game.SCALE));
		resetAttackBox();
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

		if (!inAir)
		{
			if (!powerAttackActive)
				if (!left && !right)
					return;
		}

		float dx = 0;
		if (left && !right)
		{
			dx = -speed;
			flipX = width;
			flipW = -1;
		}
		if (right && !left)
		{
			dx += speed;
			flipX = 0;
			flipW = 1;
		}
		if (powerAttackActive)
		{
			if ((!left && !right) || (left && right))
			{
				if (flipW == -1)
				{
					dx = -speed;
				}
				else
				{
					dx = speed;
				}
			}

			dx *= 3;
		}

		if (!inAir)
		{
			if (!IsEntityOnFloor(hitbox, lvlData))
			{
				inAir = true;
			}
		}

		if (inAir && !powerAttackActive)
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
			if (powerAttackActive) // se opreste power attackul daca ajung intr-un perete
			{
				powerAttackActive = false;
				powerAttackTick = 0;
			}
		}
	}

	@Override
	public void tick()
	{

		updateHealthBar();
		updatePowerBar();
		if (currentHealth <= 0 || hitbox.y >= 630)
		{
			playing.setGameOver(true);
			return;
		}

		updateAttackBox();

		updatePos();

		if (moving)
		{
			checkHeartTouched();
			if (powerAttackActive)
			{
				powerAttackTick++;
				if (powerAttackTick >= 35)
				{
					powerAttackTick = 0;
					powerAttackActive = false;
				}
			}
		}
		if (attacking || powerAttackActive)
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
		if (powerAttackActive)
		{
			animPowerAttack.tick();
			if (moving)
			{
				animPowerAttack.tick();
			}
		}

		if (attacking)
		{
			animAttack.tick();
		}
		updateAnimationTick();

	}

	private void checkHeartTouched()
	{
		playing.checkObjTouched(hitbox);
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

		if (powerAttackActive)
		{
			attackChecked = false;
		}
		playing.checkEnemyHit(attackBox);
	}

	private void updateAttackBox()
	{
		if (right && left)
		{
			if (flipW == 1)
			{
				attackBox.x = hitbox.x + hitbox.width + (int)(Game.SCALE * 10);
			}
			else
			{
				attackBox.x = hitbox.x - hitbox.width - (int)(Game.SCALE * 10);
			}
		}
		if (right || (powerAttackActive && flipW == 1))
		{
			attackBox.x = hitbox.x + hitbox.width + (int)(Game.SCALE * 10);
		}
		else if (left || (powerAttackActive && flipW == -1))
		{
			attackBox.x = hitbox.x - hitbox.width - (int)(Game.SCALE * 10);
		}
		attackBox.y = hitbox.y + (Game.SCALE * 10);
	}

	private void updateHealthBar()
	{
		healthWidth = (int)((currentHealth / (float)maxHealth) * healthBarWidth);
	}
	private void updatePowerBar()
	{
		powerWidth = (int) ((powerValue / (float) powerMaxValue) * powerBarWidth); // daca valoarea scade, scade si lungimea barii

		powerGrowTick++;
		if (powerGrowTick >= powerGrowSpeed)
		{
			powerGrowTick = 0;
			changePower(1);
		}
	}

	private void changePower(int value)
	{
		powerValue += value;
		if (powerValue >= powerMaxValue)
		{
			powerValue = powerMaxValue;
		}
		else if (powerValue <= 0)
		{
			powerValue = 0;
		}
	}

	private void drawUI(Graphics g)
	{
		// background ui
		g.drawImage(statusBarImg, statusBarX, statusBarY, statusBarWidth, statusBarHeight, null);

		//health bar
		g.setColor(Color.red);
		g.fillRect(healthBarXStart + statusBarX, healthBarYStart + statusBarY, healthWidth, healthBarHeight);

		// power bar
		g.setColor(Color.yellow);
		g.fillRect(powerBarXStart + statusBarX, powerBarYStart + statusBarY, powerWidth, powerBarHeight);
	}
	public void render(Graphics g)
	{

			if (inAir) {
				if (powerAttackActive) {
					g.drawImage(animPowerAttack.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);

				} else if (airSpeed < 0)
					g.drawImage(animJump.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				else
					g.drawImage(animFall.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
			} else if (powerAttackActive) {
				g.drawImage(animPowerAttack.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);

			} else if (attacking) {
				g.drawImage(animAttack.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
			} else if (moving) {
				if (left) {
					g.drawImage(animLeft.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				} else if (right) {
					g.drawImage(animRight.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				} else if (up) {
					g.drawImage(animUp.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				} else if (down) {
					g.drawImage(animDown.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				} else {
					// daca nu se misca sau nu face altceva, afisam animatia de idle
					g.drawImage(animIdle.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
				}
			} else {
				// daca nu se misca, afisam animatia de idle
				g.drawImage(animIdle.getCurrentFrame(), (int) (screenX - xDrawOffset) + flipX, (int) (screenY - yDrawOffset), width * flipW, height, null);
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
		airSpeed = 0f;
		playerAction = IDLE;
		currentHealth = maxHealth;
		powerValue = powerMaxValue;


		hitbox.x = x;
		hitbox.y = y;

		resetAttackBox();


		if (!IsEntityOnFloor(hitbox,lvlData))
			inAir = true;
	}

	private void resetAttackBox()
	{
		if (flipW == 1)
		{
			attackBox.x = hitbox.x + hitbox.width + (int)(Game.SCALE * 10);
		}
		else
		{
			attackBox.x = hitbox.x - hitbox.width - (int)(Game.SCALE * 10);
		}
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void powerAttack()
	{
		if (powerAttackActive)
			return;
		if (powerValue >= 60)
		{
			powerAttackActive = true;
			changePower(-60);
		}
	}
}