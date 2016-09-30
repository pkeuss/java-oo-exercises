
public class BaseballPlayer {
	
	//A Baseball Player has-a:
	private String firstName, lastName, bats;
	private int jersey, hits, RBIs, games, runs;
	
	//empty constructor to reserve memory
	public BaseballPlayer() {
		this.firstName = null;
		this.lastName = null;
		this.jersey = 0;
		this.bats = null;
		this.games = 0;
		this.hits = 0;
		this.RBIs = 0;
		this.runs = 0;
	}
	
	//Constructor when only the player's name is known
	public BaseballPlayer(String first, String last) {
		this.firstName = first;
		this.lastName = last;
	}
	
	//Constructor when only the player's name and uniform number is known
	public BaseballPlayer(String first, String last, int num) {
		this.firstName = first;
		this.lastName = last;
		this.jersey = num;
	}
	
	//Constructor when only the player's name, number, and batting position is known
	public BaseballPlayer(String first, String last, int num, String bats) {
		this.firstName = first;
		this.lastName = last;
		this.jersey = num;
		this.bats = bats;
	}
	
	/*
	 * Adds one game and accepts user input to add the stats from that game 
	 * (hits and RBIs for that game)
	 */
	public void addGameAndStats(int hit, int RBI, int run){
		this.addGame();
		this.hits += hit;
		this.RBIs += RBI;
		this.runs += run;
	}
	
	/*
	 * Adds just one game to the current player
	 */
	public void addGame(){
		this.games++;
	}
	
	/*
	 * adds a user specified amount of games to the current player
	 */
	public void addGames(int game){
		this.games += game;
	}
	
	/*
	 * Getters and Setters to follow
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBats() {
		return bats;
	}

	public void setBats(String bats) {
		this.bats = bats;
	}

	public int getJersey() {
		return jersey;
	}

	public void setJersey(int jersey) {
		this.jersey = jersey;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public int getRBIs() {
		return RBIs;
	}

	public void setRBIs(int rBIs) {
		RBIs = rBIs;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}
	
	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}
	
	/*
	* Returns a string that prints the player's name and attributes and stats
	*/
	public String toString(){
	return ("Player: " + this.lastName + " , " + this.firstName + "\nJersey Number: " + this.jersey +
	"\nBats " + this.bats + "-handed\nHas played in: " + this.games + " games\nHits: " +
	this.hits + "\tRBIs: " + this.RBIs + "\tRuns: " + this.runs);
	}
	
	/*
	 * Sets all of the fields for an instance of this class
	 */
	public void setAll(String first, String last, int num, String bats, int game, int hit, int rbi, int run) {
		this.firstName = first;
		this.lastName = last;
		this.jersey = num;
		this.bats = bats;
		this.games = game;
		this.hits = hit;
		this.RBIs = rbi;
		this.runs = run;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseballPlayer carp = new BaseballPlayer("Matt", "Carpenter");
		BaseballPlayer yadi = new BaseballPlayer("Yadier", "Molina", 4, "Right");
		BaseballPlayer diaz = new BaseballPlayer();
		yadi.setGames(140);
		yadi.setHits(150);
		yadi.setRBIs(54);
		yadi.setRuns(53);
		System.out.println(yadi + "\n");
		carp.addGames(5);
		carp.addGameAndStats(120, 60, 80);
		System.out.println(carp + "\n");
		carp.setBats("left");
		carp.setJersey(13);
		System.out.println(carp + "\n");
		diaz.setAll("Aledmys", "Diaz", 36, "Right", 100, 116, 65, 68);
		System.out.println(diaz);
	}

}
