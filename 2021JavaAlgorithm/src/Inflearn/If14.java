package Inflearn;

import java.util.Scanner;

//���� 100,000�� �־���. ����for�� x - �ð����⵵ �� 1�� �ȿ� �ȵ� ��. 
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
