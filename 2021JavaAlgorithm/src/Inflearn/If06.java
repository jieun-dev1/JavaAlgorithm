package Inflearn;

import java.util.Scanner;

public class If06 {

	// indexOf(���ڿ����� ���ڳ� ���ڿ��� ó�� �����ϴ� ��ġ�� �ε��� ��ȯ)
	// input.charAt(i)�� input���� i��° ���ڸ� ��ȯ.
	// ���� ��ġ i(ex.k) k�� ó�� �����ϴ�(indexOf) ��ġ�� ���� ��
	// input[i] �̷��� �����Ϸ��� Array ���� ��
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
