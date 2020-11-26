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
	private String[] historyQuestions = new String[]	//Trivia sourced form https://www.triviaquestionsnow.com/for/history-trivia
			{"Where was the first drive in movie theater?",
				//New Jersey
			 "How many people have walked on the moon?",
			 	//12
			 "How many Presidents have been in office in the U.S?",
			 	//46
			 "Which shoe company got their name from the Greek Goddess of Victory?",
			 	//Nike
			 "What is the smallest country in the world?",
			 	//Vatican
			};
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
	
	private int rounds;
	
	//private Random rand = new Random();
	private int catIndex;
	private String catReturn;
	
	private int questIndex;
	private String questReturn;
	
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
	
}