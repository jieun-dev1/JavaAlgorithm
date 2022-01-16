package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;
//�޼���: reverse �� ���� ���� 
//(1) input array�� string ���Ҹ� CharArray�� ��ȯ 
//(2)lt �� rt�� �༭ ���������� �ٲ㰡�鼭 ����. lt<rt �϶��� �����⸦ �Ѵ�. 
//String�� ���̴� ��ȣ�ʿ� | ex. x.length() / Array��� x.length 
public class If04_v2 {

	public ArrayList<String> solution(int number, String[] array) {
		ArrayList<String> answer = new ArrayList<>();
		for (String x : array) {
			char[] s = x.toCharArray();
			int lt = 0, rt = x.length()-1;
			while(lt<rt) {
				char tmp = s[lt];
				s[lt] = s[rt];
				s[rt] = tmp;
				lt++;
				rt++;				
			}
	}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If04 T = new If04();
		Scanner kb = new Scanner(System.in);
		int number = kb.nextInt();
		//["good", "bad"...]
		String[] array = new String[number];
		for (int i = 0; i < number; i++) {
			array[i] = kb.next();
		}

		for (String x : T.solution(number, array)) {
			System.out.println(x);
		}

	}

}