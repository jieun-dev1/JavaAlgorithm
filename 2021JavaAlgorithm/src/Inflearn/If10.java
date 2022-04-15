package Inflearn;

import java.util.Scanner;

//문자 1개를 읽을 때는 sc.next().charAt();
//첫 접근방식: toCharArray (배열로 바꾸는 건 필요 없다) 
//왼쪽에서 ->> 오른쪽으로 읽어주기. 
//오른쪽에서 ->> 왼쪾으로 읽기. 기존 p값보다 작다면 대체하기.
//자신이 t와 같지 않다면 계속 1을 더하는 구조다. 
//이전의 answer[i] 값과, 새로 생긴 p값을 비교했을 때 더 작은 것으로 answer[i]를 덮기. 
//answer 받아서 하나씩 읽어주기. 
//i는 0보다 크거나 같다이다. 0보다 작다로 하면 1001이 나온다(첫번째 자릿수)- 비교 적용이 제대로 안되는 것.  
public class If10 {

	public int[] solution(String s, char t) {
		int[] answer = new int[s.length()];
		int p = 1000;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == t) {
				p = 0;
				answer[i] = p;
			} else {
				p++;
				answer[i] = p;
			}

		}

		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == t)
				p = 0;
			else {
				p++;
				answer[i] = Math.min(answer[i], p);
			}
		}

		return answer;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		If10 T = new If10();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char t = sc.next().charAt(0);
		for (int x : T.solution(s, t)) {
			System.out.print(x + " ");

		}

	}

}
