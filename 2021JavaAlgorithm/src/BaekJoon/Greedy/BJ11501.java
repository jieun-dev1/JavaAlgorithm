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
      //문제 풀이 코드.
      //1) 뒤에서 부터 순회
      // 2)현재 주가가 최대주가라면 max_value 로 저장해둠.
      //한 개 씩 구매 가능 / 여러개 판매 가능.
      int maxValue = Integer.MIN_VALUE; // 최대밗을 MIN_VALUE 로 설정 후, mATH.MAX 통해 갱신.
      long answer = 0;
      for (int j =day-1; j >= 0; j--) {
        if (stocks[j] < maxValue) { //인덱스가 0 부터이므로 -1해줘야 함.
          answer += maxValue - stocks[j];
        }
        //maxValue보다 현재 원소가 크거나 같을 때 갱신.
        maxValue = Math.max(maxValue, stocks[j]);
      }
      answerArr[i] = answer;
    }
    for(long answer: answerArr){
      System.out.println(answer);
    }
  }
}
