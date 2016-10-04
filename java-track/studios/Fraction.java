
public class Fraction {
	
	// A Fraction has-a:
	private int num, denom;
	
	/**
	* Constructor
	* @param n
	* @param d
	*/
	public Fraction(int n, int d){
		this.num = n;
		this.denom = d;
	}
	/**
	* 
	* @param Add this fraction to another called f
	* @return return the simplified sum of the two fractions in a new instance
	*/
	public Fraction sum(Fraction f){
		int newNum = 0;
		if (this.denom == f.denom){
			newNum = this.num + f.getNum();
			return new Fraction(newNum, this.denom);
		}
		int newD = this.denom * f.denom;
		newNum = this.num * f.denom;
		int newNum2 = this.denom * f.num;
		newNum += newNum2;
		Fraction sum = new Fraction(newNum, newD);
		sum.simplify();
		return sum;
	}
	/**
	* 
	* @param n
	* @param d
	* @return the greatest common denominator
	*/
	public static int gcd(int n, int d){
		if(n % d == 0) return d;
		return gcd(d, n % d);
	}
	/**
	* put this fraction in its simplified form
	*/
	public void simplify(){
		int common = gcd(this.num, this.denom);
		this.num /= common;
		this.denom /= common;
	}
	/**
	* 
	* @param multiply this fraction by another called f
	* @return a new fraction that is the simplified product of the two
	*/
	public Fraction multiply(Fraction f){
		Fraction product = new Fraction(this.num * f.num, this.denom * f.denom);
		product.simplify();
		return product;
	}
	/**
	* 
	* @return the reciprocal of the fraction in a new fraction
	*/
	public Fraction recip(){
		return new Fraction(this.denom, this.num);
	}
	/**
	* returns String that prints the fractions like 
	* 1/4, 2 2/3, and so on when proper is true
	* otherwise the fraction is simply return as a numerator and denominator (26/10)
	*/
	public String toString(boolean proper){
		if(proper){
			if(this.denom < this.num){
				int rem = this.num % this.denom;
				int div = this.num - rem;
				int bigNum = div / this.denom;
				return("The fraction is " + bigNum + " " + rem + "/" + this.denom);
			}
		}
		return("The fraction is " + this.num + "/" + this.denom);
	}

	/**
	* @return the numerator
	*/
	public int getNum() {
		return num;
	}

	/**
	* @return the denominator
	*/
	public int getDenom() {
		return denom;
	}

	public static void main(String[] args) {
	// TODO Auto-generated method stub
		
		Fraction stu = new Fraction(3, 8);
		Fraction pu = new Fraction(2, 3);
		Fraction lo = stu.sum(pu);
		System.out.println(lo.toString(false));
		Fraction rec = stu.recip();
		System.out.println(rec.toString(true));
		Fraction mult = stu.multiply(lo);
		//asking for a proper fraction, but there isn't any simplifying that can be done
		System.out.println(mult.toString(true));
		
	}

}
