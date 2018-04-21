package packHacks.sports_manager.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

import packHacks.sports_manager.data.Team;

/**
 * The ReportReader class reads in information from an input file to
 * create a hash map of teams with sports data such as wins and loses.
 * @author Gabriel Zingle
 */
public class ReportReader {
	

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
		return teams;
	}
	
	/**
	 * Reads in a line from the input and parses it into relevant information.
	 * @param fileline the line to parse
	 */
	private static void parseEvent(String fileline) {
		fileline = fileline.trim();
		String[] data = fileline.split(",");
		if (data.length != 11) {
			throw new IllegalArgumentException(); // Skip this input line
		}
		String day = data[2].trim();
		String winningTeam = data[3].trim();
		String losingTeam = data[4].trim();
		int winPoints = Integer.parseInt(data[5].trim());
		int losePoints = Integer.parseInt(data[6].trim());
		if (teams.containsKey(winningTeam)) { // Update win team data
			Team team = teams.get(winningTeam);
			team.incrementGamesWon(winPoints, day);
		} else { // Form new team
			Team team = new Team(winningTeam);
			team.incrementGamesWon(winPoints, day);
			teams.put(winningTeam, team);
		}
		if (teams.containsKey(losingTeam)) { // Update lose team data
			Team team = teams.get(losingTeam);
			team.incrementGamesLost(losePoints, day);
		} else { // Form new team
			Team team = new Team(losingTeam);
			team.incrementGamesLost(losePoints, day);
			teams.put(losingTeam, team);
		}
	}

}
