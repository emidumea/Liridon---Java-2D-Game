package GameDev.Levels;

public class Level
{

	private int[][] lvlData;

	public Level(int[][] lvlData) {
		this.lvlData = lvlData;
	}

	public int getSpriteIndex(int x, int y) {
		return lvlData[y][x];
	}
	/*public int getTileWidth() {
		if (lvlData.length > 0 && lvlData[0].length > 0) {
			// Presupunem că toate sprite-urile din nivel au aceeași lățime, deci luăm lățimea primului sprite
			return lvlData[0].length;
		} else {
			return 0; // Returnează 0 dacă nu există date de nivel sau nu există sprite-uri în nivel
		}
	}

	// Funcție pentru a obține înălțimea unui sprite din nivel
	public int getTileHeight() {
		if (lvlData.length > 0) {
			// Luăm înălțimea datelor de nivel, deoarece fiecare rând reprezintă un sprite
			return lvlData.length;
		} else {
			return 0; // Returnează 0 dacă nu există date de nivel
		}
	}*/
}