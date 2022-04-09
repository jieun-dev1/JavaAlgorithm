package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

//시도한 전략 (1) TreeSet 에서 Iterate 하기 - 키를 정렬하고 고유값 (여기서 막힘) -> 만들 필요 없었음.  
//(2)HashMap 끼리 비교하는 게 중점.. 

public class TwoPointer5 {
	// A를 기준으로 put을 해주고, b에서 key를 훑으면서, 만약 map의 (a의) key가 b의 key에 안들어있으면.
	// 혹은 b의 키가 map에는 없으면 return no.

	public String solution(String str1, String str2) {
		String answer = "YES";
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char element : str1.toCharArray()) {
			hm.put(element, hm.getOrDefault(element, 0) + 1);
		}
		for (char element2 : str2.toCharArray()) {
			// 두번째 조건: Str2 가 Str1이 갖고 있지 않은 메서드를 갖고 있을 때 일어남. 즉 str 과 2가 일치하지 않을 때.
			// 일치한다면, 모두 -1을 정상적으로 수행하고 끝낼 수 있다. (0이 되면 곧 반복문 끝에 있어서)
			if (hm.containsKey(element2) == false || hm.get(element2) == 0)
				return "NO"; // return 으로 되어 있기에 No 이면 바로 exit 할 수 있다
			hm.put(element2, hm.get(element2) - 1);
		}
		return answer;

	}

	public static void main(String[] args) {
		// 메인 함수에서는 입력을 받는다.
		// static 에서 메소드를 호출하려면, 객체를 생성해야 한다.
		TwoPointer5 T = new TwoPointer5();
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(T.solution(str1, str2));
	}

}
