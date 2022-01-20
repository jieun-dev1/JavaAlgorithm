package Inflearn;

import java.util.Scanner;

public class If06 {

	// indexOf(문자열에서 문자나 문자열이 처음 등장하는 위치의 인덱스 반환)
	// input.charAt(i)는 input에서 i번째 문자를 반환.
	// 현재 위치 i(ex.k) k가 처음 등장하는(indexOf) 위치와 같을 떄
	// input[i] 이렇게 접근하려면 Array 여야 함
	public String solution(String input) {
		String answer = "";
		for (int i = 0; i < input.length(); i++) {
			if (i == input.indexOf(input.charAt(i))) {
				answer += input.charAt(i);
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If06 T = new If06();
		Scanner kb = new Scanner(System.in);
		String input = kb.next();
		System.out.print(T.solution(input));

//		
//		String[] array = input.toCharArray();
//		LinkedHashSet<Char> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array))
//		Arrays.sort(array);
//		String answer = String.copyValueOf(array);
//		System.out.println(answer);

	}

}
