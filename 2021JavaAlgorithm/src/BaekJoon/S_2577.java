//charAt: String 문자열 중 한 글자만 선택해서 char 타입으로 변환. 

package BaekJoon;

import java.util.Scanner;

public class S_2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		// int를 String으로
		String result = Integer.toString(a * b * c);
		// char(0-9)와 그 char를 셀 count 배열을 만들어준다. (10길이)
		char[] num = new char[10];
//		char count[] = new char[]; //실수 count는 숫자니까 int로. 
		int[] count = new int[10];
		// 빈 num 열에 char 인 0-9를 넣어주기 char num = [0,1,2,3,4,5,6,7,8,9]
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
