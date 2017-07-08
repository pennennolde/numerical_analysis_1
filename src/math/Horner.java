package math;

public class Horner {

	public static void main(String[] args) {

		/*
		y(n) = a(n)*x^(n) +a(n-1)*x^(n-1) + - - - +a(1)*x +a(0);

		step1
		y(0) = a(n);

		step2
		for( int k=0; k<n; k++) {
			y(k+1) = y(k)*x +a(n-1-k);
		}

		System.out.println( y(n));

	/*
		ふつうに計算： a_k*x^k にk回演算
									項それぞれの合計は、k=1からnまでkをシグマ=(n(n+1))/2回
									最期に項の加算にn回
		Horner法：全部でn回の乗算とn回の加算

		*/
	}

}
