package GameDev.GameStates;

import GameDev.Entities.Player;
import GameDev.Game;
import GameDev.Tiles.Tile;
import GameDev.Tiles.TileManager;

import javax.swing.plaf.nimbus.State;

public class Playing
{
	/*private Player player;
	public static int xLvlOffset;
	private int leftBorder = (int) (0.2 * Game.GAME_WIDTH);
	private int rightBorder = (int) (0.8 * Game.GAME_WIDTH);
	//private int lvlTilesWide = player.getLvlData()[0].length;
	private int maxTilesOffset = lvlTilesWide - Game.TILES_IN_WIDTH;
	private int maxLvlOffsetX = maxTilesOffset * Game.TILES_SIZE;

	public void checkCloseToBorder()
	{
		int playerX = (int) player.getHitbox().x;
		int diff = playerX - xLvlOffset;

		if ( diff > rightBorder)
			xLvlOffset += diff - rightBorder;
		else if ( diff < leftBorder)
			xLvlOffset += diff - leftBorder;

		if (xLvlOffset > maxLvlOffsetX)
			xLvlOffset =maxLvlOffsetX;
		else if (xLvlOffset < 0)
			xLvlOffset = 0;
	}
*/
}
