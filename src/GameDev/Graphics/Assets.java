package GameDev.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

import static GameDev.Utils.Constants.EnemyConstants.SKELETON_HEIGHT_DEFAULT;
import static GameDev.Utils.Constants.EnemyConstants.SKELETON_WIDTH_DEFAULT;

public class Assets
{
	public static BufferedImage[] player_idle;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_jump;
	public static BufferedImage[] player_fall;
	// ------------------------------ lvl 1
	public static BufferedImage[] land_lv1;
	public static BufferedImage[] land_lv2;
	// -----------
	public static BufferedImage[] player_attack;
	public static BufferedImage sky,clouds,sea,grounds;
	public static BufferedImage[][] skeletonArr;

	public static BufferedImage[] hyena_walk;
	public static BufferedImage[] hyena_attack;
	public static BufferedImage[] hyena_hit;
	public static BufferedImage[] hyena_die;
	public static BufferedImage[] health_bar;
	public static BufferedImage[] menu_ui;

	public static void init()
	{
		SpriteSheet environment1 = new SpriteSheet(ImageLoader.LoadImage("/lv1/environment.png"));

		menu_ui = new BufferedImage[6];
		menu_ui[0] = ImageLoader.LoadImage("/ui/Play Button.png");
		menu_ui[1] = ImageLoader.LoadImage("/ui/Play col_Button.png");
		menu_ui[2] = ImageLoader.LoadImage("/ui/Options Button.png");
		menu_ui[3] = ImageLoader.LoadImage("/ui/Options  col_Button.png");
		menu_ui[4] = ImageLoader.LoadImage("/ui/Quit Button.png");
		menu_ui[5] = ImageLoader.LoadImage("/ui/Quit  col_Button.png");

		land_lv1 = new BufferedImage[70];
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

		land_lv1[48] = ImageLoader.LoadImage("/lv2/Textures/terrain_flat.png");
		land_lv1[49] = ImageLoader.LoadImage("/lv2/Textures/terrain_fill.png");
		land_lv1[50] = ImageLoader.LoadImage("/lv2/Textures/cactus1_low.png");
		land_lv1[51] = ImageLoader.LoadImage("/lv2/Textures/cactus1_up.png");
		land_lv1[52] = ImageLoader.LoadImage("/lv2/Textures/cactus_bg_short_A.png");
		land_lv1[53] = ImageLoader.LoadImage("/lv2/Textures/cactus_bg_short_B.png");
		land_lv1[54] = ImageLoader.LoadImage("/lv2/Textures/cactus_fg_short_A.png");
		land_lv1[55] = ImageLoader.LoadImage("/lv2/Textures/cactus_fg_short_B.png");
		land_lv1[56] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_low_l.png");
		land_lv1[57] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_low_r.png");
		land_lv1[58] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_mid_l.png");
		land_lv1[59] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_mid_l.png");
		land_lv1[60] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_up_l.png");
		land_lv1[61] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_up_r.png");
		land_lv1[62] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_left.png");
		land_lv1[63] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_center.png");
		land_lv1[64] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_right.png");
		land_lv1[65] = ImageLoader.LoadImage("/lv2/Textures/cactus2_low.png");
		land_lv1[66] = ImageLoader.LoadImage("/lv2/Textures/cactus2_up.png");
		land_lv1[67] = ImageLoader.LoadImage("/lv2/Textures/water_A.png");
		land_lv1[68] = ImageLoader.LoadImage("/lv2/Textures/water_B.png");
		land_lv1[69] = ImageLoader.LoadImage("/lv2/Textures/water_fill.png");


		land_lv2 = new BufferedImage[19];
		land_lv2[0] = ImageLoader.LoadImage("/lv2/Textures/terrain_flat.png");
		land_lv2[1] = ImageLoader.LoadImage("/lv2/Textures/terrain_fill.png");
		land_lv2[2] = ImageLoader.LoadImage("/lv2/Textures/cactus1_low.png");
		land_lv2[3] = ImageLoader.LoadImage("/lv2/Textures/cactus1_up.png");
		land_lv2[4] = ImageLoader.LoadImage("/lv2/Textures/cactus_bg_short_A.png");
		land_lv2[5] = ImageLoader.LoadImage("/lv2/Textures/cactus_bg_short_B.png");
		land_lv2[6] = ImageLoader.LoadImage("/lv2/Textures/cactus_fg_short_A.png");
		land_lv2[7] = ImageLoader.LoadImage("/lv2/Textures/cactus_fg_short_B.png");
		land_lv2[8] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_low_l.png");
		land_lv2[9] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_low_r.png");
		land_lv2[10] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_mid_l.png");
		land_lv2[11] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_mid_l.png");
		land_lv2[12] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_up_l.png");
		land_lv2[13] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_up_r.png");
		land_lv2[14] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_left.png");
		land_lv2[15] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_center.png");
		land_lv2[16] = ImageLoader.LoadImage("/lv2/Textures/shrubs_fg_right.png");
		land_lv2[17] = ImageLoader.LoadImage("/lv2/Textures/cactus2_low.png");
		land_lv2[18] = ImageLoader.LoadImage("/lv2/Textures/cactus2_up.png");

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
		player_attack = new BufferedImage[3];
	//	player_attack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-00-1.3.png");
		//player_attack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-01-1.3.png");
		player_attack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-02-1.3.png");
		player_attack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-03-1.3.png");
		player_attack[2] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-04-1.3.png");

		hyena_walk = new BufferedImage[6];
		hyena_walk[0] = ImageLoader.LoadImage("/lv1/hyena/hyena_0.png");
		hyena_walk[1] = ImageLoader.LoadImage("/lv1/hyena/hyena_1.png");
		hyena_walk[2] = ImageLoader.LoadImage("/lv1/hyena/hyena_2.png");
		hyena_walk[3] = ImageLoader.LoadImage("/lv1/hyena/hyena_3.png");
		hyena_walk[4] = ImageLoader.LoadImage("/lv1/hyena/hyena_4.png");
		hyena_walk[5] = ImageLoader.LoadImage("/lv1/hyena/hyena_5.png");

		hyena_attack = new BufferedImage[6];
		hyena_attack[0] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_0.png");
		hyena_attack[1] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_1.png");
		hyena_attack[2] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_2.png");
		hyena_attack[3] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_3.png");
		hyena_attack[4] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_4.png");
		hyena_attack[5] = ImageLoader.LoadImage("/lv1/hyena/hyena_attack_5.png");

		hyena_hit = new BufferedImage[2];
		hyena_hit[0] = ImageLoader.LoadImage("/lv1/hyena/hurt_1.png");
		hyena_hit[1] = ImageLoader.LoadImage("/lv1/hyena/hurt_2.png");

		hyena_die = new BufferedImage[6];
		hyena_die[0] = ImageLoader.LoadImage("/lv1/hyena/die_1.png");
		hyena_die[1] = ImageLoader.LoadImage("/lv1/hyena/die_2.png");
		hyena_die[2] = ImageLoader.LoadImage("/lv1/hyena/die_3.png");
		hyena_die[3] = ImageLoader.LoadImage("/lv1/hyena/die_4.png");
		hyena_die[4] = ImageLoader.LoadImage("/lv1/hyena/die_5.png");
		hyena_die[5] = ImageLoader.LoadImage("/lv1/hyena/die_6.png");

		health_bar = new BufferedImage[2];
		health_bar[0] = ImageLoader.LoadImage("/hp/lives_5.png");
		health_bar[1] = ImageLoader.LoadImage("/hp/Pixel_heart2.png");

		sky = ImageLoader.LoadImage("/lv1/Background/sky.png");
		clouds = ImageLoader.LoadImage("/lv1/Background/clouds.png");
		sea = ImageLoader.LoadImage("/lv1/Background/sea.png");
		grounds = ImageLoader.LoadImage("/lv1/Background/far-grounds.png");


		skeletonArr = new BufferedImage[5][8];
		SpriteSheet temp = new SpriteSheet(ImageLoader.LoadImage("/lv1/skeleton1/skeletons2.png"));
		for (int j = 0; j < skeletonArr.length; j++)
		{
			for (int i = 0; i < skeletonArr[j].length; i++)
			{
				skeletonArr[j][i] = temp.crop(i * SKELETON_WIDTH_DEFAULT, j * SKELETON_HEIGHT_DEFAULT, SKELETON_WIDTH_DEFAULT, SKELETON_HEIGHT_DEFAULT);
			}
		}
	}

}
