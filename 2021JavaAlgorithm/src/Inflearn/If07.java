package Inflearn;

import java.util.Scanner;

//�� �����ϱ��
public class If07 {

	public String solution(String UpperInput) {
		int n = UpperInput.length();
		String result = "YES";
		for (int i = 0; i < n / 2; i++) {
			if (UpperInput.charAt(i) != UpperInput.charAt(n - 1 - i)) {
				result = "NO";
			}

//����: result="" �� �ʱ�ȭ �ϰ�, No�� �ƴ� ��� Yes�� �ξ���. �̷� ��� abCbD�� ���� ���̽��� yes ��� ������ ���´�. �ʱ�ȭ�� yes�� �ϰ� No�� �ϳ��� ������ No.
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
