package Inflearn;

import java.util.Scanner;

public class If02 {

	public String solution(String str) {
//		for (int i=0; i<str.length();i++) {
//			char t = str.charAt(i);
//			if (Character.isLowerCase(t))
//			{t = t.upperCase()}
//		}		
		// ������ ���� str������ ������ upper/loweró�� �� ��� ���� �����ؾ��Ѵ�. �� String���� �ʱ�ȭ ����.
		// (1) isLowerCase �� �ذ�
//		String answer = "";
//		for (char x : str.toCharArray()) {
//			if (Character.isLowerCase(x)) {
//				answer += Character.toUpperCase(x);
//			} else {
//				answer += Character.toLowerCase(x);
//			}
//		}

		// (2) �ƽ�Ű�ڵ�� �ذ� 97-122�� �ҹ��� 65-90�� �빮��
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
