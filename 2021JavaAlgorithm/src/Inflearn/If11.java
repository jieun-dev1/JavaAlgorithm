package Inflearn;

import java.util.Scanner;

//��� ����Ʈ: charArray�� �����Ϸ��� �ߴµ� append�� �ȵ�. 
//for ���� �������� �ϸ�, 0��°�� 1��°�� ���� �� �Ѿ�� 1��°�� 2��° ���� ��. �̶� �ٸ���, ���⼭ ù ���ڿ� ���ڸ� answer�� append
//-> ���⼭ ����ȯ.. char-> String�� �ȵ�. 

//��� ����Ʈ
//cnt�� �ʱ�ȭ����. 
//������ ���ڿ��� �� ���ڸ� �־��ֱ�  (������ ����E�� �� ���� ���ڿ� ���ϰ� ������ ����)+ length()-1�� �ؼ� �� ���� E������ �������� �ϱ�. 
//int�� String���� �ٲ� ���� String.valueOf Ȥ�� Integer.toString�� ����. 
public class If11 {

	public String solution(String input) {
		String answer = "";
		input = input + " ";
		int cnt = 1;

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1))
				cnt++;
			else {
				answer += input.charAt(i);
				if (cnt > 1)
					answer += String.valueOf(cnt);
				cnt = 1;
			}

		}
		return answer;

	}
//	for(int i=0; i<input.length(); i++) {
//		while(input.charAt(i) == input.charAt(i+1)) 
//		{
//			p +=1;
//			
//		} if (input.charAt(i) != input.charAt(i+1))
//			answer+=Character.toString(input.charAt(i-1));
//			
//		return answer;		
//	}
//
//		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If11 T = new If11();
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		System.out.print(T.solution(input));
	}

}
