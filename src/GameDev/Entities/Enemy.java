package GameDev.Entities;

import GameDev.Game;
import GameDev.GameStates.Playing;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;

import static GameDev.Utils.Constants.Directions.*;
import static GameDev.Utils.Constants.EnemyConstants.*;
import static GameDev.Utils.HelpMethods.*;

import java.awt.*;

import static GameDev.Utils.HelpMethods.*;
import static GameDev.Utils.HelpMethods.IsEntityOnFloor;

public abstract class Enemy extends Entity {
	private int aniIndex, enemyState, enemyType;
	protected Animation animIdle, animUp, animLeft, animRight, animDown, animAttack, animJump, animFall; // 20 29
	private int aniTick, aniSpeed = 25;
	private Playing playing;
	private boolean firstUpdate = true;
	private boolean inAir = false;
	private float fallSpeed;
	private float gravity = 0.04f * Game.SCALE;
	private float walkSpeed = 0.8f * Game.SCALE;
	private int walkDir = LEFT;
	private int[][] lvlData;

	public Enemy(float x, float y, int width, int height, int enemyType, Playing playing) {
		super(x, y, width, height);
		this.playing = playing;
		this.enemyType = enemyType;
		initHitbox(x, y, width, height);

	}
	public Playing getPlaying()
	{
		return this.playing;
	}

	private void updateAnimationTick() {
		aniTick++;
		if (aniTick >= aniSpeed) {
			aniTick = 0;
			aniIndex++;
			if (aniIndex >= GetSpriteAmount(enemyType, enemyState)) {
				aniIndex = 0;
			}
		}
	}


	public void update(int [][] lvlData)
	{
		updateMove(lvlData);
		animLeft.tick();
	}

	public int getAniIndex() {
		return aniIndex;
	}

	public int getEnemyState() {
		return enemyState;
	}
	private void updateMove(int[][] lvlData)
	{
		if (firstUpdate) {
			if (!IsEntityOnFloor(hitbox, lvlData))
				inAir = true;
			firstUpdate = false;
		}

		if (inAir) {
			if (CanMoveHere(hitbox.x, hitbox.y + fallSpeed, hitbox.width, hitbox.height, lvlData)) {
				hitbox.y += fallSpeed;
				fallSpeed += gravity;
			} else {
				inAir = false;
				hitbox.y = GetEntityYPosUnderRoofOrAboveFloor(hitbox, fallSpeed);
			}
		} else {
			switch (enemyState) {
				case IDLE:
					enemyState = RUNNING;
					break;
				case RUNNING:
					float xSpeed = 0;

					if (walkDir == LEFT)
						xSpeed = -walkSpeed;
					else
						xSpeed = walkSpeed;

					if (CanMoveHere(hitbox.x + xSpeed, hitbox.y, hitbox.width, hitbox.height, lvlData))
						if (IsFloor(hitbox, xSpeed, lvlData)) {
							hitbox.x += xSpeed;
							return;
						}

					changeWalkDir();

					break;
			}
		}


	}

	private void changeWalkDir()
	{
		if (walkDir == LEFT)
			walkDir = RIGHT;
		else
			walkDir = LEFT;
	}

	@Override
	public void render(Graphics g) {
//		int screenX = (int) (hitbox.x - getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
//		int screenY = (int) (hitbox.y - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
		int screenX = (int) (getHitbox().x -  getPlaying().getPlayer().getHitboxX() + getPlaying().getPlayer().screenX);
		int screenY = (int) (getHitbox().y  - getPlaying().getPlayer().getHitboxY() + getPlaying().getPlayer().screenY);
		g.drawImage(animLeft.getCurrentFrame(), screenX - HYENA_DRAWOFFSET_X, screenY - HYENA_DRAWOFFSET_Y, HYENA_WIDTH_DEFAULT, HYENA_HEIGHT_DEFAULT, null);
	}
}
