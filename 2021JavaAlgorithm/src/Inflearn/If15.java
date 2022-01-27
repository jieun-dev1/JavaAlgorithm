package Inflearn;

import java.util.Scanner;

public class If15 {

	public String[] solution(int arrayA[], int arrayB[], int num) {
		String[] result = new String[num];
		for (int i = 0; i < num; i++) {
			if (arrayA[i] == arrayB[i]) {
				result[i] = "D";
			} else if (arrayA[i] == 2 && arrayB[i] == 1) {
				result[i] = "A";
			} else if (arrayA[i] == 3 && arrayB[i] == 2) {
				result[i] = "A";
			} else if (arrayA[i] == 1 && arrayB[i] == 3) {
				result[i] = "A";
			} else {
				result[i] = "B";
			}
		}
		return result;
	}

	public static void main(String[] args) {
		If15 T = new If15();
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

		for (String x : T.solution(arrayA, arrayB, num))
			System.out.print(x + "\n");
	}

}
