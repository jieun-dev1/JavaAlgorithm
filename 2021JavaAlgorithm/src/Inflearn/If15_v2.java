package Inflearn;

import java.util.Scanner;

public class If15_v2 {

	public String solution(int arrayA[], int arrayB[], int num) {
		String result = "";
		for (int i = 0; i < num; i++) {
			if (arrayA[i] == arrayB[i]) {
				result += "D";
			} else if (arrayA[i] == 2 && arrayB[i] == 1) {
				result += "A";
			} else if (arrayA[i] == 3 && arrayB[i] == 2) {
				result += "A";
			} else if (arrayA[i] == 1 && arrayB[i] == 3) {
				result += "A";
			} else {
				result += "B";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		If15_v2 T = new If15_v2();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arrayA = new int[num];
		int[] arrayB = new int[num];

		for (int i = 0; i < num; i++) {
			arrayA[i] = sc.nextInt();
		}

		for (int i = 0; i < num; i++) {
			arrayB[i] = sc.nextInt();
		}

		// String을 charArry로. 개행문자 따로 넣어줄 필요 없이 println으로.
		for (char x : T.solution(arrayA, arrayB, num).toCharArray())
			System.out.println(x);
	}
}

////		for (String x : T.solution(arrayA, arrayB, num))
////			System.out.print(x + "\n");
////	}
//		
