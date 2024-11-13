package studio8;

import java.util.Scanner;

public class Quiz {

	private Question[] questions;
	
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	private String getUserAnswer() {
		Scanner in = new Scanner(System.in);
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	public int getTotalPoints() {
		int sum = 0;
		for(Question q : questions) {
			sum += q.getPoints();
		}
		return sum;
	}
	
	public void takeQuiz() {
		for (int i = 0; i < questions.length; i++) {
			questions[i].displayPrompt();
//			getUserAnswer();
			System.out.println(questions[i].checkAnswer(getUserAnswer()));
		}
		System.out.println(getTotalPoints());
	}
	
	public static void main(String[] args) {
		Question q = new Question("What number studio is this?", "8", 2);

		String[] choices = {"seven", "nine", "eight", "six"};
		Question multipleChoice = new MultipleChoiceQuestion("What studio is this?", "3", 1, choices);

		choices = new String[] {"instance variables", "git", "methods", "eclipse"};
		Question selectAll = new SelectAllQuestion("Select all of the following that can be found within a class:", "13", choices);

		Question p = new Question("When is Tracy's birthday?", "IDK :D", 1000000);
		
		choices = new String[] {"Chloe <3", "Chloe :D", "Chloe!!!", "Tracy :("};
		Question selectChloe = new SelectAllQuestion("Select who Katherine loves: ", "123", choices);
		
		Question[] questions = {q, multipleChoice, selectAll, p, selectChloe}; //create and add more questions!
		
		Quiz studio8quiz = new Quiz(questions);
		studio8quiz.takeQuiz();
	}
}
