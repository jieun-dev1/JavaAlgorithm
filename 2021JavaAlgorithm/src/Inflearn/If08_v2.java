package Inflearn;

import java.util.Scanner;

public class If08_v2 {

	// �Ǽ�: Main��ü�� ������ ��, �� Ŭ������ If08_v2�� �ƴ϶� IF08�� �ߴ��� ����� ���Խ� ��ȯ�� �ȵ�. �Ĳ��� üũ�� ��!

	public String solution(String s) {
		String answer = "No";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		System.out.println(s);

		// StringBuilder - for���� ���鼭 char�� ���� �ʿ䰡 ����.
		String tmp = new StringBuilder(s).reverse().toString();
		if (s.equals(tmp))
			answer = "YES";

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If08_v2 t = new If08_v2();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(t.solution(s));

	}

}
