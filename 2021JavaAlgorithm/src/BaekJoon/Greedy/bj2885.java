package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * 1시간 안에 못품.
 * 참고: https://141227.tistory.com/218
 */
public class bj2885 {

  static int answer = 0;
  static int time = 0;
  //2의 제곱으로 나눠떨어지지 않을 경우, 가장 작은 2의 제곱수 (ex) 6-2^2 = 2.
  // 주어진 수에서 remain을 만드는 데, 몇 번이나 나눠야 하는가를 찾으면 됨.
  // answer, time 둘다 찾아야 하기 때문에 void 로 하고 static 변수를 바꿔준다.
  public void solution(int k){
  int n = 1;
  //1. 가장 작은 제곱수를 구한다. 1에서 시작한다.
  while(k>n){
    n = n*2;
    answer = n;
  }

  while(k>0){
    if(k>=n){
      k-=n; //k가 n이라면, k==0이어서 바로 리턴됨.
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
