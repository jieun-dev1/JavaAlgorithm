package Inflearn;

import java.util.Scanner;

public class If03_v2 {
	//121MS.28MB (������ ��) 
	// StringTokenizer �� ������� ���ڿ�, split�� ������� ���ڿ� �迭�� ���´�. Tokenizer�� Ǭ �ڵ�� �迭�� �ϳ� �� �����ߴ�.
	// split���� �ϸ� �迭�� ������ �������ص� �ȴ�.
	// m�� �ּڰ����� ���س���, ��� ���� ������Ʈ �ϱ�. answer�� �ش� x �� ������Ʈ �ȴ�.
	public String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE;
		String[] s = str.split(" ");
//		System.out.println(s);
		for (String x : s) {
			int len = x.length();
			if (len > m) {
				m = len;
				answer = x;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �迭�� ������ ������ ������ List, �ƴϸ� ArrayList. []
		// list �� ArrayList�� collection framework �� �����.

		// �迭:
		// ��� �ִ����� ������ ���̱� ������, MIN_VALUE�� �ʱ�ȭ.
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}

}
