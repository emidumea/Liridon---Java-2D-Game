package GameDev;

public class GameLauncher
{
	public static void main (String[] args)
	{
		//GameWindow wnd = new GameWindow("ABC",800,600);
	//	wnd.BuildGameWindow();
	//	wnd.getFrame().addKeyListener(new KeyboardInput());
	//	wnd.getFrame().addMouseListener(new MouseInput());
	//	wnd.getFrame().addMouseMotionListener(new MouseInput());
		Game game = new Game("Liridon",Game.TILES_IN_WIDTH,Game.TILES_IN_HEIGHT);
		game.StartGame();
	}
}
