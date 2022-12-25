package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 어렵게 생각했는데, 수학적으로 접근하는 문제 였음.
 * 배열을 오름차 순으로 정렬을 했을 때, 거리가 서로 가까운 것끼리 더해야, 평균에 수렴한다.
 *
 * 1) 배열을 정렬한다
 *
 *
 */
public class BJ20044 {
  public int solution(int n, int[] arr){
    int answer = 200000; //코딩 역량은 (배열의 원소값)  최대 100,000이다. 따라서 sum의 최대값은 2000,000임.
    int[] sum = new int[n];
    Arrays.sort(arr);
    for(int i=0;i<n;i++){
    sum[i] = arr[i] + arr[2*n-i-1];
    answer = Math.min(answer, sum[i]);
    }
    return answer;
  }
  public static void main(String[] args) {
    BJ20044 T = new BJ20044();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); //공백까지 받으려면.
    int[] arr = new int[2*n];
    for(int i=0;i<2*n;i++){
      arr[i] = sc.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }
}
