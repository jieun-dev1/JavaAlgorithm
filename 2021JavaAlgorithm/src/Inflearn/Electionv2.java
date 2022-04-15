package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

public class Electionv2 {
	// map.size(): Ű�� ������ �˷���.
	// getOrDefault�� ���� ����: Ű�� ���� �� �ֱ� �����̴�. �ʹ� �߿���!
	// HashMap������ Character�ε� �� �ϳ��� ���� ���� char�ϱ�?

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
		// ���� �Լ������� �Է��� �޴´�.
		// static ���� �޼ҵ带 ȣ���Ϸ���, ��ü�� �����ؾ� �Ѵ�.
		Electionv2 T = new Electionv2();
		Scanner sc = new Scanner(System.in);
		int voterCnt = sc.nextInt();
		String s = sc.next();

//		int count = T.solution(str, c);  //�ٷ� printout �ص� �� 
		System.out.println(T.solution(voterCnt, s));
	}

}
