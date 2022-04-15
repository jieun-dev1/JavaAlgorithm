package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

//퀵정렬:logn//정렬의 시간복잡도 O(nlogn) 자료갯수가 60000개라고 생각하면, 약 60000x16. 960000. ToPointer를 쓰면 O(N)
//answer.add(a[p1++]) 이렇게 써야 p1을 더한 뒤에 p1 이 증가함. 
public class If25 {

	public ArrayList<Integer> solution(int[] arr1, int[] arr2, int n1, int n2) {
		ArrayList<Integer> answer = new ArrayList<>();
		int p1 = 0, p2 = 0;
		while (p1 < n1 && p2 < n2) {
			if (arr1[p1] < arr2[p2]) {
				answer.add(arr1[p1++]);
			} else {
				answer.add(arr2[p2++]);
			}
		}

		while (p1 < n1) {
			answer.add(arr1[p1++]);
		}

		while (p2 < n2) {
			answer.add(arr2[p2++]);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If25 T = new If25();
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
		for (int x : T.solution(arr1, arr2, n1, n2)) {
			System.out.print((x) + " ");
		}

	}
}