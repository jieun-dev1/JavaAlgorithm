package Inflearn;

import java.util.Scanner;

//nextLine�� �ƴ϶� next�� �޾ƿ´� (nextLine�� ������� �ϳ��� �޾ƿ��°�) 
//replace�� ""�� �ƴ�, ''�� ����. 
public class If12 {
	// (1) #�� 1�� *�� 0���� ��ȯ�Ѵ�
	// (2) ���ڸ� 7���� ���´�
	// (3) Integer.parseInt(tmp, 2)�� num �� ���� �ٸ� string���� ���� �����. �ƴϸ� 2������ �״�� ��µȴ�.
	// 2���� -> 10���� Integer.parseInt(1001,2); 10���� -> 2������
	// Integer.toBinaryString(77);
	public String solution(String str, int b) {

		String answer = "";
		for (int i = 0; i < b; i++) {
			String tmp = str.substring(0, 7).replace('#', '1').replace('*', '0');
			int num = Integer.parseInt(tmp, 2);
			char ch = (char) num;
			str = str.substring(7);
			answer += ch;
		}

		// ���ڸ� ascii �ڵ�� ��ȯ

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If12 T = new If12();
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();
		String str = sc.next();
		System.out.println(T.solution(str, b));

	}

}
