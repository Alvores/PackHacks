package packHacks.sports_manager.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
	
	public static void run() {
		String filename;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a filename for sports data input: ");
		System.out.println("Or enter -1 to terminate the program: ");
		filename = input.nextLine();
		if (filename.equals("-1")) {
			System.exit(0);
		}
		boolean valid = false;
		while (!valid) {
			try { // Check if file exists
				Scanner tester = new Scanner(new FileInputStream(filename));
				valid = true;
			} catch (FileNotFoundException e) { // Not a valid file name
				System.out.println("The file: " + filename + " is not valid.");
				System.out.println("Please enter a different filename: ");
				filename = input.nextLine();
			}
		}
	}

}
