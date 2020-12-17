package server;

//import java.util.Random;

public class Trivia {
	
	private String[] categories = new String[] {"Movies","Video Games","Animals","History","Music"};
	
	private String[] movieQuestions = new String[]	//Movie trivia sourced from https://parade.com/977752/samuelmurrian/movie-trivia/
			{"What is the name of the continent in which Lord Of the Rings takes place?",
				//Middle-Earth
			 "What was the fist feature-length animated movie ever?",
			 	//Snow White and the Seven Dwarfs
			 "In the Matrix, what color pill does Neo take?",
			 	//Red
			 "For what movie did Steven Spielberg win his first Oscar for Best Director?",
			 	//Schindler's List
			 "What is the highest-grossing R-rated movie of all time?"
			 	//Joker
			};
	private String[] movieAnswers = new String[] {"Middle-Earth", "Arda", "Beleriand", "Numinor", 
												  "Snow White and the Seven Dwarfs","Dumbo","Peter Pan","Fantasia", 
												  "Red","Purple","Blue","Green", 
												  "Schindler's List","Ready Player One","Saving Private Ryan","E.T", 
												  "Joker","The Matrix","Deadpool","Logan"};
	
	private String[] vgQuestions = new String[]	//Video game trivia sourced from https://www.triviaquestionsnow.com/for/video-games-trivia
			{"Nintendo began as a company selling what product?",
				//Playing Cards
			 "Which Mario character has appeared in all but one Mario Party game?",
			 	//Wario
			 "Which video game holds the record for having the highest budget ever?",
			 	//GTA V
			 "What planet is closest to the scalable size of Minecraft?",
			 	//Neptune
			 "What is the highest selling console of all time?",
			 	//PlayStation 2
			};
	
	private String[] vgAnswers = new String[] {"Playing Cards","Arcade Cabinets","Video Games","Televisions",
											   "Wario","Waluigi","Daisy","Birdo",
											   "GTA V","Cyberpunk 2077","Red Dead Redemption 2","The Last of Us Part 2",
											   "Neptune","Pluto","Uranus","Mars",
											   "Playstation 2","Xbox 360","Super Nintendo Entertainment System","Playstation 4"};

	
	private String[] animalQuestions = new String[]	//Animal trivia sourced from https://www.usefultrivia.com/science_trivia/animal_trivia_index_ii.html
			{"How far away can a wolf smill its prey?",
				//Nearly 2 miles
			 "What is the most venomous spider in the world?",
			 	//Brazilian wandering spider
			 "How many times can a hummingbird beat its wings in a second?",
			 	//80
			 "What percentage of a cat's bones are in its tail?",
			 	//10%
			 "How far can a squirrel fall without dying?",
			};
	
	private String[] animalAnswers = new String[] {"Nearly 2 Miles","About 1 mile","About 1/2 mile","Nearly 3 miles",
			 									   "Brazilian Wandering Spider","Daddy Long Legs","Black Widow","Brown Recluse",
												   "80","120","40","60",
												   "10%","5%","15%","17%",
												   "It doesn't matter","25ft","50ft","100ft"};
	
	private String[] historyQuestions = new String[]	//Trivia sourced form https://www.triviaquestionsnow.com/for/history-trivia
			{"Where was the first drive in movie theater?",
				//New Jersey
			 "How many people have walked on the moon?",
			 	//12
			 "How many Presidents have been elected to office in the U.S?",
			 	//46
			 "Which shoe company got their name from the Greek Goddess of Victory?",
			 	//Nike
			 "What is the smallest country in the world?",
			 	//Vatican
			};
	
	private String[] historyAnswers = new String[] {"New Jersey","California","Texas","Florida",
			   										"12","10","15","20",
			   										"46","45","44","47",
			   										"Nike","Adidas","Champion","Vans",
			   										"Vatican","Luxemburg","Guatemala","Swaziland"};
	
	private String[] musicQuestions = new String[]	//Trivia sourced from https://www.usefultrivia.com/music_trivia/
			{"In Risky Business, what song did Tom Cruise lip-sync to?",
				//Old Time Rock and Roll by Bob Seger
			 "What song plays during the opening credits of Guardians of the Galaxy?",
			 	//Come and Get Your Love by Redbone
			 "What was the first music video aired on MTV in 1981?",
			 	//Video Killed the Radio Star by The Buggles
			 "What song holds the record for the shortest song ever recorded?",
			 	//You Suffer by Napalm Death
			 "What song mentions 16 Hollywood Icons?",
			 	//Vogue by Madonna
			};
	
