package Inflearn;

import java.util.ArrayList;
//막혔던 포인트: (1) pi가 num1을 채우면 사라지게 하고 싶음 -> while 문을 쓰면 된다. 
//int 배열이 아닌 ArrayList를 사용하자. (1) 사이즈가 동적 (2)배열에선 인덱스값도 같이 줘야하는데, arraylist는 값만 더해주면 됨. 
import java.util.Scanner;

public class IfTwoPointer {

	public ArrayList<Integer> solution(int[] arr1, int[] arr2, int num1, int num2) {
		ArrayList<Integer> answer = new ArrayList<>();
		int pi = 0;
		int pj = 0;

		while (pi < num1 && pj < num2) {
			if (arr1[pi] <= arr2[pj]) {
				answer.add(arr1[pi]);
				pi++; // 이렇게 별도로 넣으려면 if else block 을 묶어줘야 함.
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