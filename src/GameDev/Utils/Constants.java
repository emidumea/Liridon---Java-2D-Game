package GameDev.Utils;

import GameDev.Game;

public class Constants
{
	public static class EnemyConstants
	{
		public static final int SKELETON1 = 0;
		public static final int SKELETON_WIDTH_DEFAULT = 128;
		public static final int SKELETON_HEIGHT_DEFAULT = 96;
		public static final int SKELETON_WIDTH = (int) (SKELETON_WIDTH_DEFAULT * Game.SCALE);
		public static final int SKELETON_HEIGHT = (int) (SKELETON_HEIGHT_DEFAULT * Game.SCALE);

		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

//		public static final int SKELETON_DRAWOFFSET_X = (int) (75 * Game.SCALE);
//		public static final int SKELETON_DRAWOFFSET_Y = (int) (36 * Game.SCALE);
		public static final int HYENA = 0;
		public static final int HYENA_WIDTH_DEFAULT = 48;
		public static final int HYENA_HEIGHT_DEFAULT = 48;
		public static final int HYENA_WIDTH = (int) (HYENA_WIDTH_DEFAULT * Game.SCALE);
		public static final int HYENA_HEIGHT = (int) (HYENA_HEIGHT_DEFAULT * Game.SCALE);
		public static final int HYENA_DRAWOFFSET_X = (int) (5 * Game.SCALE);
		public static final int HYENA_DRAWOFFSET_Y = (int) (21 * Game.SCALE);
		public static int GetSpriteAmount(int enemy_type, int enemy_state) {

			switch (enemy_type)
			{
				case SKELETON1:
					switch (enemy_state)
					{
						case IDLE:
							return 9;
						case RUNNING:
							return 6;
						case ATTACK:
							return 7;
						case HIT:
							return 4;
						case DEAD:
							return 5;
					}
			}

			return 0;

		}
	}

	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

}
