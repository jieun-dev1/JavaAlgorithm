package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class If13 {
	// 배열을 쓰려고 했으나, 배열을 쓰면 인덱스를 일일이 정해줘야함. ArrayList쓰자.
	public ArrayList<Integer> solution(int num, int[] array) {
		ArrayList<Integer> answer = new ArrayList<>();
		answer.add(array[0]);

		for (int i = 1; i < num; i++)
			if (array[i] > array[i - 1]) {
				answer.add(array[i]);
			}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If13 T = new If13();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] array = new int[num];
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			array[i] = sc.nextInt();
		}

		for (int x : T.solution(num, array))
			System.out.print(x + " ");
	}
	// array를 for each 써서 하나씩 불러오기.

}
