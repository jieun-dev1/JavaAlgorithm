package Inflearn;

import java.util.Scanner;

public class If21 {

	public int solution(int[][] arr, int n) {
		// n��° ��� n��° ���� �� ��. sum1�� sum2�� �� max�� ���� ��������.
		// Math.max(a,b) �� ���� �� �� ū ���� ������.
		// �밢���� ���
		int answer = Integer.MIN_VALUE;
		int sum1, sum2;
		for (int i = 0; i < n; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < n; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			// sum1�� �� Ŭ�״�, answer�� sum1������ �ٲ� ��. �Ʒ����� sum2�� ���ϴ� sum2�� �� ũ��, answer���� sum2��
			// �ȴ�. \
			// i�� 0,1..n�� ��ġ�鼭 �Ʒ��� ��/�� �� �� �߿� ���� ū answer ������ ���� �� ��.
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
		// �켱 ��� int�� �޾ƿ���
		If21 T = new If21();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i][j] += sc.nextInt();
		}
		System.out.println(T.solution(arr, n));
		// 5���� Ⱦ ���ϱ� 5���� (�� ���ϱ�) 0,5,10,15,20 �׸��� 1���� 5�� ���ؼ�

	}
}
