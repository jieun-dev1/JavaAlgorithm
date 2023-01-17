package BaekJoon.Greedy;

import java.io.IOException;
import java.util.Scanner;

public class BJ11501 {

  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);
    int testcase = sc.nextInt();
    int[] stocks;
    long[] answerArr = new long[testcase];

    for (int i = 0; i < testcase; i++) {
      int day = sc.nextInt();
      stocks = new int[day];
      for (int j = 0; j < day; j++) {
        stocks[j] = sc.nextInt();
      }
      //���� Ǯ�� �ڵ�.
      //1) �ڿ��� ���� ��ȸ
      // 2)���� �ְ��� �ִ��ְ���� max_value �� �����ص�.
      //�� �� �� ���� ���� / ������ �Ǹ� ����.
      int maxValue = Integer.MIN_VALUE; // �ִ���� MIN_VALUE �� ���� ��, mATH.MAX ���� ����.
      long answer = 0;
      for (int j =day-1; j >= 0; j--) {
        if (stocks[j] < maxValue) { //�ε����� 0 �����̹Ƿ� -1����� ��.
          answer += maxValue - stocks[j];
        }
        //maxValue���� ���� ���Ұ� ũ�ų� ���� �� ����.
        maxValue = Math.max(maxValue, stocks[j]);
      }
      answerArr[i] = answer;
    }
    for(long answer: answerArr){
      System.out.println(answer);
    }
  }
}
