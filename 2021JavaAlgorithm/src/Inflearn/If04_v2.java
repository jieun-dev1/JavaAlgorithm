package Inflearn;

import java.util.ArrayList;
import java.util.Scanner;
//메서드: reverse 를 직접 구현 
//(1) input array의 string 원소를 CharArray로 변환 
//(2)lt 와 rt를 줘서 순차적으로 바꿔가면서 진행. lt<rt 일때만 뒤집기를 한다. 
//String의 길이는 괄호필요 | ex. x.length() / Array라면 x.length 
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