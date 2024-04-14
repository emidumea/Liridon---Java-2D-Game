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

		land_lv1 = new BufferedImage[41];
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
//		land_grass = new BufferedImage[20];
//		land_grass[0] = environment1.crop(16,177,92,111);
//		land_grass[1] = environment1.crop(124,105,32,55);
//		land_grass[2] = environment1.crop(124,183,32,41);
//		land_grass[3] = environment1.crop(124,240,32,32);
//		land_grass[4] = environment1.crop(172,186,48,38);
//		land_grass[5] = environment1.crop(172,240,32,64);
//		land_grass[6] = environment1.crop(236,180,32,44);
//		land_grass[7] = environment1.crop(220,240,64,32);
//		land_grass[8] = environment1.crop(284,186,32,22);
//		land_grass[9] = environment1.crop(300,236,32,36);
//		land_grass[10] = environment1.crop(332,183,16,25);
//		land_grass[11] = environment1.crop(349,232,32,40);
//		land_grass[12] = environment1.crop(364,187,32,21);
//		land_grass[13] = environment1.crop(396,236,32,36);
//		land_grass[14] = environment1.crop(412,166,32,42);
//		land_grass[15] = environment1.crop(444,243,32,45);
//		land_grass[16] = environment1.crop(460,186,16,22);
//		land_grass[17] = environment1.crop(492,186,44,86);
//		land_grass[18] = environment1.crop(556,240,64,48);
//		land_grass[19] = environment1.crop(636,240,48,48);
		land_grass = new BufferedImage[13];
		land_grass[0] = environment1.crop(16,186,width128,height128) ; // bucata mare land
		land_grass[1] = environment1.crop(492,186,width128,height128); // bucata land sfarsit
		land_grass[2] = environment1.crop(124,183,width,height64); // piatra de pus intre iarba
		land_grass[3] = environment1.crop(124,105,width,height); //tot piatra da cu iarba
		land_grass[4] = environment1.crop(172,186,48,height); // continuare iarba land
//		land_grass[0] = environment1.crop(16,186,48,48) ; // bucata mare land
//		land_grass[1] = environment1.crop(492,186,48,48); // bucata land sfarsit
//		land_grass[2] = environment1.crop(124,183,48,48); // piatra de pus intre iarba
//		land_grass[3] = environment1.crop(124,105,48,48); //tot piatra da cu iarba
//		land_grass[4] = environment1.crop(172,186,48,48); // continuare iarba land
		land_grass[5] = environment1.crop(236,180,width,height64); // iarba mai lata spre pamant
		land_grass[6] = environment1.crop(284,186,width,height); // continuare iarba tile mic
		land_grass[7] = environment1.crop(332,183,width64,height64); // iarba micuta spre pamant
		land_grass[8] = environment1.crop(556,240,width64,height64); // panta iarba stanga
		land_grass[9] = environment1.crop(636,236,width64,height64); // panta iarba dreapta

		land_grass[10] = environment1.crop(124,240,width,height); // interior land iarba
		land_grass[11] = environment1.crop(172,240,width,height64); // interior land lung piatra
		land_grass[12] = environment1.crop(220,240,width64,height); // interior lat iarba

//		land_grass[13] = environment1.crop(396,236,width64,height64);
//		land_grass[14] = environment1.crop(412,166,width64,height64);
//		land_grass[15] = environment1.crop(444,243,width64,height64);
//		land_grass[16] = environment1.crop(460,186,width64,height64);
//		land_grass[17] = environment1.crop(492,186,width64,height64);
//		land_grass[18] = environment1.crop(556,240,width64,height64);
//		land_grass[19] = environment1.crop(636,240,width64,height64);

		land_stone = new BufferedImage[6];
		land_stone[0] = environment1.crop(364,187,width,height); // piatra mica
		land_stone[1] = environment1.crop(460,186,width,height); //piatra si mai mica
		land_stone[2] = environment1.crop(300,236,width,height); // piatra stanga
		land_stone[3] = environment1.crop(348,232,width,height); // piatra mijloc
		land_stone[4] = environment1.crop(396,236,width,height); // piatra dreapta
		land_stone[5] = environment1.crop(523,104,width64,height); // piatra mare mijloc

		platforms_grass = new BufferedImage[2];
		platforms_grass[0] = environment1.crop(21,24,width128,height64); // platforma mare
		platforms_grass[1] = environment1.crop(28,121,width64,height); // platforma mica

		platforms_stone = new BufferedImage[5];
		platforms_stone[0] = environment1.crop(305,43,width64,height128); // platforma mare stg
		platforms_stone[1] = environment1.crop(380,43,width,height128); // plat mare mij
		platforms_stone[2] = environment1.crop(412,43,width64,height128); //plat stg
		platforms_stone[3] = environment1.crop(517,56,width,height); // plat piatra mica
		platforms_stone[4] = environment1.crop(581,56,width,height); // plat piatra mare

		bridge1 = new BufferedImage[3];
		bridge1[0] = environment1.crop(563,188,width,height);
		bridge1[1] = environment1.crop(620,187,width,height);
		bridge1[2] = environment1.crop(668,188,width,height);

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

		player_down = new BufferedImage[6];
		player_down[0] = ImageLoader.LoadImage("/adventurer/adventurer-run-00-1.3.png");
		player_down[1] = ImageLoader.LoadImage("/adventurer/adventurer-run-01-1.3.png");
		player_down[2] = ImageLoader.LoadImage("/adventurer/adventurer-run-02-1.3.png");
		player_down[3] = ImageLoader.LoadImage("/adventurer/adventurer-run-03-1.3.png");
		player_down[4] = ImageLoader.LoadImage("/adventurer/adventurer-run-04-1.3.png");
		player_down[5] = ImageLoader.LoadImage("/adventurer/adventurer-run-05-1.3.png");
		*/
		player_attack = new BufferedImage[5];
		player_attack[0] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-00-1.3.png");
		player_attack[1] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-01-1.3.png");
		player_attack[2] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-02-1.3.png");
		player_attack[3] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-03-1.3.png");
		player_attack[4] = ImageLoader.LoadImage("/adventurer/adventurer-attack1-04-1.3.png");

	}

}
