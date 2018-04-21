package packHacks.sports_manager.ui;

import java.io.FileNotFoundException;
import java.util.Scanner;

import packHacks.sports_manager.io.ReportReader;
import packHacks.sports_manager.manager.SportsManager;

/**
 * The SportsManagerUI class enables user interaction with the program.
 * @author Gabriel Zingle
 */
public class SportsManagerUI {
	
	/**
	 * Enables user interaction with the program.
	 * @param args the console arguments
	 */
	public static void main(String[] args) {
		run();
	}
	
	/**
	 * Runs the SportsManager program.
	 */
	public static void run() {
//		filename = "input/Events_2010.csv"; // For quick reference
//		filename = "input/Events_2010_large.csv"; // For quick reference
		String filename;
		Scanner input = new Scanner(System.in);
		System.out.println("Precede filename with exact extension of input/");
		System.out.println("Enter a filename for sports data input: ");
		System.out.println("Or enter -1 to terminate the program: ");
		filename = input.nextLine();
		if (filename.equals("-1")) {
			input.close();
			System.exit(0);
		}
		boolean valid = false;
		while (!valid) {
			try { // Check if file exists
				ReportReader.readGames(filename);
				valid = true;
			} catch (FileNotFoundException e) { // Not a valid file name
				System.out.println("The file: " + filename + " is not valid.");
				System.out.println("Please enter a different filename: ");
				filename = input.nextLine();
			}
		}
		SportsManager sm = new SportsManager(filename);
		System.out.println("Enter 0 to generate the statistics by games won.");
		System.out.println("Enter 1 to generate the statistics by games lost.");
		System.out.println("Enter 2 to generate the statistics by most points scored.");
		System.out.println("Enter 3 to generate the statistics by least points scored.");
		int alg = Integer.parseInt(input.nextLine().trim());
		while (alg < 0 || alg > 3) {
			System.out.println("The argument: " + alg + " is not valid.");
			System.out.println("Please enter a number between 0 and 3:");
			alg = Integer.parseInt(input.nextLine().trim());
		}
		String report = null;
		switch (alg) {
		case 0:
			report = sm.generateWinsProfile();
			break;
		case 1:
			report = sm.generateLosesProfile();
			break;
		case 2:
			report = sm.generateGreatestTotalPointsProfile();
			break;
		case 3:
			report = sm.generateLowestTotalPointsProfile();
			break;
		default:
			break; // Should not reach here
		}
		System.out.println(report);
		input.close();
	}

}
