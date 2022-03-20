package Inflearn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class If26 {

	public ArrayList<Integer> solution(int num1, int[] arr1, int num2, int[] arr2) {
		ArrayList list = new ArrayList<>();
		int pi = 0;
		int pj = 0;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		// 같지 않다가 아니라 작다로 접근.
		while (pi < num1 && pj < num2) {
			if (arr1[pi] == arr2[pj]) {
				list.add(arr1[pi]);
				pi++;
				pj++;
			} else if (arr1[pi] < arr2[pj]) {
				pi++;
			} else if (arr1[pi] > arr2[pj]) {
				pj++;
			}

		}

		return list;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If26 answer = new If26();
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int[] arr1 = new int[num1];
		for (int i = 0; i < num1; i++) {
			arr1[i] = sc.nextInt();
		}
		int num2 = sc.nextInt();
		int[] arr2 = new int[num2];
		for (int i = 0; i < num2; i++) {
			arr2[i] = sc.nextInt();
		}

		for (int data : answer.solution(num1, arr1, num2, arr2)) {
			System.out.print(data + " ");
		}
	}

}
