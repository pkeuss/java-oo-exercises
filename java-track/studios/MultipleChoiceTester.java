import static org.junit.Assert.*;

import org.junit.Test;

public class MultipleChoiceTester {

	@Test
	public void testMultipleChoice() {
		MultipleChoice q = new MultipleChoice();
		assertEquals("Constructor Test: question 'ask' isn't correct, q", "", q.getAsk());
		assertEquals("Constructor Test: answer isn't correct, q", "", q.getAnswer());
		assertEquals("Constructor Test: amount of choices isn't correct, q", 0, q.howManyChoices());
	}

	@Test
	public void testMultipleChoiceString() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?");
		assertEquals("Constructor Test (question): question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("Constructor Test (question): answer isn't correct, q", "", q.getAnswer());
		assertEquals("Constructor Test (question): amount of choices isn't correct, q", 0, q.howManyChoices());
	}

	@Test
	public void testMultipleChoiceStringString() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("Constructor Test (question, answer): question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("Constructor Test (question, answer): answer isn't correct, q", "Cardinals", q.getAnswer());
		assertEquals("Constructor Test (question, answer): amount of choices isn't correct, q", 1, q.howManyChoices());
	}

	@Test
	public void testAddChoice() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("addChoice: question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("addChoice Test: answer isn't correct, q", "Cardinals", q.getAnswer());
		assertEquals("addChoice Test: amount of choices isn't correct, q, 1", 1, q.howManyChoices());
		q.addChoice("Pirates");
		assertEquals("addChoice Test: amount of choices isn't correct, q, 2", 2, q.howManyChoices());
		q.addChoice("Blues");
		assertEquals("addChoice Test: amount of choices isn't correct, q, 3", 3, q.howManyChoices());
		q.addChoice("Rams");
		assertEquals("addChoice Test: amount of choices isn't correct, q, 4", 4, q.howManyChoices());
		assertTrue("addChoice Test: answers don't match the choices added", q.sequentialDisplay().contains("Cardinals") && q.sequentialDisplay().contains("Pirates")
						&& q.sequentialDisplay().contains("Blues") && q.sequentialDisplay().contains("Rams"));
		
		q.addChoice("Rams5");
		q.addChoice("Rams6");
		q.addChoice("Rams7");
		q.addChoice("Rams8");
		q.addChoice("Rams9");
		q.addChoice("Rams10");
		q.addChoice("Rams11");
		q.addChoice("Rams12");
		q.addChoice("Rams13");
		q.addChoice("Rams14");
		q.addChoice("Rams15");
		q.addChoice("Rams16");
		q.addChoice("Rams17");
		q.addChoice("Rams18");
		q.addChoice("Rams19");
		q.addChoice("Rams20");
		q.addChoice("Rams21");
		q.addChoice("Rams22");
		q.addChoice("Rams23");
		q.addChoice("Rams24");
		q.addChoice("Rams25");
		q.addChoice("Rams26");
		q.addChoice("Rams27");
		assertTrue("addChoice Test: answers don't match the choices added Max element", q.sequentialDisplay().contains("Rams26"));
		assertFalse("addChoice Test: answers don't match the choices added over the max number of elements", q.sequentialDisplay().contains("Rams27"));
		
		
	}

	@Test
	public void testHowManyChoices() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("howManyChoices: question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("howManyChoices: answer isn't correct, q", "Cardinals", q.getAnswer());
		assertEquals("howManyChoices Test: amount of choices isn't correct, q, 1", 1, q.howManyChoices());
		q.addChoice("Pirates");
		assertEquals("howManyChoicese Test: amount of choices isn't correct, q, 2", 2, q.howManyChoices());
		q.addChoice("Blues");
		assertEquals("howManyChoices Test: amount of choices isn't correct, q, 3", 3, q.howManyChoices());
		q.addChoice("Rams");
		assertEquals("howManyChoices Test: amount of choices isn't correct, q, 4", 4, q.howManyChoices());
	}

	@Test
	public void testRemove() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("remove: question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("remove: answer isn't correct, q", "Cardinals", q.getAnswer());
		assertEquals("remove Test: amount of choices isn't correct, q, 1", 1, q.howManyChoices());
		q.addChoice("Pirates");
		assertEquals("remove Test: amount of choices isn't correct, q, 2", 2, q.howManyChoices());
		q.addChoice("Blues");
		assertEquals("remove Test: amount of choices isn't correct, q, 3", 3, q.howManyChoices());
		q.addChoice("Rams");
		assertEquals("remove Test: amount of choices isn't correct, q, 4", 4, q.howManyChoices());
		q.remove(1);
		assertEquals("remove Test: amount of choices isn't correct, q, 3b", 3, q.howManyChoices());
		assertFalse("addChoice Test: answers don't match the choices added", q.sequentialDisplay().contains("Pirates"));
		q.remove(2);
		assertEquals("remove Test: amount of choices isn't correct, q, 2b", 2, q.howManyChoices());
		assertFalse("addChoice Test: answers don't match the choices added", q.sequentialDisplay().contains("Rams"));
		q.remove(1);
		assertEquals("remove Test: amount of choices isn't correct, q, 1b", 1, q.howManyChoices());
		assertFalse("addChoice Test: answers don't match the choices added", q.sequentialDisplay().contains("Blues"));
	}

	@Test
	public void testSequentialDisplay() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("SequentiaDisplay: question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("SequentiaDisplay: answer isn't correct, q", "Cardinals", q.getAnswer());
		q.addChoice("Pirates");
		q.addChoice("Blues");
		q.addChoice("Rams");
		assertTrue("SequentiaDisplay Test: answers don't match the choices added", q.sequentialDisplay().contains("Cardinals") && q.sequentialDisplay().contains("Pirates")
				&& q.sequentialDisplay().contains("Blues") && q.sequentialDisplay().contains("Rams") && q.sequentialDisplay().contains("0") && q.sequentialDisplay().contains("1")
				&& q.sequentialDisplay().contains("2") && q.sequentialDisplay().contains("3"));
	}

	@Test
	public void testRandomlyDisplayChoices() {
		MultipleChoice q = new MultipleChoice("What is the name of the baseball team in St. Louis?", "Cardinals");
		assertEquals("RandomlyDisplayChoices: question 'ask' isn't correct, q", "What is the name of the baseball team in St. Louis?", q.getAsk());
		assertEquals("RandomlyDisplayChoices: answer isn't correct, q", "Cardinals", q.getAnswer());
		q.addChoice("Pirates");
		q.addChoice("Blues");
		q.addChoice("Rams");
		assertTrue("RandomlyDisplayChoices Test: answers don't match the choices added", q.randomlyDisplayChoices().contains("Cardinals") && q.randomlyDisplayChoices().contains("Pirates")
				&& q.randomlyDisplayChoices().contains("Blues") && q.randomlyDisplayChoices().contains("Rams") && q.randomlyDisplayChoices().contains("A") && q.randomlyDisplayChoices().contains("B")
				&& q.randomlyDisplayChoices().contains("C") && q.randomlyDisplayChoices().contains("D"));
	}

}
