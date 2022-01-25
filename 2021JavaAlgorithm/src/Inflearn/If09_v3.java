package Inflearn;

import java.util.Scanner;

public class If09_v3 {

	public int solution(String str) {
		String answer = "";
		for (char x : str.toCharArray()) {
			if (Character.isDigit(x))
				answer += x;
		}

		return Integer.parseInt(answer);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If09_v3 t = new If09_v3();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(t.solution(str));
	}

}
