
public class Question {
	
	private String ask, answer;

	public Question() {
		this.ask = "";
		this.answer = "";
	}
	
	public Question(String ask) {
		this.ask = ask;
		this.answer = "";
	}
	
	public Question(String ask, String answer) {
		this.ask = ask;
		this.answer = answer;
	}
	
	/**
	 * 
	 * @param userInput (User's Answer)
	 * @return true if the answer is the same as the User's input
	 */
	public boolean isCorrect(String userInput){
		return (this.answer == userInput);
	}
	
	/**
	 * Returns the question and answer
	 */
	public String toString(){
		return ("Question: " + this.ask + "?\nAnswer: " + this.answer);
	}
	
	/**
	 * 
	 * @param includeAnswer if false then only the question is returned
	 * @return
	 */
	public String toString(boolean includeAnswer){
		if (includeAnswer == false){
			return ("Question: " + this.ask);
		}
		else {
			return this.toString();
		}
	}
	
	/**
	 * @return the ask
	 */
	public String getAsk() {
		return ask;
	}

	/**
	 * @param ask the ask to set
	 */
	public void setAsk(String ask) {
		this.ask = ask;
	}

	/**
	 * @return the answer
	 */
	public String getAnswer() {
		return answer;
	}

	/**
	 * @param answer the answer to set
	 */
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
