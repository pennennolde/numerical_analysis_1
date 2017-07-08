package math;

public class KisuuHenkan2_10 {
	// (1011011010.0101)2 -> (?)10 ホーナー法
	public static void main(String[] args) {

		int[] a = new int[10]; //2進数の整数部分
		int[] b = new int[5]; //2進数の小数部分

		a[0] = 0; // 0の位
		a[1] = 1; // 2の位
		a[2] = 0;
		a[3] = 1;
		a[4] = 1;
		a[5] = 0;
		a[6] = 1;
		a[7] = 1;
		a[8] = 0;
		a[9] = 1;

		b[0] = 0; // 0の位
		b[1] = 0; // (1/2)の位
		b[2] = 1;
		b[3] = 0;
		b[4] = 1;

		//整数部分
		double[] y = new double[10];
		y[9] = a[9];
		for( int k = 8; k >= 0; k--) {
			y[k] = y[k+1]*2+a[k];
		}
		System.out.println( y[0] );

		//少数部分
		double[] z = new double[5];
		z[4] = b[4];
		for( int k =3; k >= 0; k--) {
			z[k] = z[k+1]/2+b[k];
		}
		System.out.println( z[0] );

		// 解
		double A = y[0] + z[0];
		System.out.println( "A="+A );
	}
}
