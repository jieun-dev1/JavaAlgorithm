package Inflearn;

import java.util.Scanner;

//¿À´ä 
public class If19 {

	public int solution(int num, int[] arr) {
		int[] score = new int[num];
		int answer = 0;
		for (int i = 0; i < num; i++) {
			if (arr[0] == 1) {
				score[0] = 1;
				answer += score[0];
			} else if (arr[i] == 1 && arr[i - 1] == 0) {
				score[i] = 1;
				answer += score[i];
			} else if (arr[i] == 0) {
				score[i] = 0;
			} else if (arr[i] == 1 && arr[i - 1] == 1) {
				score[i] = score[i - 1] + arr[i];
				answer += score[i];
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If19 T = new If19();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(T.solution(num, arr));
	}

}
