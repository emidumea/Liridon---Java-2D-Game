package GameDev.Graphics;

import java.awt.image.BufferedImage;

public class Animation
{
	private BufferedImage[] frames;
	private int currentFrame = 0;
	private int speed;
	private long lastTime,timer;
	public Animation(BufferedImage[] frames,int speed)
	{
		this.frames = frames;
		this.speed = speed;
		currentFrame = 0;
	}

	public void tick()
	{
		timer += System.currentTimeMillis() - lastTime; //timpul dintre tick-uri
		lastTime = System.currentTimeMillis();

		if (timer > speed)
		{
			currentFrame++;
			timer = 0;
		}
		if (currentFrame >= frames.length)
		{
			currentFrame = 0;
		}
	}

	public BufferedImage getCurrentFrame() {return frames[currentFrame];}
	public boolean isAnimationFinished() {
		return currentFrame >= frames.length - 1;
	}

	public void setCurrentFrame(int i)
	{
		if ( i >= 0 && i < frames.length)
			currentFrame = i;
	}
}