	private String[] musicAnswers = new String[] {"Old Time Rock and Roll by Bob Seger","Rock and Roll by Led Zeppelin","Back in Black by AC/DC","Rock of Ages by Def Leppard",
												  "Come and Get Your Love by Redbone","Hooked on a Feeling by Blue Swede","Spirit in the Sky by Norman Greenbaum","Escape(The Pina Colata Song) by Rupert Holmes",
												  "Video Killed the Radio Star by The Buggles","Start Me Up by The Rolling Stones","Under Pressure by David Bowie & Queen","Super Freak by Rick James",
												  "You Suffer by Napalm Death","Her Majesty by The Beatles","Speak to Me by Pink Floyd","Little Room by The White Stripes",
												  "Vogue by Madonna","Welcome to the Jungle by Guns and Roses","Man On the Moon by R.E.M.","Superman's Ghost by Don McLean"};
	private int rounds;
	
	//private Random rand = new Random();
	private int catIndex;
	private String catReturn;
	
	private int questIndex;
	private String questReturn;
	
	private int wrongCounter = 0;
	
	public Trivia(int r) {
		
	}
	
	public void setRounds(int r) {
		rounds = r;
	}
	
	public int getRounds() {
		return rounds;
	}
	
	public String getCategory() {
		
		double catRand = Math.random() * (4 - 0 + 1);
		catIndex = (int)catRand;
		catReturn = categories[catIndex];
		
		return catReturn;
	}
	
	public int getCatIndex() {
		return catIndex;
	}
	
	public String getQuestion(int cat) {
		
		double questRand = Math.random() * (4 - 0 + 1);
		questIndex = (int)questRand;
		
		switch(cat) {
		case 0:
			questReturn = movieQuestions[questIndex];
			break;
			
		case 1:
			questReturn = vgQuestions[questIndex];
			break;
			
		case 2:
			questReturn = animalQuestions[questIndex];
			break;
			
		case 3:
			questReturn = historyQuestions[questIndex];
			break;
			
		case 4:
			questReturn = musicQuestions[questIndex];
			break;
			
		}
		
		return questReturn;
	}
	
	public int getQuestIndex() {
		return questIndex;
	}
	
	public String[] getAnswers(int cat, int quest) {
		
		wrongCounter = 0;
		
		int correctAnswerIndex = 4 * quest;
		String correctAnswer = "error";
		String[] wrongAnswers = new String[3];
		
		switch(cat) {
		case 0:
			correctAnswer = movieAnswers[correctAnswerIndex];
			wrongAnswers[0] = movieAnswers[(correctAnswerIndex + 1)];
			wrongAnswers[1] = movieAnswers[(correctAnswerIndex + 2)];
			wrongAnswers[2] = movieAnswers[(correctAnswerIndex + 3)];
			break;
			
		case 1:
			correctAnswer = vgAnswers[correctAnswerIndex];
			wrongAnswers[0] = vgAnswers[(correctAnswerIndex + 1)];
			wrongAnswers[1] = vgAnswers[(correctAnswerIndex + 2)];
			wrongAnswers[2] = vgAnswers[(correctAnswerIndex + 3)];
			break;
			
		case 2:
			correctAnswer = animalAnswers[correctAnswerIndex];
			wrongAnswers[0] = animalAnswers[(correctAnswerIndex + 1)];
			wrongAnswers[1] = animalAnswers[(correctAnswerIndex + 2)];
			wrongAnswers[2] = animalAnswers[(correctAnswerIndex + 3)];
			break;
			
		case 3:
			correctAnswer = historyAnswers[correctAnswerIndex];
			wrongAnswers[0] = historyAnswers[(correctAnswerIndex + 1)];
			wrongAnswers[1] = historyAnswers[(correctAnswerIndex + 2)];
			wrongAnswers[2] = historyAnswers[(correctAnswerIndex + 3)];
			break;
			
		case 4:
			correctAnswer = musicAnswers[correctAnswerIndex];
			wrongAnswers[0] = musicAnswers[(correctAnswerIndex + 1)];
			wrongAnswers[1] = musicAnswers[(correctAnswerIndex + 2)];
			wrongAnswers[2] = musicAnswers[(correctAnswerIndex + 3)];
			break;
			
		}
		
		boolean usedAll = false;
		
		double correctAnswerRand = Math.random() * (3 - 0 + 1);
		int correctAnswerPlacement = (int)correctAnswerRand + 1;
		String[] returnArray = new String[5];
		returnArray[0] = Integer.toString(correctAnswerPlacement);
		returnArray[correctAnswerPlacement] = correctAnswer;
		
		while(!usedAll) {
			double placeRand = Math.random() *(3 - 0 + 1);
			int placement = (int)placeRand + 1;
			
			if(returnArray[placement] == null) {
				returnArray[placement] = wrongAnswers[wrongCounter];
				wrongCounter++;
			}
			
			if(returnArray[0] != null && returnArray[1] != null && returnArray[2] != null && returnArray[3] != null && returnArray[4] != null) {
				usedAll = true;
			}
		}
		
		return returnArray;
	}
	
	
	
	
	
	
	
}