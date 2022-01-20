package Inflearn;

import java.util.Scanner;

public class If02 {

	public String solution(String str) {
//		for (int i=0; i<str.length();i++) {
//			char t = str.charAt(i);
//			if (Character.isLowerCase(t))
//			{t = t.upperCase()}
//		}		
		// 기존에 받은 str값과는 별개로 upper/lower처리 된 결과 값을 생성해야한다. 빈 String으로 초기화 하자.
		// (1) isLowerCase 로 해결
//		String answer = "";
//		for (char x : str.toCharArray()) {
//			if (Character.isLowerCase(x)) {
//				answer += Character.toUpperCase(x);
//			} else {
//				answer += Character.toLowerCase(x);
//			}
//		}

		// (2) 아스키코드로 해결 97-122는 소문자 65-90은 대문자
		String answer = "";
		for (char x : str.toCharArray()) {
			if (x >= 97 && x <= 122) {
				answer += (char) (x - 32);
			} else {
				answer += (char) (x + 32);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		If02 a = new If02();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(a.solution(str));
	}

}
