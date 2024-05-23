package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;

import static GameDev.Utils.Constants.Directions.*;
import static GameDev.Utils.Constants.EnemyConstants.*;
import static GameDev.Utils.Constants.GRAVITY;
import static GameDev.Utils.HelpMethods.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static GameDev.Utils.HelpMethods.*;
import static GameDev.Utils.HelpMethods.IsEntityOnFloor;

public abstract class Enemy extends Entity {
	protected int enemyState, enemyType;
	protected Animation animIdle, animUp, animLeft, animRight, animDown, animAttack, animJump, animFall, animHit, animDie; // 20 29
	protected int aniSpeed = 25;
	protected Playing playing;
	protected boolean firstUpdate = true;
	protected boolean inAir = false;
	protected float fallSpeed;
	protected float walkSpeed = 0.8f * Game.SCALE;
	protected int walkDir = LEFT;
	protected int tileY;
	protected float attackDistance = Game.TILES_SIZE / 3;
	protected int[][] lvlData;
	protected int maxHealth;
	protected int currentHealth;
	protected boolean active = true;
	protected boolean attackChecked;

	public Enemy(float x, float y, int width, int height, int enemyType, Playing playing) {
		super(x, y, width, height);
		this.playing = playing;
		this.enemyType = enemyType;
		initHitbox(x, y, width, height);
		maxHealth = GetMaxHealth(enemyType);
		currentHealth = maxHealth;

	}
	public Playing getPlaying()
	{
		return this.playing;
	}

	protected void firstUpdateCheck(int [][] lvlData)
	{
		if (firstUpdate)
		{
			if (!IsEntityOnFloor(hitbox, lvlData)) {
				inAir = true;
			}
			firstUpdate = false;
		}
	}

	protected void updateInAir(int [][] lvlData)
	{
		if (inAir)
		{
			if (CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData))
			{
				hitbox.y += fallSpeed;
				fallSpeed += GRAVITY;
			} else
			{
				inAir = false;
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, fallSpeed);
				tileY = (int) (hitbox.y / Game.TILES_SIZE); // pt a afla tile-ul Y pt inamic
			}
		}
	}

	protected void move(int [][] lvlData)
	{
		float xSpeed = 0;

		if (walkDir == LEFT)
			xSpeed = -walkSpeed;
		else
			xSpeed = walkSpeed;

		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
		{
			if (IsFloor(hitbox, xSpeed, lvlData))
			{
				hitbox.x += xSpeed;
				return;
			}
		}

		changeWalkDir();

	}

	protected void turnTowardsPlayer(Player player)
	{
		if (player.hitbox.x > hitbox.x)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}

	protected boolean canSeePlayer(int[][] lvlData, Player player)
	{
		int playerTileY = (int) (player.getHitbox().y / Game.TILES_SIZE);
		if (playerTileY == tileY)
		{
			if (isPlayerInRange(player))
			{
				if (IsSightClear(lvlData, hitbox, player.hitbox, tileY)) //fara prapastii, obiecte in cale
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isPlayerInRange(Player player)
	{
		int absVal = (int) Math.abs(player.hitbox.x - hitbox.x);
		return absVal <= attackDistance * 20;
	}

	protected boolean isPlayerCloseForAttack(Player player)
	{
		int absVal = (int) Math.abs(player.hitbox.x - hitbox.x);
		int absVal2 = (int) Math.abs(player.hitbox.y - hitbox.y);
		return absVal <= attackDistance && absVal2 <= attackDistance;
		//return absVal <= attackDistance;
	}

	protected void newState(int enemyState)
	{
		this.enemyState = enemyState;
		aniTick = 0;
		aniIndex = 0;
	}

	public void hurt(int damage)
	{
		currentHealth -= damage;
		if (currentHealth <= 0)
		{
			newState(DEAD);
		}
		else
		{
			newState(HIT);
		}
	}
	protected void checkEnemyHit(Rectangle2D.Float attackBox,Player player)
	{
		if (attackBox.intersects(player.hitbox))
			player.changeHealth(-GetEnemyDmg(enemyType));
		attackChecked = true;
	}

	protected void updateAnimationTick()
	{
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(enemyType, enemyState)) {
				aniIndex = 0;
			}
		}
	}

	public int getAniIndex() {
		return aniIndex;
	}

	public int getEnemyState() {
		return enemyState;
	}

	protected void changeWalkDir()
	{
		if (walkDir == LEFT)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}

	@Override
	public abstract void render(Graphics g); //{
////		int screenX = (int) (hitbox.x - getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
////		int screenY = (int) (hitbox.y - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
//		int screenX = (int) (getHitbox().x -  getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
//		int screenY = (int) (getHitbox().y  - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
//		g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X, screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT, HYENA_HEIGHT_DEFAULT, null);
//	}

	public boolean isActive()
	{
		return active;
	}

	public void resetEnemy()
	{
		hitbox.x = x;
		hitbox.y = y;
		firstUpdate = true;
		currentHealth = maxHealth;
		newState(IDLE);
		active = true;
		fallSpeed = 0;
	}

	public int getEnemyType() {
		return enemyType;
	}
}
