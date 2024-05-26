package GameDev.Utils;

import GameDev.Game;

public class Constants
{
	public static final float GRAVITY = 0.04f * Game.SCALE;

	public static class ObjectConstants {

		public static final int SLIVER_COIN = 0;
		public static final int GOLD_COIN = 1;
		public static final int HEART = 2;
		public static final int BOX = 3;

		public static final int HEART_VALUE = 15;
		public static final int BLUE_POTION_VALUE = 10;

		public static final int HEART_WIDTH_DEFAULT = 32;
		public static final int HEART_HEIGHT_DEFAULT = 32;
		public static final int HEART_WIDTH = (int) (Game.SCALE * HEART_WIDTH_DEFAULT);
		public static final int HEART_HEIGHT = (int) (Game.SCALE * HEART_HEIGHT_DEFAULT);

		public static final int COIN_WIDTH_DEFAULT = 16;
		public static final int COIN_HEIGHT_DEFAULT = 16;
		public static final int COIN_WIDTH = (int) (Game.SCALE * COIN_WIDTH_DEFAULT);
		public static final int COIN_HEIGHT = (int) (Game.SCALE * COIN_HEIGHT_DEFAULT);

		public static int GetSpriteAmount(int object_type)
		{
			switch (object_type) {
				case SLIVER_COIN, GOLD_COIN:
					return 5;
				case HEART:
					return 2;
			}
			return 1;
		}
	}

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
		public static final int IDLE = 0;
		public static final int RUNNING = 1;
		public static final int ATTACK = 2;
		public static final int HIT = 3;
		public static final int DEAD = 4;

		// ----------------------------------- skeleton
		public static final int SKELETON = 1;
		public static final int SKELETON_WIDTH_DEFAULT = 48;
		public static final int SKELETON_HEIGHT_DEFAULT = 48;
		public static final int SKELETON_WIDTH = (int) (SKELETON_WIDTH_DEFAULT * Game.SCALE);
		public static final int SKELETON_HEIGHT = (int) (SKELETON_HEIGHT_DEFAULT * Game.SCALE);

		public static final int SKELETON_DRAWOFFSET_X = (int) (5 * Game.SCALE);
		public static final int SKELETON_DRAWOFFSET_Y = (int) (18 * Game.SCALE);

		// --------------------------------------------- hyena
		public static final int HYENA = 0;
		public static final int HYENA_WIDTH_DEFAULT = 48;
		public static final int HYENA_HEIGHT_DEFAULT = 48;
		public static final int HYENA_WIDTH = (int) (HYENA_WIDTH_DEFAULT * Game.SCALE);
		public static final int HYENA_HEIGHT = (int) (HYENA_HEIGHT_DEFAULT * Game.SCALE);
		public static final int HYENA_DRAWOFFSET_X = (int) (5 * Game.SCALE);
		public static final int HYENA_DRAWOFFSET_Y = (int) (21 * Game.SCALE);

		// ------------------------------------------------- mummy
		public static final int MUMMY = 2;
		public static final int MUMMY_WIDTH_DEFAULT = 48;
		public static final int MUMMY_HEIGHT_DEFAULT = 48;
		public static final int MUMMY_WIDTH = (int) (MUMMY_WIDTH_DEFAULT * Game.SCALE);
		public static final int MUMMY_HEIGHT = (int) (MUMMY_HEIGHT_DEFAULT * Game.SCALE);
		public static final int MUMMY_DRAWOFFSET_X = (int) (17 * Game.SCALE);
		public static final int MUMMY_DRAWOFFSET_Y = (int) (14 * Game.SCALE);

