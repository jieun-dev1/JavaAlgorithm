package Inflearn;

import java.util.Scanner;

public class Main {

	// �Ǽ�: Main��ü�� ������ ��, �� Ŭ������ If08_v2�� �ƴ϶� IF08�� �ߴ��� ����� ���Խ� ��ȯ�� �ȵ�. �Ĳ��� üũ�� ��!

	public String solution(String s) {
		String answer = "NO";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");

		// StringBuilder - ���� ������ ���ڿ��� ������� (string �� ���� �Ұ�).
		// String�� Stringbuilder�� �״�� ���� ���� ��� .toString()
		// for���� ���鼭 char�� ���� �ʿ䰡 ����.
		// equals �� ���� ��. == �� �ּҰ��� ��.
		String tmp = new StringBuilder(s).reverse().toString();
		if (s.equals(tmp))
			answer = "YES";

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main t = new Main();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(t.solution(s));

	}

}
