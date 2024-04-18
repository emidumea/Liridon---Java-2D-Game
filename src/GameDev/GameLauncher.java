package GameDev;

public class GameLauncher
{
	public static void main (String[] args)
	{
		Game game = new Game("Liridon",Game.GAME_WIDTH,Game.GAME_HEIGHT);
		game.StartGame();
	}
}
