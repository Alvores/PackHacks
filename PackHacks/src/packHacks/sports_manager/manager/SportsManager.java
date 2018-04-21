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
	private ArrayList<Team> teamsMostLoses;
	/** The teams list sorted by most points. */
	private ArrayList<Team> teamsPointsForWins;
	/** The teams list sorted by least points. */
	private ArrayList<Team> teamtsPointsForLoses;

	/**
	 * Constructs the SportsManager and reads in the data inputed by the indicated file.
	 * @param filename the filename to read from
	 */
	public SportsManager(String filename) {
		HashMap<String, Team> teamMap = null;
		try {
			teamMap = ReportReader.readGames(filename);
		} catch (FileNotFoundException e) {
			// Should not reach here, UI pre-tests file validity
			e.getMessage();
		}
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
		teamsMostWins = new ArrayList<>(tl.length);
		Collections.reverse(tempList);
		teamsMostWins.addAll(tempList);
		/////////////
		Arrays.sort(tl, new Comparator<Team>() { // Sort by games won
			@Override
			public int compare(Team t1, Team t2) {
				if (t1.getGamesLost() < t2.getGamesLost()) {
					return -1;
				} else if (t1.getGamesLost() > t2.getGamesLost()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		// Obtain lists by loses
		tempList = Arrays.asList(tl);
		teamsMostLoses = new ArrayList<>(tl.length);
		Collections.reverse(tempList);
		teamsMostLoses.addAll(tempList);
		/////////////
		Arrays.sort(tl, new Comparator<Team>() { // Sort by points
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
		// Obtain list by games won points
		tempList = Arrays.asList(tl);
		teamsPointsForWins = new ArrayList<>(tl.length);
		Collections.reverse(tempList);
		teamsPointsForWins.addAll(tempList);
		Arrays.sort(tl, new Comparator<Team>() { // Sort by points
			@Override
			public int compare(Team t1, Team t2) {
				if (t1.getGamesLostPoints() < t2.getGamesLostPoints()) {
					return -1;
				} else if (t1.getGamesLostPoints() > t2.getGamesLostPoints()) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		// Obtain list by games lost points
		tempList = Arrays.asList(tl);
		teamtsPointsForLoses = new ArrayList<>(tl.length);
		Collections.reverse(tempList);
		teamtsPointsForLoses.addAll(tempList);
	}

	/**
	 * Generates a report displaying the teams in order of how many games
	 * each time has won throughout the season.
	 * @return report the generated report
	 */
	public String generateWinsProfile() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team Win Performance:\n[  TeamID: Games Won");
		for (int i = 0; i < teamsMostWins.size(); i++) {
			Team t = teamsMostWins.get(i);
			sb.append("\n   ");
			sb.append(t.getTeamID());
			sb.append(": ");
			sb.append(t.getGamesWon());
		}
		sb.append("\n]");
		String profile = sb.toString();
		return profile;
	}

	/**
	 * Generates a report displaying the teams in order of how many games
	 * each time has lost throughout the season.
	 * @return report the generated report
	 */
	public String generateLosesProfile() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team Lost Performance:\n[  TeamID: Games Lost");
		for (int i = 0; i < teamsMostLoses.size(); i++) {
			Team t = teamsMostLoses.get(i);
			sb.append("\n   ");
			sb.append(t.getTeamID());
			sb.append(": ");
			sb.append(t.getGamesLost());
		}
		sb.append("\n]");
		String profile = sb.toString();
		return profile;
	}

	/**
	 * Generates a report displaying the teams in order of the greatest
	 * total points a team has acquired throughout the season.
	 * @return report the generated report
	 */
	public String generateGreatestTotalPointsProfile() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team Points earned in Won games Performance:\n[  TeamID: Points Won");
		for (int i = 0; i < teamsPointsForWins.size(); i++) {
			Team t = teamsPointsForWins.get(i);
			sb.append("\n   ");
			sb.append(t.getTeamID());
			sb.append(": ");
			sb.append(t.getGamesWonPoints());
		}
		sb.append("\n]");
		String profile = sb.toString();
		return profile;
	}

	/**
	 * Generates a report displaying the teams in order of the lowest
	 * total points a team has acquired throughout the season.
	 * @return report the generated report
	 */
	public String generateLowestTotalPointsProfile() {
		StringBuilder sb = new StringBuilder();
		sb.append("Team Points earned in lost games Performance:\n[  TeamID: Points Won");
		for (int i = 0; i < teamtsPointsForLoses.size(); i++) {
			Team t = teamtsPointsForLoses.get(i);
			sb.append("\n   ");
			sb.append(t.getTeamID());
			sb.append(": ");
			sb.append(t.getGamesLostPoints());
		}
		sb.append("\n]");
		String profile = sb.toString();
		return profile;
	}

}
