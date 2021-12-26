package BaekJoon;

import java.util.Arrays;
import java.util.Scanner;

public class S_4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		// �׽�Ʈ ���̽��� �� ���.
		int numCase = sc.nextInt();
		double[] avr = new double[numCase];
		double[] result = new double[numCase];
		int[] stuCount = new int[numCase];
		double perc = 0;

		// �׽�Ʈ ���̽� ��ŭ for���� ����
		for (int i = 0; i < numCase; i++) {
			int numStd = sc.nextInt();
			int[] score = new int[numStd];
			// �׽�Ʈ ���̽� ������ �л� �� ��ŭ for �� ����. score ��� �迭�� ����.
			for (int j = 0; j < numStd; j++) {
				score[j] = sc.nextInt();
			}
			// �ش� ���̽��� average
			double scoreAvr = Arrays.stream(score).average().orElse(0);
//			System.out.println(scoreAvr);

			for (int j = 0; j < numStd; j++) {
				if (score[j] > scoreAvr) {
					stuCount[i] += 1;
				}
			}

			perc = (double) stuCount[i] / numStd;

//			System.out.println(numStd);
//			System.out.println(stuCount[i]);
//			System.out.println(perc);

			avr[i] = perc;

		}
		// perc�� % �ٿ��� ó���ϱ�.

		for (int i = 0; i < numCase; i++) {
			System.out.println((String.format("%.3f", avr[i] * 100) + "%"));
		}

//		for (int i = 0; i < numCase; i++) {
//			System.out.println((Math.round(avr[i] * 100000.0) / 1000.0) + "%");
//		}
	}

}
