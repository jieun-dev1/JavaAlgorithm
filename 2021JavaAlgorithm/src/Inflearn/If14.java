package Inflearn;

import java.util.Scanner;

//정수 100,000이 주어짐. 이중for문 x - 시간복잡도 상 1초 안에 안될 것. 
public class If14 {

	public int solution(int[] array, int num) {
		int max = array[0];
		int cnt = 1;
		for (int i = 1; i < num; i++) {
			if (array[i] > max) {
				max = array[i];
				cnt++;
			}
		}

		return cnt;
	}

	public static void main(String[] args) {
		If14 T = new If14();
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] array = new int[num];
		int cnt = 1;

		for (int i = 0; i < num; i++) {
			array[i] = sc.nextInt();
		}
		System.out.print(T.solution(array, num));

	}

}

//	public static void main(String[] args) {
//	// TODO Auto-generated method stub
//	If14 T = new If14();
//	Scanner sc = new Scanner(System.in);
//	int num = sc.nextInt();
//	int[] array = new int[num];
//	int max = array[0];
//	int cnt = 1;
//
//	for (int i = 1; i < num; i++) {
//		array[i] = sc.nextInt();
//		if (array[i] > max) {
//			max = array[i];
//			cnt++;
//		}
//
//	}
//
//	System.out.println(cnt);
//}
