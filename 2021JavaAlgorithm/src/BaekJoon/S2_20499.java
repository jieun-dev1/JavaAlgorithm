package BaekJoon;

import java.util.Scanner;

public class S2_20499 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Lesson learned: String is a class derived from Object, while int is a
		// primitive.

		// Initialize Local Variable sc
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(sc.next()).useDelimiter("/");
//		Scanner sc = new Scanner(sc.next()).useDelimiter("/");
		int K = sc.nextInt();
		int D = sc.nextInt();
		int A = sc.nextInt();

		String result = "";

		// 논리 연산자를 활용해서, if의 or, AND 조건
		if (K + A < D || D == 0) {
			result = "가짜";
		} else {
			result = "진짜";
		}

		if (result == "진짜") {
			System.out.println("gosu");
		} else {
			System.out.println("hasu");

		}
	}

}
