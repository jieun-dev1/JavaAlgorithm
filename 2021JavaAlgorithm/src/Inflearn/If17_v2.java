
package Inflearn;

import java.util.Scanner;

//arry��  ����ؼ� Ȯ���غ����� Arrays.toString(arr)
//int �迭�� �����ϸ� [0,0,0...]�� �����ȴ�. �迭�� 0���� �����ϱ� ������ (��� �� üũ�� arr[2] ���� �Ѵ�. n+1 ������ ����)
//
//1�� ������(�Ҽ��� �ƴ� ��), ������. 
public class If17_v2 {
	private int solution(int n) {
		int answer = 0;
		int[] arr = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				answer++;
				// �Ҽ��� ã������ �Ҽ��� ����� ���� üũ
				for (int j = i; j <= n; j = j + i) {
					arr[j] = 1;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		If17_v2 T = new If17_v2();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		T.solution(n);
		System.out.println(T.solution(n));
	}
}