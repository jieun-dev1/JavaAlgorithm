package Inflearn;

import java.util.Scanner;

public class If21 {

	public int solution(int[][] arr, int n) {
		// n번째 행과 n번째 열의 합 비교. sum1과 sum2중 더 max인 것을 가져오기.
		// Math.max(a,b) 두 인자 중 더 큰 값을 가져옴.
		// 대각선인 경우
		int answer = Integer.MIN_VALUE;
		int sum1, sum2;
		for (int i = 0; i < n; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			// sum1이 더 클테니, answer가 sum1값으로 바뀔 것. 아래에서 sum2와 비교하니 sum2가 더 크면, answer값이 sum2가
			// 된다. \
			// i가 0,1..n을 거치면서 아래는 행/열 총 합 중에 가장 큰 answer 값으로 갱신 될 것.
			answer = Math.max(answer, sum1);
			answer = Math.max(answer, sum2);
		}
		sum1 = sum2 = 0;
		for (int i = 0; i < n; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][n - 1 - i];
		}
		answer = Math.max(answer, sum1);
		answer = Math.max(answer, sum2);
		return answer;
	}

	// Math.max();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 우선 모든 int를 받아오기
		If21 T = new If21();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] += sc.nextInt();
		}
		System.out.println(T.solution(arr, n));
		// 5개의 횡 더하기 5개씩 (열 더하기) 0,5,10,15,20 그리고 1에서 5씩 더해서

	}
}
