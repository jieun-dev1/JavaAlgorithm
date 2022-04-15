package Inflearn;

import java.util.Scanner;

//o(n제곱) n 이 크기 때문에 시간복잡도가 크다.  n = 100,000 이기에, for 문은 버리자. o(n)으로 해결해보기. `
public class If28 {
	public int solution(int num, int m, int[] list) {
		int answer = 0;
		int sum = 0;
		int lt = 0;
		for (int rt = 0; rt < num; rt++) {
			sum += list[rt];
			if (sum == m)
				answer++; // rt를 더해서 m과 일치하는 경우.
			while (sum >= m) {
				sum -= list[lt++];
				if (sum == m)
					answer++; // lt 를 빼서 m 과 일치하는 경우
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		If28 t = new If28();

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int m = sc.nextInt();
		int list[] = new int[num];
		for (int i = 0; i < num; i++) {
			list[i] = sc.nextInt();
		}
		System.out.print(t.solution(num, m, list));
	}
}
