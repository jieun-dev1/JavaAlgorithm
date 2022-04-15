package Inflearn;

import java.util.Scanner;

//2차원 배열로 푸는 문제. 
public class If21_wrong {

	public int solution(int[] arr, int n) {
		int sum = 0;
		int[] answer = new int[2 * n + 2];
		int[] cnt = new int[n ^ 2];
		// 5개씩 (행) 더하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				answer[i] += arr[n * i + j];
		}

		// 5개씩 (열) 더하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				answer[i + n] += arr[i + j * n];
		}

		// 대각선
		for (int j = 0; j < 5; j++) {
			answer[2 * n] += arr[j * (n + 1)];
		}

		// 대각선
		for (int j = 0; j < 5; j++) {
			answer[2 * n + 1] += arr[j * (n - 1) + n - 1];
		}

		System.out.println(arr[10]);

		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 우선 모든 int를 받아오기
		If21_wrong T = new If21_wrong();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n ^ 2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i] += sc.nextInt();
		}
		System.out.println(T.solution(arr, n));
		// 5개의 횡 더하기 5개씩 (열 더하기) 0,5,10,15,20 그리고 1에서 5씩 더해서

	}

}
