package Inflearn;

import java.util.Scanner;

public class If19_v2 {

	public int solution(int num, int[] arr) {
		int answer = 0;
		int cnt = 0;
		for (int i = 0; i < num; i++) {
			if (arr[i] == 1) {
				cnt++;
				answer += cnt;
			}

			else
				cnt = 0;
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
