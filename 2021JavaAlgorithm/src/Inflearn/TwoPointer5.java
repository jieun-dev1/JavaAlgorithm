package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

//�õ��� ���� (1) TreeSet ���� Iterate �ϱ� - Ű�� �����ϰ� ������ (���⼭ ����) -> ���� �ʿ� ������.  
//(2)HashMap ���� ���ϴ� �� ����.. 

public class TwoPointer5 {
	// A�� �������� put�� ���ְ�, b���� key�� �����鼭, ���� map�� (a��) key�� b�� key�� �ȵ��������.
	// Ȥ�� b�� Ű�� map���� ������ return no.

	public String solution(String str1, String str2) {
		String answer = "YES";
		HashMap<Character, Integer> hm = new HashMap<>();
		for (char element : str1.toCharArray()) {
			hm.put(element, hm.getOrDefault(element, 0) + 1);
		}
		for (char element2 : str2.toCharArray()) {
			// �ι�° ����: Str2 �� Str1�� ���� ���� ���� �޼��带 ���� ���� �� �Ͼ. �� str �� 2�� ��ġ���� ���� ��.
			// ��ġ�Ѵٸ�, ��� -1�� ���������� �����ϰ� ���� �� �ִ�. (0�� �Ǹ� �� �ݺ��� ���� �־)
			if (hm.containsKey(element2) == false || hm.get(element2) == 0)
				return "NO"; // return ���� �Ǿ� �ֱ⿡ No �̸� �ٷ� exit �� �� �ִ�
			hm.put(element2, hm.get(element2) - 1);
		}
		return answer;

	}

	public static void main(String[] args) {
		// ���� �Լ������� �Է��� �޴´�.
		// static ���� �޼ҵ带 ȣ���Ϸ���, ��ü�� �����ؾ� �Ѵ�.
		TwoPointer5 T = new TwoPointer5();
		Scanner sc = new Scanner(System.in);
		String str1 = sc.next();
		String str2 = sc.next();
		System.out.println(T.solution(str1, str2));
	}

}
