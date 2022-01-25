package Inflearn;

import java.util.Scanner;

//parseInt: ���ڿ��� ���ڷ� ��ȯ. 
//valueOf(): Integer �ʿ� �� / parseInt(): ���� ������ Int �ʿ� ��. 
//Int: (1) ��� ���� ���� (2) primitive �ڷ��� (3) 
//Integer: (1) wrapper Ŭ���� (2) null ó�� ���� (3) unboxing (wrapper class -> primitive �ڷ���) ���� ������ ��� ���� �Ұ�. 
//parseInt: int �� �����ؼ� ��� ������ ����. Value Of�� integer �� �����ؼ� ��� ������ �Ұ�. 
//Integer.parseInt: StringŸ������ �� ���ڸ� primitive Ÿ���� ���ڷ� ��ȯ������. 
//isDigit(): ��õ� char ���� �������� �Ǵ� -> return true/false 
public class If09_v3 {

	public int solution(String str) {
		String answer = "";
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x))
				answer += x;
		}

		return Integer.parseInt(answer);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If09_v3 t = new If09_v3();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(t.solution(str));
	}

}
