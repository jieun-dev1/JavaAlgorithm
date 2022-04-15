package Inflearn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//HashSet 쓰는 이유: 많은 자료 관리 시에는 HashSet이 유리. 검색 속도에 있어서 엄청난 차이를 보이기 때문. 

public class Revenue {

	public ArrayList<Integer> solution(int n, int k, int[] record) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> answer = new ArrayList<>();

		for (int i = 0; i < k - 1; i++) {
			hm.put(record[i], hm.getOrDefault(record[i], 0) + 1);
		}

		int lt = 0;
		for (int rt = k - 1; rt < n; rt++) {
			hm.put(record[rt], hm.getOrDefault(record[rt], 0) + 1);
			answer.add(hm.size());
			hm.put(record[lt], hm.getOrDefault(record[lt], 0) - 1);
			if (hm.get(record[lt]) == 0) { // 값이 0일 때 key를 삭제하는 것.
				hm.remove(record[lt]);
			}
			lt++;
		}
		return answer;

	}

	public static void main(String[] args) {

		Revenue T = new Revenue();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] record = new int[n];
		for (int i = 0; i < n; i++) {
			record[i] = sc.nextInt();
		}

		for (int element : T.solution(n, k, record)) {
			System.out.print(element + " ");
		}
	}
}
