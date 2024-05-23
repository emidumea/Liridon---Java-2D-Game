package GameDev.UI;

import GameDev.Game;
import GameDev.GameStates.Gamestate;
import GameDev.GameStates.Playing;
import GameDev.Graphics.ImageLoader;
import GameDev.Utils.Constants;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import static GameDev.Utils.Constants.UI.PauseButtons.*;
import static GameDev.Utils.Constants.UI.URMButtons.*;
import static GameDev.Utils.Constants.UI.VolumeButtons.*;

public class PauseOverlay
{
	private Playing playing;
	private BufferedImage backgroundImg;
	private int bgX, bgY, bgW, bgH;
	private SoundButton musicButton, sfxButton;
	private UrmButton menuB, replayB, unpauseB;
	private VolumeButton volumeButton;

	public PauseOverlay(Playing playing)
	{
		this.playing = playing;
		loadBackground();
		createSoundButtons();
		createUrmButtons();
		createVolumeButton();
	}

	private void createVolumeButton()
	{
		int vX = (int) (515 * Game.SCALE);
		int vY = (int) (303 * Game.SCALE);
		volumeButton = new VolumeButton(vX, vY, SLIDER_WIDTH, VOLUME_HEIGHT);
	}

	private void createUrmButtons()
	{
		int menuX = (int) (520 * Game.SCALE);
		int replayX = (int) (594 * Game.SCALE);
		int unpauseX = (int) (668 * Game.SCALE);
		int bY = (int) (350 * Game.SCALE);

		menuB = new UrmButton(menuX, bY, URM_SIZE, URM_SIZE, 2);
		replayB = new UrmButton(replayX, bY, URM_SIZE, URM_SIZE, 1);
		unpauseB = new UrmButton(unpauseX, bY, URM_SIZE, URM_SIZE, 0);

	}

	private void createSoundButtons()
	{
		int soundX = (int) (660 * Game.SCALE);
		int musicY = (int) (165 * Game.SCALE);
		int sfxY = (int) (210 * Game.SCALE);
		musicButton = new SoundButton(soundX, musicY, SOUND_SIZE, SOUND_SIZE);
		sfxButton = new SoundButton(soundX, sfxY, SOUND_SIZE, SOUND_SIZE);
	}

	private void loadBackground()
	{
		backgroundImg = ImageLoader.LoadImage("/ui/pause_menu.png");
		bgW = (int) (backgroundImg.getWidth() * Game.SCALE);
		bgH = (int) (backgroundImg.getHeight() * Game.SCALE);
		bgX = Game.GAME_WIDTH / 2 - bgW / 2;
		bgY = (int) (50 * Game.SCALE);
	}

	public void update()
	{
		musicButton.update();
		sfxButton.update();

		menuB.update();
		replayB.update();
		unpauseB.update();

		volumeButton.update();
	}

	public void draw(Graphics g)
	{
		// background
		g.drawImage(backgroundImg, bgX, bgY, bgW, bgH, null);

		// sound buttons
		musicButton.draw(g);
		sfxButton.draw(g);

		// UrmButtons
		menuB.draw(g);
		replayB.draw(g);
		unpauseB.draw(g);

		// volume slider
		volumeButton.draw(g);
	}

	public void mouseDragged(MouseEvent e)
	{
		if (volumeButton.isMousePressed())
		{
			volumeButton.changeX(e.getX());
		}
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse clic");
	}


	public void mousePressed(MouseEvent e)
	{
		if (isIn(e,musicButton))
		{
			musicButton.setMousePressed(true);
		}
		else if (isIn(e, sfxButton))
		{
			sfxButton.setMousePressed(true);
		}
		else if (isIn(e, menuB))
		{
			menuB.setMousePressed(true);
		}
		else if (isIn(e, replayB))
		{
			replayB.setMousePressed(true);
		}
		else if (isIn(e, unpauseB))
		{
			unpauseB.setMousePressed(true);
		}
		else if (isIn(e, volumeButton))
		{
			volumeButton.setMousePressed(true);
		}
	}

	public void mouseReleased(MouseEvent e)
	{
		if (isIn(e,musicButton))
		{
			if (musicButton.isMousePressed())
			{
				musicButton.setMuted(!musicButton.isMuted());
			}
		}
		else if (isIn(e, sfxButton))
		{
			if (sfxButton.isMousePressed())
			{
				sfxButton.setMuted(!sfxButton.isMuted());
			}
		}
		else if (isIn(e, menuB))
		{
			if (menuB.isMousePressed())
			{
				Gamestate.state = Gamestate.MENU;
				playing.resetAll();
				playing.unpauseGame();
			}
		}
		else if (isIn(e, replayB))
		{
			if (replayB.isMousePressed())
			{
				playing.resetAll();
				playing.unpauseGame();
			}
		}
		else if (isIn(e, unpauseB))
		{
			if (unpauseB.isMousePressed())
			{
				playing.unpauseGame();
			}
		}


		musicButton.resetBools();
		sfxButton.resetBools();
		menuB.resetBools();
		replayB.resetBools();
		unpauseB.resetBools();
		volumeButton.resetBools();
	}


	public void mouseMoved(MouseEvent e)
	{
		musicButton.setMouseOver(false);
		sfxButton.setMouseOver(false);
		menuB.setMouseOver(false);
		replayB.setMouseOver(false);
		unpauseB.setMouseOver(false);
		volumeButton.setMouseOver(false);

		if (isIn(e,musicButton))
		{
			musicButton.setMouseOver(true);
		}
		else if (isIn(e, sfxButton))
		{
			sfxButton.setMouseOver(true);
		}
		else if (isIn(e, menuB))
		{
			menuB.setMouseOver(true);
		}
		else if (isIn(e, replayB))
		{
			replayB.setMouseOver(true);
		}
		else if (isIn(e, unpauseB))
		{
			unpauseB.setMouseOver(true);
		}
		else if (isIn(e, volumeButton))
		{
			volumeButton.setMouseOver(true);
		}
	}

	private boolean isIn(MouseEvent e, PauseButton b)
	{
		return b.getBounds().contains(e.getX(), e.getY());
	}

}
