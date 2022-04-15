package Inflearn;

import java.util.ArrayList;
//메서드: StringBuilder의 Reverse
// String은 객체를 계속 생성 /StringBuilder 는 생성된 것에 변경을 줌.
//고민 포인트
//(1) 배열을 파라미터로 넣을 때는 String[] str 자료형[] 이름 
//(2) 솔루션을 바로 인쇄하는 게 아니라, 솔루션을 ArrayList로 만들고, forEach 문으로 원소를 출력한다. 
//Array배열을 쓰면, answer[i] = tmp. ArrayList 의 add 를 쓰는게 더 편리하다. 
//(3) reverse 사용 후에 String화를 해야 String 객체로 들어간다. 
//string.valueof() ()안에 들어간 값을 문자열 형변환. 
import java.util.Scanner;

public class If04 {

	public ArrayList<String> solution(int number, String[] array) {
		ArrayList<String> answer = new ArrayList<>();

		for (String x : array) {
			String tmp = new StringBuilder(x).reverse().toString();
			answer.add(tmp);
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If04 T = new If04();
		Scanner kb = new Scanner(System.in);
		int number = kb.nextInt();

		String[] array = new String[number];
		for (int i = 0; i < number; i++) {
			array[i] = kb.next();
		}

		for (String x : T.solution(number, array)) {
			System.out.println(x);
		}

	}

}
