package GameDev.Utils;

import GameDev.Game;

public class Constants
{
	public static final float GRAVITY = 0.04f * Game.SCALE;
	public static class UI
	{
		public static class Buttons
		{
			public static final int B_WIDTH_DEFAULT = 300;
			public static final int B_HEIGHT_DEFAULT = 120;
			public static final int B_WIDTH = (int) (B_WIDTH_DEFAULT * Game.SCALE);
			public static final int B_HEIGHT = (int) (B_HEIGHT_DEFAULT * Game.SCALE);
		}
		public static class PauseButtons
		{
			public static final int SOUND_SIZE_DEFAULT = 42;
			public static final int SOUND_SIZE = (int) (SOUND_SIZE_DEFAULT * Game.SCALE);

		}

		public static class URMButtons
		{
			public static final int URM_DEFAULT_SIZE = 56;
			public static final int URM_SIZE = (int) (URM_DEFAULT_SIZE * Game.SCALE);
		}
		public static class VolumeButtons
		{
			public static final int VOLUME_DEFAULT_WIDTH = 28;
			public static final int VOLUME_DEFAULT_HEIGHT = 44;
			public static final int SLIDER_DEFAULT_WIDTH = 215;
			public static final int VOLUME_WIDTH = (int) (VOLUME_DEFAULT_WIDTH * Game.SCALE);
			public static final int VOLUME_HEIGHT = (int) (VOLUME_DEFAULT_HEIGHT * Game.SCALE);
			public static final int SLIDER_WIDTH = (int) (SLIDER_DEFAULT_WIDTH * Game.SCALE);


		}
	}
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
		public static final int HURT = 5;

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
//				case SKELETON1:
//					switch (enemy_state)
//					{
//						case IDLE:
//							return 9;
//						case RUNNING:
//							return 6;
//						case ATTACK:
//							return 7;
//						case HIT:
//							return 4;
//						case DEAD:
//							return 5;
//					}
				case HYENA:
					switch (enemy_state)
					{
						case IDLE:
							return 4;
						case RUNNING:
							return 6;
						case ATTACK:
							return 6;
						case HIT:
							return 2;
						case DEAD:
							return 6;
					}
			}

			return 0;

		}
		public static int GetMaxHealth(int enemy_type)
		{
			switch(enemy_type) {
				case HYENA:
					return 10;
				default:
					return 0;
			}
		}

		public static int GetEnemyDmg(int enemy_type)
		{
			switch(enemy_type) {
				case HYENA:
					return 15;
				default:
					return 0;
			}
		}
	}
	public static class PlayerConstants {
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int JUMP = 2;
		public static final int FALLING = 3;
		public static final int ATTACK = 4;
		public static final int HIT = 5;
		public static final int DEAD = 6;

		public static int GetSpriteAmount(int player_action) {
			switch (player_action) {
				case DEAD:
					return 4;
				case RUNNING:
					return 6;
				case IDLE:
					return 4;
				case HIT:
					return 4;
				case JUMP:
				case ATTACK:
					return 5;
				case FALLING:
				default:
					return 1;
			}
		}
	}
	public static class Directions {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}

}
