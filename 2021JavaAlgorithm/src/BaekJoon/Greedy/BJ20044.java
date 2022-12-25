package BaekJoon.Greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * ��ư� �����ߴµ�, ���������� �����ϴ� ���� ����.
 * �迭�� ������ ������ ������ ���� ��, �Ÿ��� ���� ����� �ͳ��� ���ؾ�, ��տ� �����Ѵ�.
 *
 * 1) �迭�� �����Ѵ�
 *
 *
 */
public class BJ20044 {
  public int solution(int n, int[] arr){
    int answer = 200000; //�ڵ� ������ (�迭�� ���Ұ�)  �ִ� 100,000�̴�. ���� sum�� �ִ밪�� 2000,000��.
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
    int n = sc.nextInt(); //������� ��������.
    int[] arr = new int[2*n];
    for(int i=0;i<2*n;i++){
      arr[i] = sc.nextInt();
    }
    System.out.println(T.solution(n, arr));
  }
}
