package Inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Stack1 {
	public String solution(String str) {
		String answer = "YES";
		Stack<Character> st = new Stack<>();

		for (char x : str.toCharArray()) {
			if (x == '(')
				st.push(x);
			// else 라는 게 x==')'라는 거지.
			else {
				if (st.isEmpty())
					return "NO"; // 여기서 answer 가 아닌 return 써서 종료되게.
				st.pop();
//			else if (st.isEmpty() && x == ')') answer = "NO";
//			else if (x == ')') st.pop();
			}
		}

		if (!st.isEmpty())
			return "NO";

		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack1 T = new Stack1();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(T.solution(str));

	}

}
