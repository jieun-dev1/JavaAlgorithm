package Inflearn;

import java.util.Scanner;

public class If01 {

	// .next(): 공백이전까지의 문자열을 입력받는다.
	public int solution(String str, char c) {
		String str_upper = str.toUpperCase();
		// 배열로 바꾸기
		char c_upper = Character.toUpperCase(c);

		int num = 0;

		for (int i = 0; i < str.length(); i++) {
			if (c_upper == str_upper.charAt(i))
				num += 1;
		}

		return num;
	}

	public static void main(String[] args) {
		// 메인 함수에서는 입력을 받는다.
		//
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
		int count = T.solution(str, c);
		System.out.println(count);
	}

}
