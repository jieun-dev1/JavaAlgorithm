package Inflearn;

import java.util.Scanner;

public class If27v2 {

	public int solution(int day, int k, int[] list) {
		int sum = 0, answer = 0;
		for (int i = 0; i < k; i++) {
			sum += list[i];
			answer = sum;
		}

		for (int i = 0; i < day - k; i++) {
			sum += list[i + k] - list[i];
			answer = Math.max(answer, sum);
//			if (sum > answer) {
//				answer = sum;
//			}
		}

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		If27v2 answer = new If27v2();
		int day = sc.nextInt();
		int k = sc.nextInt();
		int[] list = new int[day];
		for (int i = 0; i < day; i++) {
			list[i] = sc.nextInt();
		}

		System.out.println(answer.solution(day, k, list));
	}

}
