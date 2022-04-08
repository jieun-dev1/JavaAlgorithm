package Inflearn;

//ó������ run ���ڸ��� ���� ���� ���� ���� ����! ��.�� �ſ� �ѵ��ϴ�. �� ��Ѵ� 
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Electionv2 {
	// map.size(): Ű�� ������ �˷���.
	// getOrDefault�� ���� ����: Ű�� ���� �� �ֱ� �����̴�. �ʹ� �߿���!
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
		// ���� �Լ������� �Է��� �޴´�.
		// static ���� �޼ҵ带 ȣ���Ϸ���, ��ü�� �����ؾ� �Ѵ�.
		Electionv2 T = new Electionv2();
		Scanner sc = new Scanner(System.in);
		int voterCnt = sc.nextInt();
		char[] array = sc.next().toCharArray();

//		int count = T.solution(str, c);  //�ٷ� printout �ص� �� 
		System.out.println(T.solution(voterCnt, array));
	}

}
