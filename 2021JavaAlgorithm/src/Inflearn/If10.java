package Inflearn;

import java.util.Scanner;

//���� 1���� ���� ���� sc.next().charAt();
//ù ���ٹ��: toCharArray (�迭�� �ٲٴ� �� �ʿ� ����) 
//���ʿ��� ->> ���������� �о��ֱ�. 
//�����ʿ��� ->> �ަU���� �б�. ���� p������ �۴ٸ� ��ü�ϱ�.
//�ڽ��� t�� ���� �ʴٸ� ��� 1�� ���ϴ� ������. 
//������ answer[i] ����, ���� ���� p���� ������ �� �� ���� ������ answer[i]�� ����. 
//answer �޾Ƽ� �ϳ��� �о��ֱ�. 
//i�� 0���� ũ�ų� �����̴�. 0���� �۴ٷ� �ϸ� 1001�� ���´�(ù��° �ڸ���)- �� ������ ����� �ȵǴ� ��.  
public class If10 {

	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		int p = 1000;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t) {
				p = 0;
				answer[i] = p;
			} else {
				p++;
				answer[i] = p;
			}

		}

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == t)
				p = 0;
			else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If10 T = new If10();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char t = sc.next().charAt(0);
		for (int x : T.solution(s, t)) {
			System.out.print(x + " ");

		}

	}

}
