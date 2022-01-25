package Inflearn;

import java.util.Scanner;

//컴파일 에러 오답 
public class If09 {

	// .get(0): 리스트 [0]: ArrayList
	public int solution(String str) {
		String intStr = str.replaceAll("[^0-9]", "");

//  == "0" 이라고 하면, 맨 앞 0이 제거되지 않음 '' single quotes.
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
