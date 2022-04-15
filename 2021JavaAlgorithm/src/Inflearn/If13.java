package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class If13 {
	// ArrayList 써야하는 이유 (배열 값에 접근하려면, []인덱스를 사용해야 하기 때문] 결과 리스트가 고정되지 않으니 ARrayList
	// 쓴다.
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
