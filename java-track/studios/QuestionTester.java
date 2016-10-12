import static org.junit.Assert.*;

import org.junit.Test;

public class QuestionTester {

	@Test
	public void testQuestion() {
		Question q = new Question();
		assertEquals("Constructor Test: question 'ask' isn't correct, q", "", q.getAsk());
		assertEquals("Constructor Test: answer isn't correct, q", "", q.getAnswer());
	}

	@Test
	public void testQuestionString() {
		Question q1 = new Question("What is my first name?");
		assertEquals("Constructor Test: question 'ask' isn't correct, q1", "What is my first name?", q1.getAsk());
		assertEquals("Constructor Test: answer isn't correct, q1", "", q1.getAnswer());
	}

	@Test
	public void testQuestionStringString() {
		Question q2 = new Question("What is my first name?", "Paul");
		assertEquals("Constructor Test: question 'ask' isn't correct, q2", "What is my first name?", q2.getAsk());
		assertEquals("Constructor Test: answer isn't correct, q2", "Paul", q2.getAnswer());
	}

	@Test
	public void testIsCorrect() {
		Question q = new Question("What is 2 + 2", "4");
		boolean correct = false;
		correct = q.isCorrect("4");
		assertEquals("IsCorrect Test: true test isn't correct", true, correct);
		correct = q.isCorrect("5");
		assertEquals("IsCorrect Test: false test isn't correct", false, correct);
	}

	@Test
	public void testToString() {
		Question q = new Question("What is my first name?", "Paul");
		assertTrue("toString: no boolean version isn't working", q.toString().contains(q.getAsk()) && q.toString().contains(q.getAnswer()));
	}

	@Test
	public void testToStringBoolean() {
		Question q = new Question("What is my first name?", "Paul");
		assertTrue("toString: boolean version isn't working", q.toString(false).contains(q.getAsk()) && q.toString(true).contains(q.getAnswer()));
	}

}
