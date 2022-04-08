package Inflearn;

//처음으로 run 하자마자 오류 없이 정답 맞은 문제! ㅜ.ㅜ 매우 뿌듯하다. 넘 기뿌다 
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Electionv2 {
	// map.size(): 키의 개수를 알려줌.
	// getOrDefault를 쓰는 이유: 키가 없을 수 있기 때문이다. 너무 중요함!
	public char solution(int voterCnt, char[] array) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (Character element : array) {
			hm.put(element, hm.getOrDefault(element, 0) + 1);
		}

		int maxValueInMap = Collections.max(hm.values());
		Character answer = null;
		for (Map.Entry<Character, Integer> m : hm.entrySet()) {
			if (m.getValue() == maxValueInMap)
				answer = m.getKey();
		}
		return answer;
	}

	public static void main(String[] args) {
		// 메인 함수에서는 입력을 받는다.
		// static 에서 메소드를 호출하려면, 객체를 생성해야 한다.
		Electionv2 T = new Electionv2();
		Scanner sc = new Scanner(System.in);
		int voterCnt = sc.nextInt();
		char[] array = sc.next().toCharArray();

//		int count = T.solution(str, c);  //바로 printout 해도 됨 
		System.out.println(T.solution(voterCnt, array));
	}

}
