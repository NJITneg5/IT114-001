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
			
			if(actionCommand.equals("Select A")) {
				
			}
			
			if(actionCommand.equals("Select B")) {
				
			}

			if(actionCommand.equals("Select C")) {
				
			}
			
			if(actionCommand.equals("Select D")) {
				
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
	
	
}

