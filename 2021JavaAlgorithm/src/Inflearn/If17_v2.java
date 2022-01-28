
package Inflearn;

import java.util.Scanner;

//arry를  출력해서 확인해보려면 Arrays.toString(arr)
//int 배열을 생성하면 [0,0,0...]이 생성된다. 배열이 0부터 시작하기 때문에 (사실 상 체크는 arr[2] 부터 한다. n+1 갯수로 생성)
//
//1이 있으면(소수가 아닌 수), 지나감. 
public class If17_v2 {
	private int solution(int n) {
		int answer = 0;
		int[] arr = new int[n + 1];
		for (int i = 2; i <= n; i++) {
			if (arr[i] == 0) {
				answer++;
				// 소수를 찾았으면 소수의 배수를 전부 체크
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