package math;

public class KisuuHenkan10_8 {

	public static void main(String[] args) {

		// step 1
		double z = 230.0625;
		int x = (int) z;
		double y = z - x;

		// step 2
		int[] a = new int[20];

		int n =0;

		for( int i = 0; i <a.length; i++) {
			a[i] = x%8;
			x = x/8;
			if( x<8) {
				a[i+1] = x;
				n = i+1;
				break;
			}
		}

		// step 3
		int[] b = new int[20];

		for( int i = 0; i < b.length; i++) {
			b[i] = (int)(y*8);
			y = y*8 - b[i];
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
