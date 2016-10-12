

import java.util.ArrayList;

public class MultipleChoice extends Question {
	
	private ArrayList<String> choices;	

	public MultipleChoice() {
		super();
		choices = new ArrayList<String>();
	}
	
	public MultipleChoice(String ask) {
		super(ask);
		choices = new ArrayList<String>();
	}
	
	public MultipleChoice(String ask, String answer) {
		super(ask, answer);
		choices = new ArrayList<String>();
		choices.add(answer);
	}
	
	public void addChoice(String choice){
		if(this.howManyChoices() < 26){
			choices.add(choice);
		}
		else{
			System.out.println("Too many choices already!  You've used the whole Alphabet!");
		}
		
	}
	
	public int howManyChoices(){
		return choices.size();
	}
	
	public void remove(int index){
		this.choices.remove(index);
	}
	
	public String sequentialDisplay(){
		String display = "";
		for(int i = 0; i < this.choices.size(); i++){
			display += (i + "\t" + this.choices.get(i) + "\n");
		}
		return display;
	}
	
	public String randomlyDisplayChoices(){
		String display = "";
		String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};		
		int[] used = new int[this.choices.size()];
		boolean alreadyUsed = true;
		boolean foundIt = false;
		for(int i = 0; i < this.choices.size(); i++){
			
			display += ("\n" + alphabet[i] + ". ");
			int r = (int)(Math.random() * this.choices.size());//randomly pick a choice Max(0 - 25)
			alreadyUsed = true;
			foundIt = false;
			do {
				for (int j = 0; j < i; j++){
					if(r == used[j]){
						foundIt = true;
					}
				}
				if (foundIt == true){
					r = (int)(Math.random() * this.choices.size());//randomly pick a new choice Max(0 - 25)
					System.out.println("New r = " + r);
				}
				
				else{
					used[i] = r;
					alreadyUsed = false;
				}
				foundIt = false;
			}while(alreadyUsed == true);
			
			display += (this.choices.get(r) + "\n");
		}
		return display;
	}

	public static void main(String[] args) {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		q.addChoice("Pirates");
		q.addChoice("Reds");
		q.addChoice("Blues");
		q.addChoice("Astros");
		q.addChoice("Mets");
		q.addChoice("Cubs");
		//System.out.println(q.howManyChoices());
		//System.out.println(q.choices.size());
		//System.out.println(q.randomlyDisplayChoices());
		System.out.println(q.sequentialDisplay());
		q.remove(1);
		System.out.println(q.sequentialDisplay());
	}
}