		// ----------------------------------------------------- undead
		public static final int UNDEAD = 3;
		public static final int UNDEAD_WIDTH_DEFAULT = 48;
		public static final int UNDEAD_HEIGHT_DEFAULT = 48;
		public static final int UNDEAD_WIDTH = (int) (UNDEAD_WIDTH_DEFAULT * Game.SCALE);
		public static final int UNDEAD_HEIGHT = (int) (UNDEAD_HEIGHT_DEFAULT * Game.SCALE);
		public static final int UNDEAD_DRAWOFFSET_X = (int) (17 * Game.SCALE);
		public static final int UNDEAD_DRAWOFFSET_Y = (int) (14 * Game.SCALE);

		// ------------------------------------------------------------ centipede
		public static final int CENTIPEDE = 4;
		public static final int CENTIPEDE_WIDTH_DEFAULT = 72;
		public static final int CENTIPEDE_HEIGHT_DEFAULT = 48;
		public static final int CENTIPEDE_WIDTH = (int) (CENTIPEDE_WIDTH_DEFAULT * Game.SCALE);
		public static final int CENTIPEDE_HEIGHT = (int) (CENTIPEDE_HEIGHT_DEFAULT * Game.SCALE);
		public static final int CENTIPEDE_DRAWOFFSET_X = (int) (26 * Game.SCALE);
		public static final int CENTIPEDE_DRAWOFFSET_Y = (int) (12 * Game.SCALE);
		// ----------------------------------------------------------------- bloated
		public static final int BLOATED = 5;
		public static final int BLOATED_WIDTH_DEFAULT = 72;
		public static final int BLOATED_HEIGHT_DEFAULT = 48;
		public static final int BLOATED_WIDTH = (int) (BLOATED_WIDTH_DEFAULT * Game.SCALE);
		public static final int BLOATED_HEIGHT = (int) (BLOATED_HEIGHT_DEFAULT * Game.SCALE);
		public static final int BLOATED_DRAWOFFSET_X = (int) (26 * Game.SCALE);
		public static final int BLOATED_DRAWOFFSET_Y = (int) (12 * Game.SCALE);

		public static int GetSpriteAmount(int enemy_type, int enemy_state) {

			switch (enemy_type)
			{
				case SKELETON:
					switch (enemy_state)
					{

						case IDLE:
							return 4;
						case RUNNING:
							return 4;
						case ATTACK:
							return 8;
						case HIT:
							return 4;
						case DEAD:
							return 3;
					}
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
							return 4;
						case DEAD:
							return 6;
					}
				case MUMMY:
					switch(enemy_state)
					{
						case IDLE:
							return 5;
						case RUNNING:
							return 5;
						case ATTACK:
							return 6;
						case HIT:
							return 2;
						case DEAD:
							return 6;
					}
				case UNDEAD:
					switch(enemy_state)
					{
						case IDLE:
							return 5;
						case RUNNING:
							return 5;
						case ATTACK:
							return 6;
						case HIT:
							return 2;
						case DEAD:
							return 6;
					}
				case CENTIPEDE:
					switch(enemy_state)
					{
						case IDLE:
							return 4;
						case RUNNING:
							return 4;
						case ATTACK:
							return 6;
						case HIT:
							return 2;
						case DEAD:
							return 4;
					}
				case BLOATED:
					switch(enemy_state)
					{
						case IDLE:
							return 6;
						case RUNNING:
							return 6;
						case ATTACK:
							return 6;
						case HIT:
							return 2;
						case DEAD:
							return 4;
					}
			}

			return 0;

		}
		public static int GetMaxHealth(int enemy_type)
		{
			switch(enemy_type) {
				case HYENA:
					return 10;
				case SKELETON:
					return 30;
				case MUMMY:
					return 20;
				case UNDEAD:
					return 20;
				case CENTIPEDE:
					return 30;
				case BLOATED:
					return 30;
				default:
					return 0;
			}
		}

		public static int GetEnemyDmg(int enemy_type)
		{
			switch(enemy_type) {
				case HYENA:
					return 15;
				case SKELETON:
					return 15;
				case MUMMY:
					return 15;
				case UNDEAD:
					return 15;
				case CENTIPEDE:
					return 15;
				case BLOATED:
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
