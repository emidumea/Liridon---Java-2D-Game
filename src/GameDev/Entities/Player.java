package GameDev.Entities;

import GameDev.Game;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import java.awt.*;
import static GameDev.Utils.HelpMethods.*;

public class Player extends Entity
{
	private Animation animIdle, animUp, animLeft, animRight, animDown, animAttack, animJump, animFall; // 20 29
	private boolean moving = false, attacking = false;
	private boolean left, right, up, down, jump;
	private float speed = 2.0f;
	private int[][] lvlData;
	private float xDrawOffset = 20 * Game.SCALE;
	private float yDrawOffset = 6 * Game.SCALE;
	public final int screenX;
	public final int screenY;

	//// Jumping and Gravity
	private float airSpeed = 0f;
	private float gravity = 0.04f * Game.SCALE;
	private float jumpSpeed = -3.40f * Game.SCALE;
	private float fallSpeedAfterCollision = 0.5f * Game.SCALE;
	private boolean inAir = false;

	public Player(float x, float y, int width, int height)
	{
		super(x,y,width,height);
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
		initHitbox(x, y, 20 * Game.SCALE, 28 * Game.SCALE);
	}

	/*private void updatePos()
	{
		moving = false;
		float dx = 0, dy = 0;
		if (left && !right)
		{
			dx -= speed;
			moving = true;

		}
		else if (right && !left)
		{
			dx += speed;
			moving = true;
		}
		if (up && !down)
		{
			dy -= speed;
			moving = true;
		}
		else if (down && !up)
		{
			dy += speed;
			moving = true;
		}
		x += dx;
		y += dy;
	}*/

	/*private void updatePos()
	{
		moving = false;
		//if (!left && !right && !up && !down)
			//return;

		float dx = 0, dy = 0;
		if (left && !right)
		{
			dx = -speed;
			//moving = true;
		}
		else if (right && !left)
		{
			dx = speed;
			//moving = true;
		}

		if (up && !down)
		{
			dy = -speed;
			//moving = true;
		}
		else if (down && !up)
		{
			dy = speed;
			//moving = true;
		}

//		if(CanMoveHere(x + dx, y + dy, width, height ,lvlData))
//		{
//			this.x += dx;
//			this.y += dy;
//			moving = true;
//		}
//		else
//		{
//			System.out.println("coliziune.....");
//		}
//		if(CanMoveHere(hitbox.x + dx, hitbox.y + dy, hitbox.width , hitbox.height ,lvlData))
//		{
//			hitbox.x += dx;
//			hitbox.y += dy;
//			moving = true;
//		}
//		else
//		{
//			System.out.println("coliziune.....");
//		}
		x += dx;
		y += dy;
	}*/
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
		}
		else if (right)
		{
			dx += speed;
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
				airSpeed += gravity;
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
		updatePos();
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

	}

	public void render(Graphics g)
	{
		if (inAir)
		{
			if (airSpeed < 0)
				g.drawImage(animJump.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			else
				g.drawImage(animFall.getCurrentFrame(),(int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
		}
		else if (attacking)
		{
			g.drawImage(animAttack.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
		}
		else if (moving)
		{
			if (left)
			{
				g.drawImage(animLeft.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			}
			else if (right)
			{
				g.drawImage(animRight.getCurrentFrame(),  (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			}
			else if (up)
			{
				g.drawImage(animUp.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			}
			else if (down)
			{
				g.drawImage(animDown.getCurrentFrame(),  (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			}
			else
			{
				// Dacă jucătorul nu se mișcă și nicio direcție nu este activă,
				// se va afișa starea de repaus
				g.drawImage(animIdle.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
			}
		}
		else
		{
			// Dacă jucătorul nu se mișcă, se va afișa starea de repaus
			g.drawImage(animIdle.getCurrentFrame(), (int) (screenX - xDrawOffset),(int) (screenY - yDrawOffset), width, height, null);
		}
		drawHitbox(g);
	}

	/*public void render(Graphics g)
	{
		if (inAir)
		{
			if (airSpeed < 0)
				g.drawImage(animJump.getCurrentFrame(),(int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			else
				g.drawImage(animFall.getCurrentFrame(),(int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
		}
		else if (attacking)
		{
			g.drawImage(animAttack.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
		}
		else if (moving)
		{
			if (left)
			{
				g.drawImage(animLeft.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			}
			else if (right)
			{
				g.drawImage(animRight.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			}
			else if (up)
			{
				g.drawImage(animUp.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			}
			else if (down)
			{
				g.drawImage(animDown.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			}
			else
			{
				// Dacă jucătorul nu se mișcă și nicio direcție nu este activă,
				// se va afișa starea de repaus
				g.drawImage(animIdle.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
			}
		}
		else
		{
			// Dacă jucătorul nu se mișcă, se va afișa starea de repaus
			g.drawImage(animIdle.getCurrentFrame(), (int) (hitbox.x - xDrawOffset), (int) (hitbox.y - yDrawOffset), width, height, null);
		}

	}*/
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
}