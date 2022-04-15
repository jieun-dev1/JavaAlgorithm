package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Electionv2 {
	// map.size(): 키의 개수를 알려줌.
	// getOrDefault를 쓰는 이유: 키가 없을 수 있기 때문이다. 너무 중요함!
	// HashMap에서는 Character인데 왜 하나씩 읽을 때는 char일까?

	public char solution(int voterCnt, String s) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char x : s.toCharArray()) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}

		char answer = ' ';
		int max = Integer.MIN_VALUE;
		for (char key : hm.keySet()) {
			if (hm.get(key) > max) {
				max = hm.get(key);
				answer = key;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		// 메인 함수에서는 입력을 받는다.
		// static 에서 메소드를 호출하려면, 객체를 생성해야 한다.
		Electionv2 T = new Electionv2();
		Scanner sc = new Scanner(System.in);
		int voterCnt = sc.nextInt();
		String s = sc.next();

//		int count = T.solution(str, c);  //바로 printout 해도 됨 
		System.out.println(T.solution(voterCnt, s));
	}

}
