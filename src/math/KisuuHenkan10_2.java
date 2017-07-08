package math;

public class KisuuHenkan10_2 {

	public static void main(String[] args) {

		// step 1
		double z = 0.7777777777777;
		int x = (int) z;
		double y = z - x;

		System.out.println(x);
		System.out.println(y);

		// step 2
		int[] a = new int[20];

		int n =0;

		for( int i = 0; i <a.length; i++) {
			a[i] = x%2;
			x = x/2;
			if( x==1) {
				a[i+1] = x;
				n = i+1;
				break;
			}
		}

		// step 3
		int[] b = new int[20];

		for( int i = 0; i < b.length; i++) {
			b[i] = (int)(y*2);
			y = y*2 - b[i];
		}

		// step 4
		while( n >= 0 ) {
			System.out.print(a[n]);
			n--;
		}

		System.out.print(".");

		for( int i = 0; i < b.length; i++) {
			System.out.print(b[i]);
		}

	}
}
