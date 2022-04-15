package Inflearn;

import java.util.HashMap;
import java.util.Scanner;

//모든 아나그램 찾기. 
public class Search {

	public int solution(String s, String t) {
		// TODO Auto-generated method stub
		int lt = 0;
		int rt = lt + 2;
		HashMap<Character, Integer> hm = new HashMap<>();
		for (int i = 0; i < t.length(); i++) {
			hm.put(t.toCharArray()[i], hm.getOrDefault(i, 0) + 1);
		}

//		String[] iterArray = s.split("");
		while (rt < s.length()) {
			for (char x : s.split(lt, rt + 1).toCharArray()) {
				if (hm.containsKey(x) == false)
					continue; // 키가 없으면 스킵하기;
				hm.put(x, hm.getOrDefault(x, 0) + 1);
			}
			lt++;
		}
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Search T = new Search();
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		System.out.println(T.solution(str1, str2));

	}
}
