package GameDev.Graphics;

import java.awt.*;
import java.awt.image.BufferedImage;

import static GameDev.Utils.Constants.EnemyConstants.*;

public class Assets
{
	public static BufferedImage[] player_idle;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	public static BufferedImage[] player_down;
	public static BufferedImage[] player_jump;
	public static BufferedImage[] player_fall;
	public static BufferedImage[] player_powerAttack;
	public static BufferedImage[] player_die;
	// ------------------------------ lvl 1
	public static BufferedImage[] land_lv1;
	public static BufferedImage[] land_lv2;
	// -----------
	public static BufferedImage[] player_attack;
	public static BufferedImage sky,clouds,sea,grounds;
	public static BufferedImage[][] skeletonArr;
	// -------------------------------------
	public static BufferedImage[] hyena_walk;
	public static BufferedImage[] hyena_attack;
	public static BufferedImage[] hyena_hit;
	public static BufferedImage[] hyena_die;
	// --------------------------------------
	public static BufferedImage[] mummy_walk;
	public static BufferedImage[] mummy_attack;
	public static BufferedImage[] mummy_hit;
	public static BufferedImage[] mummy_die;
	// --------------------------------------
	public static BufferedImage[] undead_walk;
	public static BufferedImage[] undead_attack;
	public static BufferedImage[] undead_hit;
	public static BufferedImage[] undead_die;
	// --------------------------------------
	public static BufferedImage[] centipede_walk;
	public static BufferedImage[] centipede_attack;
	public static BufferedImage[] centipede_hit;
	public static BufferedImage[] centipede_die;
	// ---------------------------------------
	public static BufferedImage[] bloated_walk;
	public static BufferedImage[] bloated_attack;
	public static BufferedImage[] bloated_hit;
	public static BufferedImage[] bloated_die;
	// ---------------------------------------
	public static BufferedImage[] health_bar;
	public static BufferedImage[] menu_ui;
	//----------------------------------------
	public static BufferedImage[] skeleton_walk;
	public static BufferedImage[] skeleton_attack;
	public static BufferedImage[] skeleton_hit;
	public static BufferedImage[] skeleton_dead;

	// ----------------------------- background lv 2
	public static BufferedImage dunes1, dunes2, dunes3, dunes4, dunes5, dunes6, dunes7, dunes8, desert_sky, bg_ground, bg_sun;
	// ------------------------------ background lv 3
	public static BufferedImage bg1, bg2, bg3;

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

		land_lv1 = new BufferedImage[84];
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
		land_lv1[59] = ImageLoader.LoadImage("/lv2/Textures/palm_tree_mid_r.png");
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

		land_lv1[70] = ImageLoader.LoadImage("/lv3/Textures/cornerleft.png");
		land_lv1[71] = ImageLoader.LoadImage("/lv3/Textures/grasss.png");
		land_lv1[72] = ImageLoader.LoadImage("/lv3/Textures/cornerright.png");
		land_lv1[73] = ImageLoader.LoadImage("/lv3/Textures/cornerleft2.png");
		land_lv1[74] = ImageLoader.LoadImage("/lv3/Textures/grass2.png");
		land_lv1[75] = ImageLoader.LoadImage("/lv3/Textures/cornerright2.png");
		land_lv1[76] = ImageLoader.LoadImage("/lv3/Textures/leftsidee.png");
		land_lv1[77] = ImageLoader.LoadImage("/lv3/Textures/rightsidee.png");
		land_lv1[78] = ImageLoader.LoadImage("/lv3/Textures/tile004.png");
		land_lv1[79] = ImageLoader.LoadImage("/lv3/Textures/tile009.png");
		land_lv1[80] = ImageLoader.LoadImage("/lv3/Textures/fill.png");
		land_lv1[81] = ImageLoader.LoadImage("/lv3/Textures/cornerleftlower.png");
		land_lv1[82] = ImageLoader.LoadImage("/lv3/Textures/midlower.png");
		land_lv1[83] = ImageLoader.LoadImage("/lv3/Textures/cornerrightlower.png");



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

		player_attack = new BufferedImage[3];
		player_attack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-02-1.3.png");
		player_attack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-03-1.3.png");
		player_attack[2] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-04-1.3.png");

		player_powerAttack = new BufferedImage[2];
		player_powerAttack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack2-03-1.3.png");
		player_powerAttack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack2-03-1.3.png");
		player_die = new BufferedImage[7];
		player_die[0] = ImageLoader.LoadImage("/adventurer/adventurer-die-00-1.3.png");
		player_die[1] = ImageLoader.LoadImage("/adventurer/adventurer-die-01-1.3.png");
		player_die[2] = ImageLoader.LoadImage("/adventurer/adventurer-die-02-1.3.png");
		player_die[3] = ImageLoader.LoadImage("/adventurer/adventurer-die-03-1.3.png");
		player_die[4] = ImageLoader.LoadImage("/adventurer/adventurer-die-04-1.3.png");
		player_die[5] = ImageLoader.LoadImage("/adventurer/adventurer-die-05-1.3.png");
		player_die[6] = ImageLoader.LoadImage("/adventurer/adventurer-die-06-1.3.png");

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

