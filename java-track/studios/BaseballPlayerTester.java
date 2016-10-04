import static org.junit.Assert.*;

import org.junit.Test;

public class BaseballPlayerTester {

	
	@Test
	public void testBaseballPlayer() {
		BaseballPlayer carp = new BaseballPlayer("Matt", "Carpenter");
		assertEquals("Constructor: just setting the name not working, First name", "Matt", carp.getFirstName());
		assertEquals("Constructor: just setting the name not working, Last name", "Carpenter", carp.getLastName());
		
		BaseballPlayer yadi = new BaseballPlayer("Yadier", "Molina", 4, "Right");
		assertEquals("Constructor: just setting the name not working, First name", "Yadier", yadi.getFirstName());
		assertEquals("Constructor: just setting the name not working, Last name", "Molina", yadi.getLastName());
		assertEquals("Constructor: just setting the name not working, First name", 4, yadi.getJersey());
		assertEquals("Constructor: just setting the name not working, Last name", "Right", yadi.getBats());
		
		BaseballPlayer diaz = new BaseballPlayer();
	}
	
	
	@Test
	public void testAddGameAndStats() {
		BaseballPlayer carp = new BaseballPlayer("Matt", "Carpenter");
		carp.addGameAndStats(120, 60, 80);
		assertEquals("AddGameAndStats: not working, Games", 1, carp.getGames());
		assertEquals("AddGameAndStats: not working, Hits", 120, carp.getHits());
		assertEquals("AddGameAndStats: not working, RBIs", 60, carp.getRBIs());
		assertEquals("AddGameAndStats: not working, runs", 80, carp.getRuns());
		
	}

	@Test
	public void testAddGame() {
		BaseballPlayer yadi = new BaseballPlayer("Yadier", "Molina", 4, "Right");
		yadi.addGame();
		assertEquals("AddGame(): not working, games", 1, yadi.getGames());
	}

	@Test
	public void testAddGames() {
		BaseballPlayer carp = new BaseballPlayer("Matt", "Carpenter");
		carp.addGames(5);;
		assertEquals("AddGames: not working, Games", 5, carp.getGames());
	}

	@Test
	public void testToString() {
		BaseballPlayer diaz = new BaseballPlayer();
		diaz.setAll("Aledmys", "Diaz", 36, "Right", 100, 116, 65, 68);
		assertEquals("toString: not working", "Player: Diaz , Aledmys\nJersey Number: 36\nBats Right-handed\nHas played in: 100 games"
						+ "\nHits: 116\tRBIs: 65\tRuns: 68", diaz.toString());
	}

	@Test
	public void testSetAll() {
		BaseballPlayer diaz = new BaseballPlayer();
		diaz.setAll("Aledmys", "Diaz", 36, "Right", 100, 116, 65, 68);
		assertEquals("SetAll: not working, First name", "Aledmys", diaz.getFirstName());
		assertEquals("SetAll: not working, Last name", "Diaz", diaz.getLastName());
		assertEquals("SetAll: not working, First name", 36, diaz.getJersey());
		assertEquals("SetAll: not working, Last name", "Right", diaz.getBats());
		assertEquals("SetAll: not working, Games", 100, diaz.getGames());
		assertEquals("SetAll: not working, Hits", 116, diaz.getHits());
		assertEquals("SetAll: not working, RBIs", 65, diaz.getRBIs());
		assertEquals("SetAll: not working, runs", 68, diaz.getRuns());
	}

}
