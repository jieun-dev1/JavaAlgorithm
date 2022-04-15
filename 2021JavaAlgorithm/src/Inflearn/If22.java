package Inflearn;

import java.util.Scanner;

public class If22 {
	public int solution(int[][] arr, int n) {
		int answer = 0;

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (arr[i][j] > arr[i][j - 1] && arr[i][j] > arr[i][j + 1] && arr[i][j] > arr[i - 1][j]
						&& (arr[i][j] > arr[i + 1][j]))
					answer++;
			}

		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If22 T = new If22();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n + 2][n + 2];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(T.solution(arr, n));

	}

}
