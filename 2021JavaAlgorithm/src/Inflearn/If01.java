package Inflearn;

import java.util.Scanner;

public class If01 {

	// .next(): 공백이전까지의 문자열을 입력받는다.
	public int solution(String str, char c) {
//      str_upper와 c_upper 처럼, 변환할 대상을 새로 만들어주지 않고, 기존의 변수에 덮어도 된다. 
//		String str_upper = str.toUpperCase();
//		char c_upper = Character.toUpperCase(c);

		str = str.toUpperCase();
		c = Character.toUpperCase(c);
		int num = 0;
//(1)  for와  if 문 
//		for (int i = 0; i < str.length(); i++) {
//			if (c == str.charAt(i))
//				num += 1;
//		}
//(2)  for each 문 - CharArray(String을 문자열 배열로 만들기)
// 반복이 이루어질 때마다 배열의 항목을 순서대로 꺼내서 변수에 자동으로 대입해 줌. 
		for (char x : str.toCharArray()) {
			if (x == c)
				num++;
		}

		return num;
	}

	public static void main(String[] args) {
		// 메인 함수에서는 입력을 받는다.
		// static 에서 메소드를 호출하려면, 객체를 생성해야 한다.
		If01 T = new If01();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		char c = kb.next().charAt(0);
//		int count = T.solution(str, c);  //바로 printout 해도 됨 
		System.out.println(T.solution(str, c));
	}

}
