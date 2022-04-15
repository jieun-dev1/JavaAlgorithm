package Inflearn;

import java.util.ArrayList;
//������ ����Ʈ: (1) pi�� num1�� ä��� ������� �ϰ� ���� -> while ���� ���� �ȴ�. 
//int �迭�� �ƴ� ArrayList�� �������. (1) ����� ���� (2)�迭���� �ε������� ���� ����ϴµ�, arraylist�� ���� �����ָ� ��. 
import java.util.Scanner;

public class IfTwoPointer {

	public ArrayList<Integer> solution(int[] arr1, int[] arr2, int num1, int num2) {
		ArrayList<Integer> answer = new ArrayList<>();
		int pi = 0;
		int pj = 0;

		while (pi < num1 && pj < num2) {
			if (arr1[pi] <= arr2[pj]) {
				answer.add(arr1[pi]);
				pi++; // �̷��� ������ �������� if else block �� ������� ��.
			} else {
				answer.add(arr2[pj]);
				pj++;
			}
		}
		while (pi < num1) {
			answer.add(arr1[pi]);
			pi++;
		}

		while (pj < num2) {
			answer.add(arr2[pj]);
			pj++;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IfTwoPointer answer = new IfTwoPointer();
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


			for (int data : answer.solution(arr1, arr2, num1, num2)) {
				System.out.print(data + " ");
			}
//		System.out.println(answer.printResult(arr1, arr2, num1, num2, result));

		}

	}
}