package BaekJoon;

import java.util.Scanner;

public class S_2511 {

	// �ذ�å: for �� �ٿ�����!
	// �̺� ���̽��� �������� ��������.

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// a,b �� ���� score
		int finalA = 0;
		int finalB = 0;
		char result = '0';

		// �� �� ������ �޾ƿ���. 10��¥�� a��, �� ���� b��. FOR ���� ȿ�������� �� ���?
		// �����Լ� �̻��� �Ẹ��.
		// for ���� ���� ����. ���� �����δ� Ǯ �� �ְ�����. �ð� ���⵵�� ���� ���̴�. ������ recursion �� ���� �Ǹ�, ����
		// ���⵵�� ��������.

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

		// �迭�� ��ȯ�ؼ� ������ ����� �Ѵ�.. a�� �̱� Ƚ�� x3 + D Ƚ�� X1
		// �迭�� ��ȯ�ؼ� ���������� D�� ������ ����
		// ����� ���� ����ó���� ���? ���� = JUDGE���� A�� B�� Ƚ���� �Ȱ���. �׷��ٸ�, D�� ������ ��, if D���
		// CONTINUE ���������� ���� A Ȥ�� B�� ���ڴ�. ������ ��ȸ�ϱ�..?

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

		// A, B ������ SUM ���ϱ�.

//		System.out.println(judge[3]);
//		System.out.println(scoreA[1]);
//		System.out.println(scoreB[5]);

		if (finalA > finalB) {
			result = 'A';
		} else if (finalA < finalB) {
			result = 'B';
			// ���� ���� ���������� �ºΰ� ���� ���� ��� ã��?
			// D�� ���������� ���� ������ ã��.
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

		// �������� �ʰ� �� �� ����ϴ� ��?
//		System.out.print(judge);

		// ���� ���

	}

}
