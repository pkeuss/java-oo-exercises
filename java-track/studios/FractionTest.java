import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author paul.keuss
 *
 */
public class FractionTest {

	/**
	 * Test method for {@link Fraction#Fraction(int, int)}.
	 */
	@Test
	public void testFraction() {
		Fraction f = new Fraction(1,2);
		assertEquals("Constructor Test: Numerator isn't correct", 1, f.getNum());
		assertEquals("Constructor Test: Denominator isn't correct", 2, f.getDenom());
	}

	/**
	 * Test method for {@link Fraction#sum(Fraction)}.
	 */
	@Test
	public void testSum() {
		Fraction f = new Fraction(1,3);
		Fraction f1 = new Fraction(1,3);
		Fraction f2 = f.sum(f1);
		assertEquals("Sum Test: Numerator isn't correct", 2, f2.getNum());
		assertEquals("Sum Test: Denominator isn't correct", 3, f2.getDenom());
		
		Fraction f3 = new Fraction(1,5);
		Fraction f4 = new Fraction(2,9);
		Fraction f5 = f3.sum(f4);
		assertEquals("Sum Test: Numerator isn't correct", 19, f5.getNum());
		assertEquals("Sum Test: Denominator isn't correct", 45, f5.getDenom());
	}

	/**
	 * Test method for {@link Fraction#gcd(int, int)}.
	 */
	@Test
	public void testGcd() {
		Fraction f = new Fraction(1,2);
		Fraction f1 = new Fraction(1,3);
		Fraction f2 = f.sum(f1);
		//Testing gcd by using sum and checking the denominator, because the sum method uses gcd
		assertEquals("gcd Test: Denominator isn't correct", 6, f2.getDenom());
	}

	/**
	 * Test method for {@link Fraction#simplify()}.
	 */
	@Test
	public void testSimplify() {
		Fraction f = new Fraction(8,10);
		f.simplify();
		assertEquals("Sum Test: Numerator isn't correct", 4, f.getNum());
		assertEquals("Sum Test: Denominator isn't correct", 5, f.getDenom());
	}

	/**
	 * Test method for {@link Fraction#multiply(Fraction)}.
	 */
	@Test
	public void testMultiply() {
		Fraction f = new Fraction(3,4);
		Fraction f1 = new Fraction(1,6);
		Fraction f2 = f.multiply(f1);
		assertEquals("Multiply Test: Numerator isn't correct", 1, f2.getNum());
		assertEquals("Multiply Test: Denominator isn't correct", 8, f2.getDenom());
	}

	/**
	 * Test method for {@link Fraction#recip()}.
	 */
	@Test
	public void testRecip() {
		Fraction f = new Fraction(8,10);
		Fraction f1 = f.recip();
		assertEquals("Recipricol Test: Numerator isn't correct", 10, f1.getNum());
		assertEquals("Recipricol Test: Denominator isn't correct", 8, f1.getDenom());
	}

	/**
	 * Test method for {@link Fraction#toString(boolean)}.
	 */
	@Test
	public void testToStringBoolean() {
		Fraction f = new Fraction(8,10);
		assertEquals("toString Test: Numerator isn't correct", "The fraction is 8/10", f.toString(false));
	}



}
