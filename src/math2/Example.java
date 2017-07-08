package math2;

public class Example {

	public static void main(String[] args) {

		// 演習課題 ノルムの復習 問題5
		double []x3 = new double[100];
		for(int i=0; i<100; i++) {
			x3[i] = Math.sqrt(i+1);
		}
		System.out.println(Calc.vecNorm1(x3));
		System.out.println(Calc.vecNorm2(x3));
		System.out.println(Calc.vecNormInf(x3));


		// 演習課題 ノルムの復習 問題6
		double [][]A3 = new double[100][100];
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				A3[i][j] = Math.sqrt(2*(i+1)+(j+1));
			}
		}
		System.out.println(Calc.matNorm1(A3));
		System.out.println(Calc.matNormInf(A3));


	}
}
