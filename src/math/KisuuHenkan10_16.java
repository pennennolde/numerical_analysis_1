package math;

public class KisuuHenkan10_16 {

	public static void main(String[] args) {

		double z = 0.777777777777777777777;


		System.out.println( Integer.toHexString( (int)z ));



		int x = (int)z;
		double y = z-x;

		// 整数部分
		int a[] = new int[20];
		int i1 = 0;

		while( x>0 ) {
			int w = x%16;
			if( w<10 ) {
				a[i1] = w;
			}else{
				a[i1] = HexaDecimal(w);
			}
			x = x/16;
			i1++;
		}
		i1--;

		// 少数部分
		int b[] = new int[20];
		int i2 = 0;

		while( y>0 ) {
			int w = (int)(y*16);
			if( w<10 ) {
				b[i2] = w;
			} else {
				b[i2] = HexaDecimal(w);
			}
			y = y*16-w;
			i2++;
		}
		i2--;

		// 出力
		while( i1>=0 ) {
			if( a[i1]<10 ) {
				System.out.print(a[i1]);
			} else {
				System.out.print((char)a[i1]);
			}
			i1--;
		}
		System.out.print(".");
		for( int k=0; k<=i2; k++) {
			if( b[k]<10 ) {
				System.out.print(b[k]);
			} else {
				System.out.print((char)b[k]);
			}
		}
	}


	static char HexaDecimal(int x) {
		char y = 'X';
		if( x==10) y = 'A';
		else if( x==11) y = 'B';
		else if( x==12) y = 'C';
		else if( x==13) y = 'D';
		else if( x==14) y = 'E';
		else if( x==15) y = 'F';
		else System.out.println("例外が発生しました。");
		return y;
	}
}