		dunes1 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_1.png");
		dunes2 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_2.png");
		dunes3 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_3.png");
		dunes4 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_4.png");
		dunes5 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_5.png");
		dunes6 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_6.png");
		dunes7 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_7.png");
		dunes8 = ImageLoader.LoadImage("/lv2/Background/bg_dunes_8.png");
		desert_sky = ImageLoader.LoadImage("/lv2/Background/bg_sky.png");
		bg_ground = ImageLoader.LoadImage("/lv2/Background/bg_ground.png");
		bg_sun = ImageLoader.LoadImage("/lv2/Background/frame0000.png");

		bg1 = ImageLoader.LoadImage("/lv3/Background/BG_1.png");
		bg2 = ImageLoader.LoadImage("/lv3/Background/BG_2.png");
		bg3 = ImageLoader.LoadImage("/lv3/Background/BG_3.png");



		skeleton_walk = new BufferedImage[4];
		skeleton_attack = new BufferedImage[8];
		skeleton_hit = new BufferedImage[4];
		skeleton_dead = new BufferedImage[3];

		skeleton_walk[0] = ImageLoader.LoadImage("/lv1/skeleton2/walk_0.png");
		skeleton_walk[1] = ImageLoader.LoadImage("/lv1/skeleton2/walk_1.png");
		skeleton_walk[2] = ImageLoader.LoadImage("/lv1/skeleton2/walk_2.png");
		skeleton_walk[3] = ImageLoader.LoadImage("/lv1/skeleton2/walk_3.png");

		skeleton_attack[0] = ImageLoader.LoadImage("/lv1/skeleton2/attack_0.png");
		skeleton_attack[1] = ImageLoader.LoadImage("/lv1/skeleton2/attack_1.png");
		skeleton_attack[2] = ImageLoader.LoadImage("/lv1/skeleton2/attack_2.png");
		skeleton_attack[3] = ImageLoader.LoadImage("/lv1/skeleton2/attack_3.png");
		skeleton_attack[4] = ImageLoader.LoadImage("/lv1/skeleton2/attack_4.png");
		skeleton_attack[5] = ImageLoader.LoadImage("/lv1/skeleton2/attack_5.png");
		skeleton_attack[6] = ImageLoader.LoadImage("/lv1/skeleton2/attack_6.png");
		skeleton_attack[7] = ImageLoader.LoadImage("/lv1/skeleton2/attack_7.png");

		skeleton_dead[0] = ImageLoader.LoadImage("/lv1/skeleton2/die_0.png");
		skeleton_dead[1] = ImageLoader.LoadImage("/lv1/skeleton2/die_1.png");
		skeleton_dead[2] = ImageLoader.LoadImage("/lv1/skeleton2/die_2.png");

		skeleton_hit[0] = ImageLoader.LoadImage("/lv1/skeleton2/hit_0.png");
		skeleton_hit[1] = ImageLoader.LoadImage("/lv1/skeleton2/hit_1.png");
		skeleton_hit[2] = ImageLoader.LoadImage("/lv1/skeleton2/hit_2.png");
		skeleton_hit[3] = ImageLoader.LoadImage("/lv1/skeleton2/hit_3.png");




		skeletonArr = new BufferedImage[5][8];

		// -------------------------------------------------------------------------------------------------------------------------------------

		mummy_walk = new BufferedImage[6];
		SpriteSheet temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Mummy/Mummy_walk.png"));
		for (int i = 0; i < 6; i++)
		{
			mummy_walk[i] = temp.crop(i * MUMMY_WIDTH_DEFAULT,0, MUMMY_WIDTH_DEFAULT,MUMMY_HEIGHT_DEFAULT);
		}


		mummy_attack = new BufferedImage[4];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Mummy/Mummy_attack.png"));
		for (int i = 0; i < 4; i++)
		{
			mummy_attack[i] = temp.crop(i * MUMMY_WIDTH_DEFAULT,0, MUMMY_WIDTH_DEFAULT,MUMMY_HEIGHT_DEFAULT);
		}

		mummy_hit = new BufferedImage[2];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Mummy/Mummy_hurt.png"));
		for (int i = 0; i < 2; i++)
		{
			mummy_hit[i] = temp.crop(i * MUMMY_WIDTH_DEFAULT,0, MUMMY_WIDTH_DEFAULT,MUMMY_HEIGHT_DEFAULT);
		}

