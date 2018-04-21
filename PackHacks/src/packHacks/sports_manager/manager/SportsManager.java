package packHacks.sports_manager.manager;

import java.io.FileNotFoundException;
import java.util.*;

import packHacks.sports_manager.data.Team;
import packHacks.sports_manager.io.ReportReader;

/**
 * The SportsManager class generates a statistical report on games based on
 * which algorithm has been ran.
 * 
 * @author Gabriel Zingle
 */
public class SportsManager {

	/** The list of teams to refer to for statistics. */
	private ArrayList<Team> teams;
	/** The teams list sorted by most wins. */
	private ArrayList<Team> teamsMostWins;
	/** The teams list sorted by least wins. */
	private ArrayList<Team> teamsLeastWins;
	/** The teams list sorted by most points. */
	private ArrayList<Team> teamsMostPoints;
	/** The teams list sorted by least points. */
	private ArrayList<Team> teamsLeastPoints;

	/**
	 * Constructs the SportsManager and reads in the data inputed by the indicated file.
	 * @param filename the filename to read from
	 * @throws FileNotFoundException  thrown if file is not found
	 */
	public SportsManager(String filename) throws FileNotFoundException {
		HashMap<String, Team> teamMap = ReportReader.readGames(filename);
		teams = new ArrayList<>();
		Set<String> teamSet = teamMap.keySet();
		for (String str: teamSet) {
			Team t = teamMap.get(str);
			teams.add(t);
		}
	}

	/**
	 * Generates a report displaying the teams in order of how many games
	 * each time has won throughout the season.
	 * @return report the generated report
	 */
	public String generateWinsProfile() {
		return null; // Placeholder
	}

	/**
	 * Generates a report displaying the teams in order of how many games
	 * each time has lost throughout the season.
	 * @return report the generated report
	 */
	public String generateLosesProfile() {
		return null; // Placeholder
	}

	/**
	 * Generates a report displaying the teams in order of the greatest
	 * total points a team has acquired throughout the season.
	 * @return report the generated report
	 */
	public String generateGreatestTotalPointsProfile() {
		return null; // Placeholder
	}

	/**
	 * Generates a report displaying the teams in order of the lowest
	 * total points a team has acquired throughout the season.
	 * @return report the generated report
	 */
	public String generateLowestTotalPointsProfile() {
		return null; // Placeholder
	}

}
