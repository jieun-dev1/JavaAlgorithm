package Inflearn;

import java.util.Scanner;

//에라토스테레스 ch new int[21] ch[i] == 0
public class If17 {

	public int solution(int num) {
		int cnt = 0;
		int[] array = new int[num];
		for (int i = 0; i < num; i++) {
			array[i] = i + 1;
		}

		for (int i = 1; i < num - 1; i++) {
			int a = array[num - i];
			int b = array[num];
			if (a % b != 0) {

			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If17 T = new If17();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(T.solution(num));

	}

}
