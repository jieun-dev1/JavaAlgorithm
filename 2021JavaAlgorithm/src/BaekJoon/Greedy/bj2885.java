package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * 1�ð� �ȿ� ��ǰ.
 * ����: https://141227.tistory.com/218
 */
public class bj2885 {

  static int answer = 0;
  static int time = 0;
  //2�� �������� ������������ ���� ���, ���� ���� 2�� ������ (ex) 6-2^2 = 2.
  // �־��� ������ remain�� ����� ��, �� ���̳� ������ �ϴ°��� ã���� ��.
  // answer, time �Ѵ� ã�ƾ� �ϱ� ������ void �� �ϰ� static ������ �ٲ��ش�.
  public void solution(int k){
  int n = 1;
  //1. ���� ���� �������� ���Ѵ�. 1���� �����Ѵ�.
  while(k>n){
    n = n*2;
    answer = n;
  }

  while(k>0){
    if(k>=n){
      k-=n; //k�� n�̶��, k==0�̾ �ٷ� ���ϵ�.
    } else {
    //k<n
    n/=2;
    time++;
    }
  }
  }

  public static void main(String[] args) {
    bj2885 T = new bj2885();
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    T.solution(k);
    System.out.print(answer+" " +time);
  }
}
