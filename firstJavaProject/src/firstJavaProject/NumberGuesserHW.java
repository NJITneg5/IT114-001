package firstJavaProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuesserHW {
	private int level = 1;
	private int strikes = 0;
	private int maxStrikes = 5;
	private int number = 0;
	private boolean isRunning = false;
	final String saveFile = "numberGuesserSave.txt";
	
	private int levelMultiplier = 71; 	//These numbers will be used to jumble up the save file. 
	//Since they are prime, you will have to divide the levelHash by this exact number in order to get a valid level
	
	private int maxLevelHash = 7029; 	//This is 99*71. For ease, we will assume that the maximum level is 99

	private String fool = "114"; 		//This has to be in the level save in order for it to load									
	/***
	 * Gets a random number between 1 and level.
	 * 
	 * @param level (level to use as upper bounds)
	 * @return number between bounds
	 */
	public static int getNumber(int level) {
		int range = 9 + ((level - 1) * 5);
		System.out.println("I picked a random number between 1-" + (range + 1) + ", let's see if you can guess.");
		return new Random().nextInt(range) + 1;
	}

	private void win() {
		System.out.println("That's right!");
		level++;// level up!
		saveLevel();
		strikes = 0;
		System.out.println("Welcome to level " + level);
		number = getNumber(level);
	}

	private void lose() {
		System.out.println("Uh oh, looks like you need to get some more practice.");
		System.out.println("The correct number was " + number);
		strikes = 0;
		level--;
		if (level < 1) {
			level = 1;
		}
		saveLevel();
		number = getNumber(level);
	}

	private void processCommands(String message) {
		if (message.equalsIgnoreCase("quit")) {
			System.out.println("Tired of playing? No problem, see you next time.");
			isRunning = false;
		}
		//CHEATS
		
		if (message.equalsIgnoreCase("change strikes"))
		{
			try (Scanner input = new Scanner(System.in);) {
				int change = input.nextInt();
				strikes = change;
				message = "" + change;
			}
			catch(Exception e) {
				return;
			}
		}
		
		if (message.equalsIgnoreCase("change max strikes"))
		{
			try (Scanner input = new Scanner(System.in);)
			{
				int change = input.nextInt();
				maxStrikes = change;
				message = "" + change;
			}
			catch(Exception e) {
				return;
			}
		}
		
		//FUNNY JOKE HOO-HA
		if(message.equalsIgnoreCase(" ")) {
			int range = 9 + ((level - 1) * 5);
			int randomGuess = new Random().nextInt(range);
			System.out.println("What are you doing?... I'll make a guess for you..." + randomGuess);
			message = "" + randomGuess;
		}
	}

	private void processGuess(int guess) {
		if (guess < 0) {
			return;
		}
		System.out.println("You guessed " + guess);
		if (guess == number) {
			win();
		} else {
			System.out.println("That's wrong");
			strikes++;
			if (strikes >= maxStrikes) {
				lose();
			} else {
				int remainder = maxStrikes - strikes;
				System.out.println("You have " + remainder + "/" + maxStrikes + " attempts remaining");
				if (guess > number) {
					System.out.println("Go Lower");
				} else if (guess < number) {
					System.out.println("Go Higher");
				}
			}
		}
	}

	private int getGuess(String message) {
		int guess = -1;
		try {
			guess = Integer.parseInt(message);
		} catch (NumberFormatException e) {
			System.out.println("You didn't enter a number, please try again");

		}
		return guess;
	}

	private void saveLevel() {
		
		int levelHash = level * levelMultiplier;
		String saveHash = "" + levelHash + fool; //To make save file number look like a random number
		
		try (FileWriter fw = new FileWriter(saveFile)) {
			fw.write("" + saveHash);// here we need to convert it to a String to record correctly
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private boolean loadLevel() {
		File file = new File(saveFile);
		if (!file.exists()) {
			return false;
		}
		String loadHash;
		
		try (Scanner reader = new Scanner(file)) {
			while (reader.hasNextLine()) {
				loadHash = reader.nextLine();
				int seperation = -1;
				seperation = loadHash.indexOf(fool);
				float levelHash = Float.parseFloat(loadHash.substring(0,seperation));
				if (levelHash <= maxLevelHash && levelHash % levelMultiplier == 0) 
				{ //Checks that the hash is under the threshold and that is divisible by the multiplier
						level = (int) levelHash / levelMultiplier;
						break;
				}
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} 
		catch(StringIndexOutOfBoundsException e3){
			e3.printStackTrace();
			return false;
		}
		catch (Exception e2) {
			e2.printStackTrace();
			return false;
		}
		
		return level > 1;
	}

	void run() {
		try (Scanner input = new Scanner(System.in);) {
			System.out.println("Welcome to Number Guesser HW!");
			System.out.println("I'll ask you to guess a number between a range, and you'll have " + maxStrikes
					+ " attempts to guess.");
			if (loadLevel()) {
				System.out.println("Successfully loaded level " + level + " let's continue then");
			}
			number = getNumber(level);
			isRunning = true;
			while (input.hasNext()) {
				String message = input.nextLine();
				processCommands(message);
				if (!isRunning) {
					break;
				}
				int guess = getGuess(message);
				processGuess(guess);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		NumberGuesserHW guesser = new NumberGuesserHW();
		guesser.run();
	}
}