package Inflearn;

import java.util.Scanner;

public class If01 {

	// .next(): �������������� ���ڿ��� �Է¹޴´�.
	public int solution(String str, char c) {
//      str_upper�� c_upper ó��, ��ȯ�� ����� ���� ��������� �ʰ�, ������ ������ ��� �ȴ�. 
//		String str_upper = str.toUpperCase();
//		char c_upper = Character.toUpperCase(c);

		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		int num = 0;
//(1)  for��  if �� 
//		for (int i = 0; i < str.length(); i++) {
//			if (c == str.charAt(i))
//				num += 1;
//		}
//(2)  for each �� - CharArray(String�� ���ڿ� �迭�� �����)
// �ݺ��� �̷���� ������ �迭�� �׸��� ������� ������ ������ �ڵ����� ������ ��. 
		for (char x : str.toCharArray()) {
			if (x == c)
				num++;
		}

		return num;
	}

	public static void main(String[] args) {
		// ���� �Լ������� �Է��� �޴´�.
		// static ���� �޼ҵ带 ȣ���Ϸ���, ��ü�� �����ؾ� �Ѵ�.
		If01 T = new If01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
//		int count = T.solution(str, c);  //�ٷ� printout �ص� �� 
		System.out.println(T.solution(str, c));
	}

}
