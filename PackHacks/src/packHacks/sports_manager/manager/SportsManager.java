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
		// Form main list
		for (String str: teamSet) {
			Team t = teamMap.get(str);
			teams.add(t);
		}
		// Form statistically sorted lists: games lost, games won, most points, least points
		Team[] tl = teams.toArray(new Team[teams.size()]);
		Arrays.sort(tl, new Comparator<Team>() { // Sort by games won
			@Override
			public int compare(Team t1, Team t2) {
				if (t1.getGamesWon() < t2.getGamesWon()) {
					return -1;
				} else if (t1.getGamesWon() > t2.getGamesWon()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		// Obtain lists by wins
		List<Team> tempList = Arrays.asList(tl);
		teamsLeastWins = new ArrayList<>(tl.length);
		teamsLeastWins.addAll(tempList);
		teamsMostWins = new ArrayList<>(tl.length);
		Collections.reverse(tempList);
		teamsMostWins.addAll(tempList);
		// Obtain lists by points
		Arrays.sort(tl, new Comparator<Team>() { // Sort by games won
			@Override
			public int compare(Team t1, Team t2) {
				if (t1.getGamesWonPoints() < t2.getGamesWonPoints()) {
					return -1;
				} else if (t1.getGamesWonPoints() > t2.getGamesWonPoints()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
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
