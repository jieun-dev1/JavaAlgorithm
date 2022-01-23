package Inflearn;

import java.util.Scanner;

public class If08_v2 {

	// 실수: Main객체를 생성할 때, 이 클래스인 If08_v2가 아니라 IF08로 했더니 제대로 정규식 변환이 안됨. 꼼꼼히 체크할 것!

	public String solution(String s) {
		String answer = "No";
		s = s.toUpperCase().replaceAll("[^A-Z]", "");
		System.out.println(s);

		// StringBuilder - for문을 돌면서 char를 비교할 필요가 없다.
		String tmp = new StringBuilder(s).reverse().toString();
		if (s.equals(tmp))
			answer = "YES";

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If08_v2 t = new If08_v2();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(t.solution(s));

	}

}
