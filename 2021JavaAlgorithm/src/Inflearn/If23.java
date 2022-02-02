package Inflearn;

import java.util.Scanner;

public class If23 {

	public int solution(int[][] arr, int n) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < n + 1; j++) {
				for (int k = 1; k < 6; k++) {
					if (arr[i][k] == arr[j][k]) {
						cnt++;
						break;
					}
				}
			}
			if (cnt > max) {
				max = cnt;
				answer = i;
			}

		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If23 T = new If23();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n + 1][6];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < 6; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(T.solution(arr, n));

	}

}
