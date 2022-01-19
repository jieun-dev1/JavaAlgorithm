package Inflearn;

import java.util.Scanner;

//왜 오답일까ㅜ
public class If07 {

	public String solution(String UpperInput) {
		int n = UpperInput.length();
		String result = "YES";
		for (int i = 0; i < n / 2; i++) {
			if (UpperInput.charAt(i) != UpperInput.charAt(n - 1 - i)) {
				result = "NO";
			}

//오답: result="" 로 초기화 하고, No가 아닐 경우 Yes를 두었다. 이럴 경우 abCbD와 같은 케이스는 yes 라는 오답이 나온다. 초기화를 yes로 하고 No가 하나라도 나오면 No.
//			} else {
//				result = "YES";
//			}
		}
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If07 T = new If07();
		Scanner kb = new Scanner(System.in);

		String input = kb.next();
		String UpperInput = input.toUpperCase();
		System.out.println(T.solution(UpperInput));

	}

}
