package GameDev.Graphics;

import java.awt.image.BufferedImage;

public class Assets
{
	private static final int width128 = 128, height128 = 128;
	private static final int width64 = 64, height64 = 64;
	private static final int width = 32, height = 32;


	public static BufferedImage[] player_idle;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_jump;
	public static BufferedImage[] player_fall;
	// ------------------------------ lvl 1
	public static BufferedImage[] level1_atlas;
	public static BufferedImage[] land_lv1;
	public static BufferedImage[] land_grass;
	public static BufferedImage[] platforms_grass;
	public static BufferedImage[] land_stone;
	public static BufferedImage[] platforms_stone;
	public static BufferedImage[] background_stone;
	public static BufferedImage[] tree1;
	public static BufferedImage[] bridge1;
	// -----------
	public static BufferedImage[] player_attack;

	public static void init()
	{
		SpriteSheet environment1 = new SpriteSheet(ImageLoader.LoadImage("/lv1/environment.png"));

		land_lv1 = new BufferedImage[48];
		land_lv1[0] = ImageLoader.LoadImage("/lv1/Textures/image_0.png");
		land_lv1[1] = ImageLoader.LoadImage("/lv1/Textures/image_1.png");
		land_lv1[2] = ImageLoader.LoadImage("/lv1/Textures/image_2.png");
		land_lv1[3] = ImageLoader.LoadImage("/lv1/Textures/image_3.png");
		land_lv1[4] = ImageLoader.LoadImage("/lv1/Textures/image_4.png");
		land_lv1[5] = ImageLoader.LoadImage("/lv1/Textures/image_5.png");
		land_lv1[6] = ImageLoader.LoadImage("/lv1/Textures/image_6.png");
		land_lv1[7] = ImageLoader.LoadImage("/lv1/Textures/image_7.png");
		land_lv1[8] = ImageLoader.LoadImage("/lv1/Textures/image_8.png");
		land_lv1[9] = ImageLoader.LoadImage("/lv1/Textures/image_9.png");
		land_lv1[10] = ImageLoader.LoadImage("/lv1/Textures/image_10.png");
		land_lv1[11] = ImageLoader.LoadImage("/lv1/Textures/image_11.png");
		land_lv1[12] = ImageLoader.LoadImage("/lv1/Textures/image_12.png");
		land_lv1[13] = ImageLoader.LoadImage("/lv1/Textures/image_13.png");
		land_lv1[14] = ImageLoader.LoadImage("/lv1/Textures/image_14.png");
		land_lv1[15] = ImageLoader.LoadImage("/lv1/Textures/image_15.png");
		land_lv1[16] = ImageLoader.LoadImage("/lv1/Textures/image_16.png");
		land_lv1[17] = ImageLoader.LoadImage("/lv1/Textures/image_17.png");
		land_lv1[18] = ImageLoader.LoadImage("/lv1/Textures/image_18.png");
		land_lv1[19] = ImageLoader.LoadImage("/lv1/Textures/image_19.png");
		land_lv1[20] = ImageLoader.LoadImage("/lv1/Textures/image_20.png");
		land_lv1[21] = ImageLoader.LoadImage("/lv1/Textures/image_21.png");
		land_lv1[22] = ImageLoader.LoadImage("/lv1/Textures/image_22.png");
		land_lv1[23] = ImageLoader.LoadImage("/lv1/Textures/image_23.png");
		land_lv1[24] = ImageLoader.LoadImage("/lv1/Textures/image_24.png");
		land_lv1[25] = ImageLoader.LoadImage("/lv1/Textures/image_25.png");
		land_lv1[26] = ImageLoader.LoadImage("/lv1/Textures/tile000.png");
		land_lv1[27] = ImageLoader.LoadImage("/lv1/Textures/tile001.png");
		land_lv1[28] = ImageLoader.LoadImage("/lv1/Textures/tile002.png");
		land_lv1[29] = ImageLoader.LoadImage("/lv1/Textures/tile003.png");
		land_lv1[30] = ImageLoader.LoadImage("/lv1/Textures/tile004.png");
		land_lv1[31] = ImageLoader.LoadImage("/lv1/Textures/grass.png");
		land_lv1[32] = ImageLoader.LoadImage("/lv1/Textures/tile005.png");
		land_lv1[33] = ImageLoader.LoadImage("/lv1/Textures/tile006.png");
		land_lv1[34] = ImageLoader.LoadImage("/lv1/Textures/tilebridge_0.png");
		land_lv1[35] = ImageLoader.LoadImage("/lv1/Textures/tilebridge_1.png");
		land_lv1[36] = ImageLoader.LoadImage("/lv1/Textures/tilebridge_2.png");
		land_lv1[37] = ImageLoader.LoadImage("/lv1/Textures/platform_0.png");
		land_lv1[38] = ImageLoader.LoadImage("/lv1/Textures/platform_1.png");
		land_lv1[39] = ImageLoader.LoadImage("/lv1/Textures/platform_2.png");
		land_lv1[40] = ImageLoader.LoadImage("/lv1/Textures/platform_3.png");
		land_lv1[41] = ImageLoader.LoadImage("/lv1/Textures/tree_0.png");
		land_lv1[42] = ImageLoader.LoadImage("/lv1/Textures/tree_1.png");
		land_lv1[43] = ImageLoader.LoadImage("/lv1/Textures/tree_2.png");
		land_lv1[44] = ImageLoader.LoadImage("/lv1/Textures/tree_3.png");
		land_lv1[45] = ImageLoader.LoadImage("/lv1/Textures/tree_4.png");
		land_lv1[46] = ImageLoader.LoadImage("/lv1/Textures/tree_5.png");
		land_lv1[47] = ImageLoader.LoadImage("/lv1/Textures/tree_6.png");


		player_idle = new BufferedImage[4];
		player_idle[0] = ImageLoader.LoadImage("/adventurer/adventurer-idle-00-1.3.png");
		player_idle[1] = ImageLoader.LoadImage("/adventurer/adventurer-idle-01-1.3.png");
		player_idle[2] = ImageLoader.LoadImage("/adventurer/adventurer-idle-02-1.3.png");
		player_idle[3] = ImageLoader.LoadImage("/adventurer/adventurer-idle-03-1.3.png");

		player_up = new BufferedImage[6];
		player_up[0] = ImageLoader.LoadImage("/adventurer/adventurer-run-00-1.3.png");
		player_up[1] = ImageLoader.LoadImage("/adventurer/adventurer-run-01-1.3.png");
		player_up[2] = ImageLoader.LoadImage("/adventurer/adventurer-run-02-1.3.png");
		player_up[3] = ImageLoader.LoadImage("/adventurer/adventurer-run-03-1.3.png");
		player_up[4] = ImageLoader.LoadImage("/adventurer/adventurer-run-04-1.3.png");
		player_up[5] = ImageLoader.LoadImage("/adventurer/adventurer-run-05-1.3.png");

		player_jump = new BufferedImage[4];
		player_jump[0] = ImageLoader.LoadImage("/adventurer/adventurer-jump-00-1.3.png");
		player_jump[1] = ImageLoader.LoadImage("/adventurer/adventurer-jump-01-1.3.png");
		player_jump[2] = ImageLoader.LoadImage("/adventurer/adventurer-jump-02-1.3.png");
		player_jump[3] = ImageLoader.LoadImage("/adventurer/adventurer-jump-03-1.3.png");

		player_fall = new BufferedImage[2];
		player_fall[0] = ImageLoader.LoadImage("/adventurer/adventurer-fall-00-1.3.png");
		player_fall[1] = ImageLoader.LoadImage("/adventurer/adventurer-fall-01-1.3.png");
		/*player_left = new BufferedImage[6];
		player_left[0] = ImageLoader.LoadImage("/adventurer/adventurer-run-00-1.3.png");
		player_left[1] = ImageLoader.LoadImage("/adventurer/adventurer-run-01-1.3.png");
		player_left[2] = ImageLoader.LoadImage("/adventurer/adventurer-run-02-1.3.png");
		player_left[3] = ImageLoader.LoadImage("/adventurer/adventurer-run-03-1.3.png");
		player_left[4] = ImageLoader.LoadImage("/adventurer/adventurer-run-04-1.3.png");
		player_left[5] = ImageLoader.LoadImage("/adventurer/adventurer-run-05-1.3.png");

		player_right = new BufferedImage[6];
		player_right[0] = ImageLoader.LoadImage("/adventurer/adventurer-run-00-1.3.png");
		player_right[1] = ImageLoader.LoadImage("/adventurer/adventurer-run-01-1.3.png");
		player_right[2] = ImageLoader.LoadImage("/adventurer/adventurer-run-02-1.3.png");
		player_right[3] = ImageLoader.LoadImage("/adventurer/adventurer-run-03-1.3.png");
		player_right[4] = ImageLoader.LoadImage("/adventurer/adventurer-run-04-1.3.png");
		player_right[5] = ImageLoader.LoadImage("/adventurer/adventurer-run-05-1.3.png");
		*/
		player_attack = new BufferedImage[5];
		player_attack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-00-1.3.png");
		player_attack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-01-1.3.png");
		player_attack[2] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-02-1.3.png");
		player_attack[3] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-03-1.3.png");
		player_attack[4] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-04-1.3.png");

	}

}