		mummy_die = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Mummy/Mummy_death.png"));
		for (int i = 0; i < 6; i++)
		{
			mummy_die[i] = temp.crop(i * MUMMY_WIDTH_DEFAULT,0, MUMMY_WIDTH_DEFAULT,MUMMY_HEIGHT_DEFAULT);
		}

		 // -------------------------------------------------------------------------------------------------------------------------------------


		undead_walk = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Undead/Deceased_walk.png"));
		for (int i = 0; i < 6; i++)
		{
			undead_walk[i] = temp.crop(i * UNDEAD_WIDTH_DEFAULT,0, UNDEAD_WIDTH_DEFAULT,UNDEAD_HEIGHT_DEFAULT);
		}


		undead_attack = new BufferedImage[4];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Undead/Deceased_attack.png"));
		for (int i = 0; i < 4; i++)
		{
			undead_attack[i] = temp.crop(i * UNDEAD_WIDTH_DEFAULT,0, UNDEAD_WIDTH_DEFAULT,UNDEAD_HEIGHT_DEFAULT);
		}

		undead_hit = new BufferedImage[2];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Undead/Deceased_hurt.png"));
		for (int i = 0; i < 2; i++)
		{
			undead_hit[i] = temp.crop(i * UNDEAD_WIDTH_DEFAULT,0, UNDEAD_WIDTH_DEFAULT,UNDEAD_HEIGHT_DEFAULT);
		}

		undead_die = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv2/Undead/Deceased_death.png"));
		for (int i = 0; i < 6; i++)
		{
			undead_die[i] = temp.crop(i * UNDEAD_WIDTH_DEFAULT,0, UNDEAD_WIDTH_DEFAULT,UNDEAD_HEIGHT_DEFAULT);
		}

		// -------------------------------------------------------------------------------------------------------------------------------------

		centipede_walk = new BufferedImage[4];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/Centipede/Centipede_walk.png"));
		for (int i = 0; i < 4; i++)
		{
			centipede_walk[i] = temp.crop(i * CENTIPEDE_WIDTH_DEFAULT,0, CENTIPEDE_WIDTH_DEFAULT,CENTIPEDE_HEIGHT_DEFAULT);
		}


		centipede_attack = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/Centipede/Centipede_attack2.png"));
		for (int i = 0; i < 6; i++)
		{
			centipede_attack[i] = temp.crop(i * CENTIPEDE_WIDTH_DEFAULT,0, CENTIPEDE_WIDTH_DEFAULT,CENTIPEDE_HEIGHT_DEFAULT);
		}

		centipede_hit = new BufferedImage[2];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/Centipede/Centipede_hurt.png"));
		for (int i = 0; i < 2; i++)
		{
			centipede_hit[i] = temp.crop(i * CENTIPEDE_WIDTH_DEFAULT,0, CENTIPEDE_WIDTH_DEFAULT,CENTIPEDE_HEIGHT_DEFAULT);
		}

		centipede_die = new BufferedImage[4];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/Centipede/Centipede_death.png"));
		for (int i = 0; i < 4; i++)
		{
			centipede_die[i] = temp.crop(i * CENTIPEDE_WIDTH_DEFAULT,0, CENTIPEDE_WIDTH_DEFAULT,CENTIPEDE_HEIGHT_DEFAULT);
		}

		// -------------------------------------------------------------------------------------------------------------------------------------

		bloated_walk = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/BigBloated/Big_bloated_walk.png"));
		for (int i = 0; i < 6; i++)
		{
			bloated_walk[i] = temp.crop(i * BLOATED_WIDTH_DEFAULT,0, BLOATED_WIDTH_DEFAULT,BLOATED_HEIGHT_DEFAULT);
		}

		bloated_attack = new BufferedImage[6];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/BigBloated/Big_bloated_attack4.png"));
		for (int i = 0; i < 6; i++)
		{
			bloated_attack[i] = temp.crop(i * BLOATED_WIDTH_DEFAULT,0, BLOATED_WIDTH_DEFAULT,BLOATED_HEIGHT_DEFAULT);
		}

		bloated_hit = new BufferedImage[2];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/BigBloated/Big_bloated_hurt.png"));
		for (int i = 0; i < 2; i++)
		{
			bloated_hit[i] = temp.crop(i * BLOATED_WIDTH_DEFAULT,0, BLOATED_WIDTH_DEFAULT,BLOATED_HEIGHT_DEFAULT);
		}

		bloated_die = new BufferedImage[4];
		temp = new SpriteSheet(ImageLoader.LoadImage("/lv3/BigBloated/Big_bloated_death.png"));
		for (int i = 0; i < 4; i++)
		{
			bloated_die[i] = temp.crop(i * BLOATED_WIDTH_DEFAULT,0, BLOATED_WIDTH_DEFAULT,BLOATED_HEIGHT_DEFAULT);
		}

	}

}
