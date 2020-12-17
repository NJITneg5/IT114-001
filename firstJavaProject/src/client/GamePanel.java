package client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class GamePanel extends JPanel{

	private static final long serialVersionUID = 186732L;
	private BorderLayout border;
	private GamePanel self;
	
	private JPanel categoryNorth;
	private JLabel categoryText;
	private JLabel roundCounter;
	
	private JPanel spacerWest;
	
	private JPanel questionsCenter;
	private JLabel question;
	private JLabel choiceA;
	private JLabel choiceB;
	private JLabel choiceC;
	private JLabel choiceD;
	
	private JPanel buttonsSouth;
	private JButton answerA;
	private JButton answerB;
	private JButton answerC;
	private JButton answerD;
	
	private ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(3);
    private boolean timeOut = false;
    private boolean allAnswered = false;
	
    private int correctAnswerSpot;
    private boolean roundActive = false;
    
	public GamePanel() {
		self = this;
		border = new BorderLayout();
		
		buildContent();
	}
	
	void buildContent() {
		self.setLayout(border);
		
		categoryNorth = new JPanel();
		categoryNorth.setBorder(BorderFactory.createTitledBorder("Category"));
		categoryNorth.setLayout(new GridLayout(1,2));
		categoryText = new JLabel("Category: Test");
		roundCounter = new JLabel("Round Test/10");
		
		categoryNorth.add(categoryText);
		categoryNorth.add(roundCounter);
		
		questionsCenter = new JPanel();
		questionsCenter.setLayout(new GridLayout(5,1));
		
		question = new JLabel("Test Question");
		choiceA = new JLabel("A: Test");
		choiceB = new JLabel("B: Test");
		choiceC = new JLabel("C: Test");
		choiceD = new JLabel("D: Test");
		
		questionsCenter.add(question);
		questionsCenter.add(choiceA);
		questionsCenter.add(choiceB);
		questionsCenter.add(choiceC);
		questionsCenter.add(choiceD);
		
		buttonsSouth = new JPanel();
		buttonsSouth.setBorder(BorderFactory.createTitledBorder("Responses"));
		
		answerA = new JButton("Select A");
		answerA.setPreferredSize(new Dimension(200,26));
		answerA.addActionListener(new ResponseListener());
		
		answerB = new JButton("Select B");
		answerB.setPreferredSize(new Dimension(200,26));
		answerB.addActionListener(new ResponseListener());
		
		answerC = new JButton("Select C");
		answerC.setPreferredSize(new Dimension(200,26));
		answerC.addActionListener(new ResponseListener());
		
		answerD = new JButton("Select D");
		answerD.setPreferredSize(new Dimension(200,26));
		answerD.addActionListener(new ResponseListener());
		
		buttonsSouth.add(answerA);
		buttonsSouth.add(Box.createHorizontalStrut(15));
		buttonsSouth.add(answerB);
		buttonsSouth.add(Box.createHorizontalStrut(15));
		buttonsSouth.add(answerC);
		buttonsSouth.add(Box.createHorizontalStrut(15));
		buttonsSouth.add(answerD);
		
		self.add(categoryNorth, BorderLayout.NORTH);
		self.add(questionsCenter, BorderLayout.CENTER);
		self.add(buttonsSouth, BorderLayout.SOUTH);
	}
	
	public class ResponseListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			
			if(actionCommand.equals("Select A")) { //1
				if(roundActive) {
					if(correctAnswerSpot == 1) {
						SocketClient.sendAnswer(true);
						roundActive = false;
					}
					else {
						SocketClient.sendAnswer(false);
						roundActive = false;
					}
				}
			}
			
			if(actionCommand.equals("Select B")) { //2
				if(roundActive) {
					if(correctAnswerSpot == 2) {
						SocketClient.sendAnswer(true);
						roundActive = false;
					}
					else {
						SocketClient.sendAnswer(false);
						roundActive = false;
					}
				}
			}

			if(actionCommand.equals("Select C")) { //3
				if(roundActive) {
					if(correctAnswerSpot == 3) {
						SocketClient.sendAnswer(true);
						roundActive = false;
					}
					else {
						SocketClient.sendAnswer(false);
						roundActive = false;
					}
				}
			}
			
			if(actionCommand.equals("Select D")) { //4
				if(roundActive) {
					if(correctAnswerSpot == 4) {
						SocketClient.sendAnswer(true);
						roundActive = false;
					}
					else {
						SocketClient.sendAnswer(false);
						roundActive = false;
					}
				}
			}
		}
	}
	
	public boolean roundTimeOut() {
		if(!allAnswered) {
			timeOut = false;
	    	exec.schedule(()->{
	    		timeOut = true;
	    	},30000, TimeUnit.MILLISECONDS);
		}
	    return timeOut;
	}	
	
	public void buildRound(String[] gameInfo) {
		
		int totalRounds = Integer.parseInt(gameInfo[0]);
		int round = Integer.parseInt(gameInfo[1]);
		String roundCat = gameInfo[2];
		String roundQuest = gameInfo[3];
		int importedAnswerSpot = Integer.parseInt(gameInfo[4]);
		String textA = gameInfo[5];
		String textB = gameInfo[6];
		String textC = gameInfo[7];
		String textD = gameInfo[8];
		
		categoryText.setText("Category: " + roundCat);
		roundCounter.setText("Round " + (round + 1) + " / " + totalRounds);
		question.setText(roundQuest);
		choiceA.setText("A: " + textA);
		choiceB.setText("B: " + textB);
		choiceC.setText("C: " + textC);
		choiceD.setText("D: " + textD);
		
		correctAnswerSpot = importedAnswerSpot;
		roundActive = true;
		
	}
	
}

