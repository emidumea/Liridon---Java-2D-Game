package GameDev;

import GameDev.Entities.Player;
import GameDev.GameWindow.GameWindow;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Input.KeyboardInput;
import GameDev.Input.MouseInput;
import GameDev.Tiles.TileManager;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import static GameDev.Graphics.Assets.*;


public class Game implements Runnable
{

	TileManager tileM;
	public final static int TILES_DEFAULT_SIZE = 48;
	public final static float SCALE = 1f;
	public final static int TILES_IN_WIDTH = 26; // col
	public final static int TILES_IN_HEIGHT = 14;
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	private MouseInput mouseInput;
	//private KeyboardInput keyboardInput;
	private GameWindow      wnd;        /*!< Fereastra in care se va desena tabla jocului*/
	private boolean         runState;   /*!< Flag ce starea firului de executie.*/
	private Thread          gameThread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/
	private BufferStrategy  bs;         /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/

	private BufferedImage img;
	private Graphics        g;     /*!< Referinta catre un context grafic.*/
	private int coordX;
	private int coordY;
	private Animation anim;
	public Player player;

	public Player getPlayer() {
		return player;
	}

	//private Tile
	public Game(String title, int width, int height)
	{
		//width = GAME_WIDTH;
		//height = GAME_HEIGHT;
		wnd = new GameWindow(title, width, height);
		//InitGame();
		runState = false;
	}

	private void InitGame()
	{

		Assets.init();
		player = new Player(100,100, (int) (64 * SCALE), (int) (40 * SCALE));
		anim = new Animation(player_idle,100);
		tileM = new TileManager(this);
		player.loadLvlData(tileM.getMapTile());
		tileM.printMap();
		mouseInput = new MouseInput(this);
		wnd = new GameWindow("Liridon", GAME_WIDTH, GAME_HEIGHT);
		wnd.BuildGameWindow();
		wnd.getFrame().addKeyListener(new KeyboardInput(this));
		wnd.getFrame().addMouseListener(mouseInput);
		wnd.getFrame().addMouseMotionListener(mouseInput);

		wnd.getCanvas().addMouseListener(mouseInput);
		wnd.getCanvas().addMouseMotionListener(mouseInput);

	//	Assets.Init();
	}

	@Override public void run()
	{

		InitGame();
		long oldTime = System.nanoTime();
		long currentTime;

		double delta = 0;

		int ticks = 0;
		int frames = 0;


		final int framesPerSecond   = 60;
		final double timeFrame      = 1000000000D / framesPerSecond;

		long lastTimer = System.currentTimeMillis();

		while (runState)
		{

			currentTime = System.nanoTime();
			delta += (currentTime - oldTime) / timeFrame;
			oldTime = currentTime;
			frames++;

			while (delta >= 1)
			{
				Update();
				Draw();
				delta--;
				ticks++;
			}

			if (System.currentTimeMillis() - lastTimer >=1000)
			{
				lastTimer +=1000;
				System.out.println(ticks + " ticks, " + frames + " frames");
				frames = 0;
				ticks = 0;
			}

		}

	}

	/*! \fn public synchronized void start()
		\brief Creaza si starteaza firul separat de executie (thread).

		Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
	 */
	public synchronized void StartGame()
	{
		if(!runState)
		{

			runState = true;
			/// Se construieste threadul avand ca parametru obiectul Game. De retinut faptul ca Game class
			/// implementeaza interfata Runnable. Threadul creat va executa functia run() suprascrisa in clasa Game.
			gameThread = new Thread(this);
			/// Threadul creat este lansat in executie (va executa metoda run())
			gameThread.start();
		}

	}

	/*! \fn public synchronized void stop()
		\brief Opreste executie thread-ului.

		Metoda trebuie sa fie declarata synchronized pentru ca apelul acesteia sa fie semaforizat.
	 */
/*	public synchronized void StopGame()
	{
		if(runState == true)
		{
			/// Actualizare stare thread
			runState = false;
			/// Metoda join() arunca exceptii motiv pentru care trebuie incadrata intr-un block try - catch.
			try
			{
				/// Metoda join() pune un thread in asteptare panca cand un altul isi termina executie.
				/// Totusi, in situatia de fata efectul apelului este de oprire a threadului.
				gameThread.join();
			}
			catch(InterruptedException ex)
			{
				/// In situatia in care apare o exceptie pe ecran vor fi afisate informatii utile pentru depanare.
				ex.printStackTrace();
			}
		}
		else
		{
			/// Thread-ul este oprit deja.
			return;
		}
	}
*/
	public void changeCoordX(int val)
	{
		this.coordX += val;
	}

	public void changeCoordY(int val)
	{
		this.coordY += val;
	}
	private void Update()
	{

		player.tick();
	}
	public void setPos(int x,int y)
	{
		this.coordX = x;
		this.coordY = y;
	}


	private void Draw()
	{
		/// Returnez bufferStrategy pentru canvasul existent
		bs = wnd.getCanvas().getBufferStrategy();
		/// Verific daca buffer strategy a fost construit sau nu
		if(bs == null)
		{
			/// Se executa doar la primul apel al metodei Draw()
			try
			{
				/// Se construieste tripul buffer
				wnd.getCanvas().createBufferStrategy(3);
				return;
			}
			catch (Exception e)
			{
				/// Afisez informatii despre problema aparuta pentru depanare.
				e.printStackTrace();
			}
		}
		/// Se obtine contextul grafic curent in care se poate desena.
		g = bs.getDrawGraphics();
		/// Se sterge ce era
		//img = LoadImage("/adventurer/adventurer-attack1-00-1.3.png");
		img = player_idle[3];
		//BufferedImage aa=LoadImage("/adventurer/adventurer-attack1-03-1.3.png");
		g.clearRect(0, 0, wnd.getWidth(), wnd.getHeight());
		//g.drawImage(land_grass[0],15,15,null);
	//	g.drawImage(land_grass[9],125,125,null);

		//g.drawImage(land_grass[15],225,225,null);

		//g.drawImage(land_grass[19],335,335,null);

		//g.drawImage(img,0,0,null);
		//anim.tick();
		//g.drawImage(anim.getCurrentFrame(),coordX,coordY,128,80,null);
		//player.tick();
		tileM.draw(g);
		player.render(g);
		player.tick();

		/// operatie de desenare
		// ...............
		/*Tile.grassTile.Draw(g, 0 * Tile.TILE_WIDTH, 0);
		Tile.soilTile.Draw(g, 1 * Tile.TILE_WIDTH, 0);
		Tile.waterTile.Draw(g, 2 * Tile.TILE_WIDTH, 0);
		Tile.mountainTile.Draw(g, 3 * Tile.TILE_WIDTH, 0);
		Tile.treeTile.Draw(g, 4 * Tile.TILE_WIDTH, 0);

		g.drawRect(1 * Tile.TILE_WIDTH, 1 * Tile.TILE_HEIGHT, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);*/


		// end operatie de desenare
		/// Se afiseaza pe ecran
		bs.show();

		/// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
		/// elementele grafice ce au fost desenate pe canvas).
		g.dispose();
	}
}

