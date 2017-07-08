package math;

public class Char {

	public static void main(String[] args) {

		char c = 'a';
		//c++;
		int b = c;
		System.out.println( "c=" + c + ", b=" + b );

		System.out.println((char)b);

		int x = 98;
		System.out.println((char)x);
		System.out.println(Character.getNumericValue(x));

	}

}
