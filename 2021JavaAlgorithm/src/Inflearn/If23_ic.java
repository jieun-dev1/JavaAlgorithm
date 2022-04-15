package Inflearn;

import java.util.Scanner;

public class If23_ic {

	public int solution(int[][] arr, int n) {
		int answer = 0;
		int[][] arr2 = new int[n][n];
		int[] cnt = new int[n];

		// 배열 비교하면서 같은 값에는 1 추가하기.
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (arr[i][j] == arr[i + 1][j] && i + 1 < n) {
					arr2[i][i + 1] = 1;
					arr2[i + 1][i] = 1;
					i++;
				}

			}
		}

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (arr2[j][i] == 1) {
					cnt[i] += 1;
				}
			}
		}

		int max = cnt[0];
		for (int i = 0; i < cnt.length; i++) {
			if (cnt[i] > max) {
				max = cnt[i];
				answer = i;
			}
		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If23_ic T = new If23_ic();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		System.out.println(T.solution(arr, n));
	}

}
