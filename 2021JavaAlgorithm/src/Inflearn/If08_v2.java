package Inflearn;

import java.util.Scanner;

public class Main {

	// 실수: Main객체를 생성할 때, 이 클래스인 If08_v2가 아니라 IF08로 했더니 제대로 정규식 변환이 안됨. 꼼꼼히 체크할 것!

	public String solution(String s) {
		String answer = "NO";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");

		// StringBuilder - 변경 가능한 문자열을 만들어줌 (string 은 변경 불가).
		// String에 Stringbuilder를 그대로 넣을 수는 없어서 .toString()
		// for문을 돌면서 char를 비교할 필요가 없다.
		// equals 는 값을 비교. == 는 주소값을 비교.
		String tmp = new StringBuilder(s).reverse().toString();
		if (s.equals(tmp))
			answer = "YES";

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main t = new Main();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(t.solution(s));

	}

}
