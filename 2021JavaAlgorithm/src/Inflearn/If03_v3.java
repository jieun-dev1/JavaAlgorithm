package Inflearn;

import java.util.Scanner;

public class If03_v3 {
	// 121MS.28MB (������ ��)
	// StringTokenizer �� ������� ���ڿ�, split�� ������� ���ڿ� �迭�� ���´�. Tokenizer�� Ǭ �ڵ�� �迭�� �ϳ�
	// �� �����ߴ�.
	// split���� �ϸ� �迭�� ������ �������ص� �ȴ�.
	// substring��� (�ڹ��� ���ڿ��� �ε��� �������� �߶󳽴�)
	// m�� �ּڰ����� ���س���, ��� ���� ������Ʈ �ϱ�. answer�� �ش� x �� ������Ʈ �ȴ�.
	public String solution(String str) {
		String answer = "";
		int m = Integer.MIN_VALUE, pos;
		// ���� �߰� �� index ��ȣ�� ����. ���� ��� -1 ����.
		// len>m �� ����: ���ٰ� �ϸ� ���� �ܾ ���� �Ǳ� ������.
		while ((pos = str.indexOf(' ')) != -1) {
			String tmp = str.substring(0, pos);
			int len = tmp.length();
			if (len > m) {
				m = len;
				answer = tmp;
			}
			str = str.substring(pos + 1);
		}
		// �� ��� " " �� ���� ������ �ܾ�� �о����� ���ϴ�, ������ �ܾ� ó���� ���� ����� ��.

		if (str.length() > m) {
			answer = str;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �迭�� ������ ������ ������ List, �ƴϸ� ArrayList. []
		// list �� ArrayList�� collection framework �� �����.

		// �迭:
		// ��� �ִ����� ������ ���̱� ������, MIN_VALUE�� �ʱ�ȭ.
		If03_v3 T = new If03_v3();
		Scanner kb = new Scanner(System.in);
		String str = kb.nextLine();
		System.out.println(T.solution(str));
	}

}
