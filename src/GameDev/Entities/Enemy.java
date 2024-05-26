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
	protected int maxHealth;
	protected int currentHealth;
	protected boolean active = true;
	protected boolean attackChecked;
	protected Rectangle2D.Float attackBox;
	protected int attackBoxOffsetX;

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
			if (CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData)) // verifica daca inamicul poate sa se mute in jos fara sa loveasca vreun obstacol
			{
				hitbox.y += fallSpeed;
				fallSpeed += GRAVITY; // creste viteza de cadere
			} else
			{
				inAir = false;
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, fallSpeed); // ajustam y pt a fi la nivelul podelei
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

		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData)) // verificam daca ne putem muta in directia dorita
		{
			if (IsFloor(hitbox, xSpeed, lvlData)) // verificam daca este podea in acea directie
			{
				hitbox.x += xSpeed;
				return;
			}
		}

		changeWalkDir();

	}

	protected void turnTowardsPlayer(Player player)
	{
		// compara pozitiile pe axa x ale jucatorului si inamicului
		// seteaza directia de mers a inamicului in functie de pozitia jucatorului
		if (player.hitbox.x > hitbox.x)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}

	protected boolean canSeePlayer(int[][] lvlData, Player player)
	{
		// calculeaza tile-ul pe axa y pe care sa afla jucatorul
		int playerTileY = (int) (player.getHitbox().y / Game.TILES_SIZE);
		if (playerTileY == tileY) // daca e egal cu cel al inamicului, inseamna ca sunt la aceeasi inaltime
		{
			if (isPlayerInRange(player)) // daca playerul e in apropierea inamicului
			{
				if (IsSightClear(lvlData, hitbox, player.hitbox, tileY)) //fara prapastii, obiecte in cale
				{
					return true;
				}
			}
		}
		return false;
	}

	private boolean isPlayerInRange(Player player) // verifica daca jucatorul e in raza de atac a inamicului
	{
		// calculam distanta intre pozitiile pe axa x ale jucatorului si inamicului
		int absVal = (int) Math.abs(player.hitbox.x - hitbox.x);
		return absVal <= attackDistance * 20;
	}

	protected boolean isPlayerCloseForAttack(Player player) // verifica daca jucatorul e suficient de aproape pt a fi atacat
	{
		int absVal = (int) Math.abs(player.hitbox.x - hitbox.x);
		int absVal2 = (int) Math.abs(player.hitbox.y - hitbox.y);
		return absVal <= attackDistance && absVal2 <= attackDistance;
		//return absVal <= attackDistance;
	}

	protected void newState(int enemyState) // schimba starea si reseteaza animatia
	{
		this.enemyState = enemyState;
		aniTick = 0;
		aniIndex = 0;
	}
	public abstract void update(int[][] lvlData, Player player);
	public void hurt(int damage) // aplica damage asupra inamicului
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
	protected void checkEnemyHit(Rectangle2D.Float attackBox,Player player) // verifica daca inamicul a lovit jucatorul
	{
		if (attackBox.intersects(player.hitbox)) // vedem daca se intersecteaza hitboxul de atack cu hitboxul playerului
			player.changeHealth(-GetEnemyDmg(enemyType)); // daca da, scadem viata
		attackChecked = true;
	}

	protected void updateAnimationTick() // actualizeaza animatia inamicului
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

	protected void changeWalkDir() // schimba directia de mers
	{
		if (walkDir == LEFT)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}


	public abstract void render(Graphics g);

	public boolean isActive()
	{
		return active;
	}

	public void resetEnemy() // reseteaza inamicul la starea initiala
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
