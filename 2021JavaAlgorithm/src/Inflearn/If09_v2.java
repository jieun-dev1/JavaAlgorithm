package Inflearn;

import java.util.Scanner;

public class If09_v2 {

	// ASCII '0' = 48, '9':57
	public int solution(String str) {
		int answer = 0;
		for (char x : str.toCharArray()) {
			if (x >= 48 && x <= 57) {
				answer = answer * 10 + (x - 48);
			}
		}
		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If09_v2 t = new If09_v2();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(t.solution(str));
	}

}
