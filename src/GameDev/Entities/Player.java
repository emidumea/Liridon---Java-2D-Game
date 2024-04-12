package GameDev.Entities;

import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Utils.HelpMethods.*;
import java.awt.*;

import static GameDev.Utils.HelpMethods.CanMoveHere;

public class Player extends Entity
{
	private Animation animIdle, animUp, animLeft, animRight, animDown, animAttack;
	private boolean moving = false, attacking = false;
	private boolean left,right,up,down;
	private float speed = 2.0f;
	private int[][] lvlData;
	public Player(float x, float y, int width, int height)
	{
		super(x,y,width,height);
		animIdle = new Animation(Assets.player_idle,100);
		animUp = new Animation(Assets.player_up,100);
		animLeft = new Animation(Assets.player_up,100);
		animRight = new Animation(Assets.player_up,100);
		animAttack = new Animation(Assets.player_attack,100);
		animDown = new Animation(Assets.player_up,100);
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

	private void updatePos()
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

		if(CanMoveHere(x + dx, y + dy, width, height ,lvlData))
		{
			this.x += dx;
			this.y += dy;
			moving = true;
		}
		else
		{
			System.out.println("coliziune.....");
		}
	//	x += dx;
		//y += dy;
	}

	@Override
	public void tick()
	{
		updatePos();
		updateHitbox();
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
		if (attacking)
		{
			animAttack.tick();
		}

	}

	public void render(Graphics g)
	{
		if (attacking)
		{
			g.drawImage(animAttack.getCurrentFrame(), (int) x, (int) y,null);
		}
		else if (moving) {
			if (left)
			{
				g.drawImage(animLeft.getCurrentFrame(), (int) x, (int) y, null);
			} else if (right)
			{
				g.drawImage(animRight.getCurrentFrame(), (int) x, (int) y, null);
			} else if (up)
			{
				g.drawImage(animUp.getCurrentFrame(), (int) x, (int) y, null);
			} else if (down)
			{
				g.drawImage(animDown.getCurrentFrame(), (int) x, (int) y, null);
			} else
			{
				// Dacă jucătorul nu se mișcă și nicio direcție nu este activă,
				// se va afișa starea de repaus
				g.drawImage(animIdle.getCurrentFrame(), (int) x, (int) y, null);
			}
		}
		else
		{
			// Dacă jucătorul nu se mișcă, se va afișa starea de repaus
			g.drawImage(animIdle.getCurrentFrame(), (int) x, (int) y, null);
		}
		drawHitbox(g);
	}
	public void loadLvlData(int [][] lvlData)
	{
		this.lvlData = lvlData;
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
}
