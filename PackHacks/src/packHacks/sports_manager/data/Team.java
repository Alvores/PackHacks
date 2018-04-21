package packHacks.sports_manager.data;

import java.util.HashMap;

/**
 * The team class contains information for a team such as the number of
 * games they won at home, away from home, and the number of points they
 * have accumulated in both categories over the season.
 * @author Gabriel Zingle
 */
public class Team {
	
	// Season games
	/** The total number of games won. */
	private int gamesWon;
	/** The total number of points earned in games won. */
	private int gamesWonPoints;
	/** The total number of games lost. */
	private int gamesLost;
	/** The total number of points earned in games lost. */
	private int gamesLostPoints;
	// Team specifics
	private String teamID;
	/** Checks if number of games should be incremented. */
	private HashMap<String, String> games;
	
	/**
	 * Constructs a team object.
	 * @param teamID the string id of the team
	 */
	public Team(String teamID) {
		games = new HashMap<>();
		setTeamID(teamID);
		setGamesLost(0);
		setGamesLostPoints(0);
		setGamesWon(0);
		setGamesWonPoints(0);
	}

	/**
	 * Returns the number of games won.
	 * @return the gamesWon
	 */
	public int getGamesWon() {
		return gamesWon;
	}

	/**
	 * Sets the number of games won.
	 * @param gamesWon the gamesWon to set
	 */
	public void setGamesWon(int gamesWon) {
		this.gamesWon = gamesWon;
	}

	/**
	 * Return the number of points earned in won games.
	 * @return the awayGamesWonPoints
	 */
	public int getGamesWonPoints() {
		return gamesWonPoints;
	}

	/**
	 * Sets the number of points earned in won games.
	 * @param gamesWonPoints the gamesWonPoints to set
	 */
	public void setGamesWonPoints(int gamesWonPoints) {
		this.gamesWonPoints = gamesWonPoints;
	}

	/**
	 * Returns the number of games lost.
	 * @return the gamesLost
	 */
	public int getGamesLost() {
		return gamesLost;
	}

	/**
	 * Sets the number of games lost.
	 * @param gamesLost the gamesLost to set
	 */
	public void setGamesLost(int gamesLost) {
		this.gamesLost = gamesLost;
	}

	/**
	 * Returns the number of points earned in lost games.
	 * @return the gamesLostPoints
	 */
	public int getGamesLostPoints() {
		return gamesLostPoints;
	}

	/**
	 * Sets the number of points earned in lost games.
	 * @param gamesLostPoints the gamesLostPoints to set
	 */
	public void setGamesLostPoints(int gamesLostPoints) {
		this.gamesLostPoints = gamesLostPoints;
	}

	/**
	 * Returns the team ID.
	 * @return the teamID
	 */
	public String getTeamID() {
		return teamID;
	}

	/**
	 * Sets the team ID.
	 * @param teamID the teamID to set
	 */
	public void setTeamID(String teamID) {
		this.teamID = teamID;
	}
	
	/**
	 * Adjusts the team statistics based on the won played game.
	 * @param points the points to increment by
	 * @param day the day of the game the points were scored
	 */
	public void incrementGamesWon(int points, String day) {
		this.gamesWonPoints += points;
		if (!games.containsKey(day)) {
			this.gamesWon++;
			games.put(day, day);
		}
	}
	
	/**
	 * Adjusts the team statistics based on the lost played game.
	 * @param points the points to increment by
	 * @param day the day of the game the points were scored
	 */
	public void incrementGamesLost(int points, String day) {
		this.gamesLostPoints += points;
		if (!games.containsKey(day)) {
			this.gamesLost++;
			games.put(day, day);
		}
	}

}
