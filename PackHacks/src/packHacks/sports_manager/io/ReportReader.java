package packHacks.sports_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import packHacks.sports_manager.data.Game;
import packHacks.sports_manager.data.Team;

/**
 * The ReportReader class reads in information from an input file to
 * create a hash map of teams with sports data such as wins and loses.
 * @author Gabriel Zingle
 */
public class ReportReader {
	
	/** The hash map of games to help form the teams. */
	private static HashMap<String, Game> games;
	/** The hash map of teams to form and return. */
	private static HashMap<String, Team> teams;
	
	/**
	 * Reads in an input file and forms a hash map of teams with
	 * relevant data such as won and lost games.
	 * @param filename the name of the input file to read from
	 * @return teams the hash map of teams to return
	 * @throws FileNotFoundException if file is not found
	 */
	public static HashMap<String, Team> readGames(String filename) throws FileNotFoundException {
		try (Scanner readFile = new Scanner(new FileInputStream(filename))) {
			games = new HashMap<>();
			teams = new HashMap<>();
			readFile.nextLine(); // The first line in input file consists of data headers
			while (readFile.hasNextLine()) {
				try {
					parseEvent(readFile.nextLine());
				} catch (IllegalArgumentException e) {
					continue; // Guards from potentially invalid input
				}
			}
		}
		makeTeams();
		return teams;
	}
	
	private static void parseEvent(String fileline) {
		fileline = fileline.trim();
		String[] data = fileline.split(",");
		if (data.length != 5) {
			throw new IllegalArgumentException(); // Skip this input line
		}
		String day = data[2].trim();
		String winningTeam = data[3].trim();
		String losingTeam = data[4].trim();
		int winPoints = Integer.parseInt(data[5].trim());
		int losePoints = Integer.parseInt(data[6].trim());
		if (games.containsKey(day)) { // Update game information
			Game current = games.get(day);
			int currentWonPoints = current.getWinPoints();
			int currentLosePoints = current.getLosePoints();
			current.setWinPoints(currentWonPoints + winPoints);
			current.setLosePoints(currentLosePoints + losePoints);
		} else { // Create and add game
			Game game = new Game(winningTeam, losingTeam, day);
			games.put(day, game);
		}
	}
	
	/**
	 * Adds and adjusts teams with their game performance across
	 * a season as provided by the initial input file.
	 */
	private static void makeTeams() {
		Set<String> gameSet = teams.keySet();
		for (String str: gameSet) {
			Game game = games.get(str);
			String winID = game.getWinningTeam();
			String loseID = game.getLosingTeam();
			if (teams.containsKey(winID)) { // Update win team data
				Team team = teams.get(winID);
				team.incrementGamesWon(game);
			} else { // Form new team
				Team team = new Team(winID);
				team.incrementGamesWon(game);
			}
			if (teams.containsKey(loseID)) { // Update lose team data
				Team team = teams.get(loseID);
				team.incrementGamesLost(game);
			} else { // Form new team
				Team team = new Team(loseID);
				team.incrementGamesLost(game);
			}
		}
	}

}
