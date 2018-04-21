package packHacks.sports_manager.data;

/**
 * The Game class contains information such the ID of the winning
 * and losing teams, along with the number of points earned by
 * both teams over the course of the game.
 * @author Gabriel Zingle
 */
public class Game {
	
	/** The ID of the winning team. */
	private String winningTeam;
	/** The ID of the losing team. */
	private String losingTeam;
	/** The points earned by the winning team over the course of the game. */
	private int winPoints;
	/** The points earned by the losing team over the course of the game. */
	private int losePoints;
	/** The day of the season the game was played. */
	private String day;
	
	/**
	 * Constructs the Game object.
	 * @param winningTeam the ID of the winning team
	 * @param losingTeam the ID of the losing team
	 * @param day the day in the season that the game was played
	 */
	public Game(String winningTeam, String losingTeam, String day) {
		setDay(day);
		setWinningTeam(winningTeam);
		setLosingTeam(losingTeam);
		setWinPoints(0);
		setLosePoints(0);
	}

	/**
	 * Returns the ID of the winning team.
	 * @return the winningTeam
	 */
	public String getWinningTeam() {
		return winningTeam;
	}

	/**
	 * Sets the ID of the winning team.
	 * @param winningTeam the winningTeam to set
	 */
	public void setWinningTeam(String winningTeam) {
		this.winningTeam = winningTeam;
	}

	/**
	 * Returns the ID of the losing team.
	 * @return the losingTeam
	 */
	public String getLosingTeam() {
		return losingTeam;
	}

	/**
	 * Sets the ID of the losing team.
	 * @param losingTeam the losingTeam to set
	 */
	public void setLosingTeam(String losingTeam) {
		this.losingTeam = losingTeam;
	}

	/**
	 * Returns the points earned by the winning team.
	 * @return the winPoints
	 */
	public int getWinPoints() {
		return winPoints;
	}

	/**
	 * Sets the points earned by the winning team.
	 * @param winPoints the winPoints to set
	 */
	public void setWinPoints(int winPoints) {
		this.winPoints = winPoints;
	}

	/**
	 * Returns the points earned by the losing team.
	 * @return the losePoints
	 */
	public int getLosePoints() {
		return losePoints;
	}

	/**
	 * Sets the points earned by the losing team.
	 * @param losePoints the losePoints to set
	 */
	public void setLosePoints(int losePoints) {
		this.losePoints = losePoints;
	}

	/**
	 * Returns the day in the season that the game was played.
	 * @return the day
	 */
	public String getDay() {
		return day;
	}

	/**
	 * Sets the day in the season that the game was played.
	 * @param day the day to set
	 */
	public void setDay(String day) {
		this.day = day;
	}

}
