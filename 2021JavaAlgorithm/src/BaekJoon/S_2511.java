package BaekJoon;

import java.util.Scanner;

public class S_2511 {

	// 해결책: for 문 줄여보기!
	// 이벽 케이스를 여러개로 나눠보기.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// a,b 의 최종 score
		int finalA = 0;
		int finalB = 0;
		char result = '0';

		// 두 번 나눠서 받아오기. 10개짜리 a열, 그 다음 b열. FOR 문을 효율적으로 쓸 방법?
		// 메인함수 이상을 써보자.
		// for 문이 많이 나옴. 로직 상으로는 풀 수 있겠지만. 시간 복잡도가 높을 것이다. 하지만 recursion 을 쓰게 되면, 공간
		// 복잡도가 높아진다.

		Scanner sc = new Scanner(System.in);
		int[] scoreA = new int[10];
		int[] scoreB = new int[10];

		for (int i = 0; i < 10; i++) {
			scoreA[i] = sc.nextInt();
		}
		for (int i = 0; i < 10; i++) {
			scoreB[i] = sc.nextInt();
		}

		char[] judge = new char[10];
		for (int i = 0; i < 10; i++) {
			if (scoreA[i] > scoreB[i]) {
				judge[i] = 'A';
			} else if (scoreA[i] < scoreB[i]) {
				judge[i] = 'B';
			} else {
				judge[i] = 'D';
			}
		}

		// 배열로 변환해서 갯수를 세어야 한다.. a가 이긴 횟수 x3 + D 횟수 X1
		// 배열로 변환해서 마지막으로 D가 나오기 전의
		// 비겼을 때의 예외처리를 어떻게? 비겼다 = JUDGE에서 A와 B의 횟수가 똑같다. 그렇다면, D가 나오기 전, if D라면
		// CONTINUE 마지막으로 나온 A 혹은 B가 승자다. 역으로 조회하기..?

		for (int i = 0; i < 10; i++) {
			if (judge[i] == 'A') {
				finalA += 3;
			} else if (judge[i] == 'B') {
				finalB += 3;
			} else if (judge[i] == 'D') {
				finalA += 1;
				finalB += 1;
			}
		}

		// A, B 각각의 SUM 구하기.

//		System.out.println(judge[3]);
//		System.out.println(scoreA[1]);
//		System.out.println(scoreB[5]);

		if (finalA > finalB) {
			result = 'A';
		} else if (finalA < finalB) {
			result = 'B';
			// 비기기 전에 마지막으로 승부가 났을 때를 어떻게 찾지?
			// D가 마지막으로 나온 지점을 찾기.
		} else if (finalA == finalB) {
			for (int i = 10; i < 0; i--) {
				if (judge[i] == 'D') {
					i = i - 1;
				} else if (judge[i] == 'A') {
					result = 'A';
				} else if (judge[i] == 'B') {
					result = 'B';
				} else {
					result = 'D';
				}
			}
		}

		System.out.println(finalA + " " + finalB);
		System.out.println(result);

		// 개행하지 않고 두 번 출력하는 법?
//		System.out.print(judge);

		// 최종 결과

	}

}
