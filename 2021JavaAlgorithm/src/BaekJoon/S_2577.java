//charAt: String ���ڿ� �� �� ���ڸ� �����ؼ� char Ÿ������ ��ȯ. 

package BaekJoon;

import java.util.Scanner;

public class S_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// int�� String����
		String result = Integer.toString(a * b * c);
		// char(0-9)�� �� char�� �� count �迭�� ������ش�. (10����)
		char[] num = new char[10];
//		char count[] = new char[]; //�Ǽ� count�� ���ڴϱ� int��. 
		int[] count = new int[10];
		// �� num ���� char �� 0-9�� �־��ֱ� char num = [0,1,2,3,4,5,6,7,8,9]
		for (int j = 0; j < 10; j++) {
			num[j] = (char) ('0' + j);
		}

		for (int i = 0; i < result.length(); i++) {
			for (int j = 0; j < 10; j++) {
				if (num[j] == result.charAt(i)) {
					count[j] += 1;
				}

			}
		}

		for (int j = 0; j < 10; j++) {
			System.out.println(count[j]);
		}

	}

}
