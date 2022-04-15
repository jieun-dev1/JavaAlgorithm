package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class If25_v2 {
	public ArrayList<Integer> solution(int n1, int n2, int[] arr1, int[] arr2) {
		ArrayList<Integer> answer = new ArrayList<>();
		int pi = 0;
		int pj = 0;
		while (pi < n1 & pj < n2) {
			if (arr1[pi] < arr2[pj]) {
				answer.add(arr1[pi++]);
			} else {
				answer.add(arr2[pj++]);
			}
		}

		while (pi < n1) {
			answer.add(arr1[pi++]);
		}

		while (pj < n2) {
			answer.add(arr2[pj++]);
		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If25_v2 T = new If25_v2();
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int[] arr1 = new int[n1];
		for (int i = 0; i < n1; i++) {
			arr1[i] = sc.nextInt();
		}
		int n2 = sc.nextInt();
		int[] arr2 = new int[n2];

		for (int j = 0; j < n2; j++) {
			arr2[j] = sc.nextInt();
		}

		for (int x : T.solution(n1, n2, arr1, arr2)) {
			System.out.print((x) + " ");
		}

	}

}
