package Inflearn;

import java.util.Scanner;

//2���� �迭�� Ǫ�� ����. 
public class If21_wrong {

	public int solution(int[] arr, int n) {
		int sum = 0;
		int[] answer = new int[2 * n + 2];
		int[] cnt = new int[n ^ 2];
		// 5���� (��) ���ϱ�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				answer[i] += arr[n * i + j];
		}

		// 5���� (��) ���ϱ�
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				answer[i + n] += arr[i + j * n];
		}

		// �밢��
		for (int j = 0; j < 5; j++) {
			answer[2 * n] += arr[j * (n + 1)];
		}

		// �밢��
		for (int j = 0; j < 5; j++) {
			answer[2 * n + 1] += arr[j * (n - 1) + n - 1];
		}

		System.out.println(arr[10]);

		return sum;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �켱 ��� int�� �޾ƿ���
		If21_wrong T = new If21_wrong();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n ^ 2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				arr[i] += sc.nextInt();
		}
		System.out.println(T.solution(arr, n));
		// 5���� Ⱦ ���ϱ� 5���� (�� ���ϱ�) 0,5,10,15,20 �׸��� 1���� 5�� ���ؼ�

	}

}
