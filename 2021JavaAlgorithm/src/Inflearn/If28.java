package Inflearn;

import java.util.Scanner;

//o(n����) n �� ũ�� ������ �ð����⵵�� ũ��.  n = 100,000 �̱⿡, for ���� ������. o(n)���� �ذ��غ���. `
public class If28 {
	public int solution(int num, int m, int[] list) {
		int answer = 0;
		int sum = 0;
		int lt = 0;
		for (int rt = 0; rt < num; rt++) {
			sum += list[rt];
			if (sum == m)
				answer++; // rt�� ���ؼ� m�� ��ġ�ϴ� ���.
			while (sum >= m) {
				sum -= list[lt++];
				if (sum == m)
					answer++; // lt �� ���� m �� ��ġ�ϴ� ���
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
