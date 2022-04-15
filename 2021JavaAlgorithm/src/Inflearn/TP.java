package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public ArrayList<Integer> solution(int num1, int num2, int[] Arr1, int[] Arr2) {
		ArrayList<Integer> list = new ArrayList<>();
		int pi = 0;
		int pj = 0;
		while (pi < num1 && pj < num2)
			if (Arr1[pi] < Arr2[pj])
				list.add(Arr1[pi++]);
			else
				list.add(Arr2[pj++]);

		while (pi < num1)
			list.add(Arr1[pi++]);

		while (pj < num2)
			list.add(Arr2[pj++]);

		return list;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main answer = new Main();
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int[] Arr1 = new int[num1];
		for (int i = 0; i < num1; i++) {
			Arr1[i] = sc.nextInt();
		}
		int num2 = sc.nextInt();
		int[] Arr2 = new int[num2];
		for (int i = 0; i < num2; i++) {
			Arr2[i] = sc.nextInt();
		}

		for (int data : answer.solution(num1, num2, Arr1, Arr2)) {
			System.out.print(data + " ");
		}
	}
}