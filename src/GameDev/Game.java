package GameDev;

import GameDev.Database.DatabaseManager;
import GameDev.Entities.Player;
import GameDev.GameStates.Gamestate;
import GameDev.GameStates.Playing;
import GameDev.GameStates.Menu;
import GameDev.GameWindow.GameWindow;
import GameDev.Graphics.Animation;
import GameDev.Graphics.Assets;
import GameDev.Input.KeyboardInput;
import GameDev.Input.MouseInput;
import GameDev.Tiles.TileManager;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import static GameDev.Graphics.Assets.*;


public class Game implements Runnable
{

	public static Game Instance;
	TileManager tileM;
	// ------------------------------------ SCREEN SETTINGS
	public final static int TILES_DEFAULT_SIZE = 48;
	public final static float SCALE = 1f;
	public final static int TILES_IN_WIDTH = 26; // col 26
	public final static int TILES_IN_HEIGHT = 14; // 14
	public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
	public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;
	// -------------------------------------------- WORLD SETTINGS
	public static final int maxWorldCol = 60;
	public static final int maxWorldRow = 23;
	public final int worldWidth = TILES_SIZE * maxWorldCol;
	public final int worldHeight = TILES_SIZE * maxWorldRow;
	// ------------------------------------------------------
	private MouseInput mouseInput;
	private KeyboardInput keyboardInput;
	private GameWindow      wnd;        /*!< Fereastra in care se va desena tabla jocului*/
	private boolean         runState;   /*!< Flag ce starea firului de executie.*/
	private Thread          gameThread; /*!< Referinta catre thread-ul de update si draw al ferestrei*/
	private BufferStrategy  bs;         /*!< Referinta catre un mecanism cu care se organizeaza memoria complexa pentru un canvas.*/
	private Graphics        g;     /*!< Referinta catre un context grafic.*/
	public Player player;
	public DatabaseManager databaseManager;
	// -------------------------
	private Playing playing;
	private Menu menu;

	private Game(String title, int width, int height)
	{
		wnd = new GameWindow(title, width, height);
		runState = false;
	}

	public static Game getInstance(String title, int width, int height)
	{
		if (Instance == null)
		{
			Instance = new Game(title, width, height);
		}
		return Instance;
	}
	private void InitGame()
	{
		databaseManager = new DatabaseManager();
		databaseManager.createDatabase();
		menu = new Menu(this);
		playing = new Playing(this);
		mouseInput = new MouseInput(this);
		wnd = new GameWindow("Liridon", GAME_WIDTH, GAME_HEIGHT);
		wnd.BuildGameWindow();
		keyboardInput = new KeyboardInput(this);

		wnd.getFrame().addKeyListener(keyboardInput);
		wnd.getFrame().addMouseListener(mouseInput);
		wnd.getFrame().addMouseMotionListener(mouseInput);

		wnd.getCanvas().addMouseListener(mouseInput);
		wnd.getCanvas().addMouseMotionListener(mouseInput);
		wnd.getCanvas().addKeyListener(keyboardInput);

		wnd.getCanvas().setFocusable(true);
		wnd.getCanvas().requestFocusInWindow();

		// Add a FocusListener to ensure the canvas retains focus
		wnd.getCanvas().addFocusListener(new FocusListener()
		{
			@Override
			public void focusGained(FocusEvent e) {
				System.out.println("Canvas gained focus");
			}

			@Override
			public void focusLost(FocusEvent e) {
				System.out.println("Canvas lost focus");
				wnd.getCanvas().requestFocusInWindow();
			}
		});

		wnd.getFrame().addWindowFocusListener(new WindowAdapter()
		{
			@Override
			public void windowGainedFocus(WindowEvent e) {
				wnd.getCanvas().requestFocusInWindow();
			}
		});
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
	private void Update()
	{

		//player.tick();
		switch(Gamestate.state)
		{
			case MENU:
				menu.update();
				break;
			case PLAYING:
				playing.update();
				break;
			case LOAD:
				int x = DatabaseManager.getLevelValue(), i = 0;
				while (x != playing.getTileM().getLvlIndex())
				{
					playing.loadNextLevel();
				}
				//playing.getEnemyManager().resetAllEnemies();
				//playing.getEnemyManager().loadEnemiesFromDatabase();
//				playing.getTileM().setLvlIndex(2);
				//playing.update();
				Gamestate.state = Gamestate.PLAYING;
				break;
			case QUIT:
			default:
				System.exit(0);
				break;
		}
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
		g.clearRect(0, 0, wnd.getWidth(), wnd.getHeight());
		switch(Gamestate.state)
		{
			case MENU:
				menu.draw(g);
				break;
			case PLAYING:
				playing.draw(g);
				break;
			default:
				break;
		}
		bs.show();
		/// Elibereaza resursele de memorie aferente contextului grafic curent (zonele de memorie ocupate de
		/// elementele grafice ce au fost desenate pe canvas).
		g.dispose();
	}
	public Menu getMenu()
	{
		return menu;
	}

	public Playing getPlaying()
	{
		return playing;
	}
}