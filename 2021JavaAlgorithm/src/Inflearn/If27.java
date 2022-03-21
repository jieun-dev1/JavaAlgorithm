package Inflearn;

import java.util.Scanner;

public class If27 {

	// sum�̶�� ���� ��� ����(?) �ϸ鼭 Math.max �� ���غ���.
	public int solution(int num, int k, int[] arr1) {
		int answer = 0, sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr1[i];
		}
		answer = sum;
		for (int pi = k; pi < num; pi++) {
			sum = sum + arr1[pi] - arr1[pi - k];
			answer = Math.max(answer, sum);
		}

//		while (pi < num) {
//			sum2 = sum + arr1[pi] - arr1[pi - k];
//			if (sum2 > sum) {
//				sum = sum2;
//			} 
//			pi++;
//		}
		return answer;
	}

	public static void main(String[] args) {
		If27 answer = new If27();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int k = sc.nextInt();
		int[] arr1 = new int[num];

		for (int i = 0; i < num; i++) {
			arr1[i] = sc.nextInt();
		}

		System.out.println(answer.solution(num, k, arr1));
	}

}
