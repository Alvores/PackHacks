package packHacks.sports_manager.data;

/**
 * The team class contains information for a team such as the number of
 * games they won at home, away from home, and the number of points they
 * have accumulated in both categories over the season.
 * @author Gabriel Zingle
 */
public class Team {
	
	// Away games
	/** The total number of games won away from home. */
	private int awayGamesWon;
	/** The total number of points earned in games won away from home. */
	private int awayGamesWonPoints;
	/** The total number of games lost away from home. */
	private int awayGamesLost;
	/** The total number of points earned in games lost away from home. */
	private int awayGamesLostPoints;
	// Home games
	/** The total number of games won away at home. */
	private int homeGamesWon;
	/** The total number of points earned in games won at home. */
	private int homeGamesWonPoints;
	/** The total number of games lost at home. */
	private int homeGamesLost;
	/** The total number of points earned in games lost t home. */
	private int homeGamesLostPoints;
	// Team specifics
	private String teamID;
	
	/**
	 * Constructs a team object.
	 * @param teamID the string id of the team
	 */
	public Team(String teamID) {
		setTeamID(teamID);
		setAwayGamesWon(0);
		setAwayGamesWonPoints(0);
		setAwayGamesLost(0);
		setAwayGamesLostPoints(0);
		setHomeGamesWon(0);
		setHomeGamesWonPoints(0);
		setHomeGamesLost(0);
		setHomeGamesLostPoints(0);
	}

	/**
	 * Returns the number of games won away from home.
	 * @return the awayGamesWon
	 */
	public int getAwayGamesWon() {
		return awayGamesWon;
	}

	/**
	 * Sets the number of games won away from home.
	 * @param awayGamesWon the awayGamesWon to set
	 */
	public void setAwayGamesWon(int awayGamesWon) {
		this.awayGamesWon = awayGamesWon;
	}

	/**
	 * Return the number of points earned in won away games.
	 * @return the awayGamesWonPoints
	 */
	public int getAwayGamesWonPoints() {
		return awayGamesWonPoints;
	}

	/**
	 * Sets the number of points earned in won away games.
	 * @param awayGamesWonPoints the awayGamesWonPoints to set
	 */
	public void setAwayGamesWonPoints(int awayGamesWonPoints) {
		this.awayGamesWonPoints = awayGamesWonPoints;
	}

	/**
	 * Returns the number of games lost away from home.
	 * @return the awayGamesLost
	 */
	public int getAwayGamesLost() {
		return awayGamesLost;
	}

	/**
	 * Sets the number of games lost away from home.
	 * @param awayGamesLost the awayGamesLost to set
	 */
	public void setAwayGamesLost(int awayGamesLost) {
		this.awayGamesLost = awayGamesLost;
	}

	/**
	 * Returns the number of points earned in lost away games.
	 * @return the awayGamesLostPoints
	 */
	public int getAwayGamesLostPoints() {
		return awayGamesLostPoints;
	}

	/**
	 * Sets the number of points earned in lost away games.
	 * @param awayGamesLostPoints the awayGamesLostPoints to set
	 */
	public void setAwayGamesLostPoints(int awayGamesLostPoints) {
		this.awayGamesLostPoints = awayGamesLostPoints;
	}

	/**
	 * Returns the number of home games won.
	 * @return the homeGamesPoints
	 */
	public int getHomeGamesWon() {
		return homeGamesWon;
	}

	/**
	 * Sets the number of home games won.
	 * @param homeGamesPoints the homeGamesPoints to set
	 */
	public void setHomeGamesWon(int homeGamesPoints) {
		this.homeGamesWon = homeGamesPoints;
	}

	/**
	 * Returns the number of points earned in won home games.
	 * @return the homeGamesWonPoints
	 */
	public int getHomeGamesWonPoints() {
		return homeGamesWonPoints;
	}

	/**
	 * Sets the number of points earned in won home games.
	 * @param homeGamesWonPoints the homeGamesWonPoints to set
	 */
	public void setHomeGamesWonPoints(int homeGamesWonPoints) {
		this.homeGamesWonPoints = homeGamesWonPoints;
	}

	/**
	 * Returns the number of home games lost.
	 * @return the homeGamesLost
	 */
	public int getHomeGamesLost() {
		return homeGamesLost;
	}

	/**
	 * Sets the number of home games lost.
	 * @param homeGamesLost the homeGamesLost to set
	 */
	public void setHomeGamesLost(int homeGamesLost) {
		this.homeGamesLost = homeGamesLost;
	}

	/**
	 * Returns the number of points earned in lost home games.
	 * @return the homeGamesLostPoints
	 */
	public int getHomeGamesLostPoints() {
		return homeGamesLostPoints;
	}

	/**
	 * Sets the number of points earned in lost home games.
	 * @param homeGamesLostPoints the homeGamesLostPoints to set
	 */
	public void setHomeGamesLostPoints(int homeGamesLostPoints) {
		this.homeGamesLostPoints = homeGamesLostPoints;
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

}
