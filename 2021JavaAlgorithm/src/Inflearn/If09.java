package Inflearn;

import java.util.Scanner;

//������ ���� ���� 
public class If09 {

	// .get(0): ����Ʈ [0]: ArrayList
	public int solution(String str) {
		String intStr = str.replaceAll("[^0-9]", "");

//  == "0" �̶�� �ϸ�, �� �� 0�� ���ŵ��� ���� '' single quotes.
		if (intStr.charAt(0) == '0') {
			intStr = intStr.substring(1);
		}

		return Integer.valueOf(intStr);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If09 t = new If09();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(t.solution(str));
	}

}
