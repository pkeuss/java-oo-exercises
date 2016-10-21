import java.util.Scanner;

public class Quiz {
	
	private Question[] questions;
	private MultipleChoice[] choiceQuestions;
	private int questionIndex, choiceIndex;
	private Scanner s;

	public Quiz(int size) {
		this.questions = new Question[size];
		this.choiceQuestions = new MultipleChoice[size];
		this.questionIndex = 0;
		this.choiceIndex = 0;
		
	}
	
	public void addFillInTheBlank(String question, String answer) {
		this.questions[this.questionIndex] = new Question(question, answer);
		this.questionIndex++;
	}
	
	public void addMultipleChoiceQuestion(String question, String answer) {
		this.choiceQuestions[this.choiceIndex] = new MultipleChoice(question, answer);
		this.choiceIndex++;
	}
	
	public void addMultipleChoices(int index, String choice) {
		this.choiceQuestions[index].addChoice(choice);
	}
	
	public String doQuiz(){
		int number = this.choiceIndex;
		for (int i = 0; i < this.choiceIndex; i++){
			System.out.println(this.choiceQuestions[number].getAsk());
			System.out.println(this.choiceQuestions[number].randomlyDisplayChoices());
		}
	}
	
/*	public static void main(String[] args) {

		int x = 0;
		Quiz q = new Quiz(10);
		do {
			x = q.startMenu();
			q.processInput(x);
		}while (x != 6);

	}
*/
}
