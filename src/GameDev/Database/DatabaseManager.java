package GameDev.Database;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import GameDev.Entities.Enemy;
import GameDev.Entities.EnemyManager;
import GameDev.Entities.Hyena;
import GameDev.Entities.Player;
import GameDev.Objects.GameObject;
import GameDev.Objects.ObjectManager;

public class DatabaseManager {
	private static final String URL = "jdbc:sqlite:game2.db";
	public void createDatabase()
	{

		createTables();
	}
	private static void loadDriver() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static void createTables() {
		loadDriver();
		String playerTable = "CREATE TABLE IF NOT EXISTS Player (" +
				                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				                     "x INTEGER," +
				                     "y INTEGER," +
				                     "health INTEGER," +
				                     "score INTEGER" +
				                     ");";

		String enemyTable = "CREATE TABLE IF NOT EXISTS Enemies (" +
				                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				                    "x INTEGER," +
				                    "y INTEGER," +
				                    "type INTEGER" +
				                    ");";

		String objectTable = "CREATE TABLE IF NOT EXISTS Objects (" +
				                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				                     "x INTEGER," +
				                     "y INTEGER," +
				                     "type INTEGER" +
				                     ");";

		String levelTable = "CREATE TABLE IF NOT EXISTS Level (" +
				                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				                    "lvlIndex INTEGER" +
				                    ");";

		String completedLevelsTable = "CREATE TABLE IF NOT EXISTS CompletedLevels (" +
				                              "id INTEGER PRIMARY KEY AUTOINCREMENT," +
				                              "level_index INTEGER," +
				                              "score INTEGER," +
				                              "player_health INTEGER," +
				                              "remaining_objects INTEGER" +
				                              ");";

		try (Connection conn = DriverManager.getConnection(URL);
		     Statement stmt = conn.createStatement()) {
			stmt.execute(playerTable);
			stmt.execute(enemyTable);
			stmt.execute(objectTable);
			stmt.execute(levelTable);
			stmt.execute(completedLevelsTable);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void savePlayerData(Player player, int score) {
		loadDriver();
		String sql = "INSERT INTO Player (x, y, health, score) VALUES (?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
			Class.forName("org.sqlite.JDBC");
			pstmt.setInt(1, (int) player.getHitboxX());
			pstmt.setInt(2, (int) player.getHitboxY());
			pstmt.setInt(3, player.getCurrentHealth());
			pstmt.setInt(4, score);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static void saveEnemiesData(EnemyManager enemyManager) {
		loadDriver();
		String sql = "INSERT INTO Enemies (x, y, type) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {

			for (Enemy enemy : enemyManager.getEnemies())
			{
				if (enemy.isActive()) {
					pstmt.setInt(1, (int) enemy.getHitboxX());
					pstmt.setInt(2, (int) enemy.getHitboxY());
					pstmt.setInt(3, enemy.getEnemyType());
					pstmt.addBatch();
				}
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveObjectsData(ObjectManager objectManager) {
		loadDriver();
		String sql = "INSERT INTO Objects (x, y, type) VALUES (?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql))
		{

			for (GameObject object : objectManager.getObjects()) {
				pstmt.setInt(1, object.getX());
				pstmt.setInt(2, object.getY());
				pstmt.setInt(3, object.getObjType());
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void saveLevelData(int lvlIndex) {
		loadDriver();
		String sql = "INSERT INTO Level (lvlIndex) VALUES (?)";

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, lvlIndex);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void saveCompletedLevelData(int levelIndex, int score, int playerHealth, int remainingObjects) {
		loadDriver();
		String sql = "INSERT INTO CompletedLevels (level_index, score, player_health, remaining_objects) VALUES (?, ?, ?, ?)";

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, levelIndex);
			pstmt.setInt(2, score);
			pstmt.setInt(3, playerHealth);
			pstmt.setInt(4, remainingObjects);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void clearTables() {
		loadDriver();
		try (Connection conn = DriverManager.getConnection(URL);
		     Statement stmt = conn.createStatement()) {

			// Goleste tabela Player
			String clearPlayerTable = "DELETE FROM Player";
			stmt.executeUpdate(clearPlayerTable);

			// Goleste tabela Enemies
			String clearEnemiesTable = "DELETE FROM Enemies";
			stmt.executeUpdate(clearEnemiesTable);

			// Goleste tabela Objects
			String clearObjectsTable = "DELETE FROM Objects";
			stmt.executeUpdate(clearObjectsTable);

			// Goleste tabela Level
			String clearLevelTable = "DELETE FROM Level";
			stmt.executeUpdate(clearLevelTable);

			System.out.println("Tabelele au fost golite cu succes.");

		} catch (SQLException e) {
			System.err.println("Eroare la golirea tabelelor: " + e.getMessage());
		}
	}
	public static int getLevelValue() {
		loadDriver();
		String sql = "SELECT lvlIndex FROM Level";
		int levelValue = -1;

		try (Connection conn = DriverManager.getConnection(URL);
		     PreparedStatement pstmt = conn.prepareStatement(sql);
		     ResultSet rs = pstmt.executeQuery()) {

			if (rs.next()) {
				levelValue = rs.getInt("lvlIndex");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return levelValue;
	}

	public static ArrayList<EnemyData> getEnemiesData()
	{
		loadDriver();
		ArrayList<EnemyData> enemiesData = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(URL);
		     Statement stmt = conn.createStatement();
		     ResultSet rs = stmt.executeQuery("SELECT * FROM Enemies")) {

			while (rs.next()) {
				int x = rs.getInt("x");
				int y = rs.getInt("y");
				int type = rs.getInt("type");
				enemiesData.add(new EnemyData(x, y, type));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enemiesData;
	}
}