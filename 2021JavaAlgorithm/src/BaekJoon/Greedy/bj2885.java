package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * 1시간 안에 못품.
 */
public class bj2885 {

  static int answer = 0;
  static int time = 0;
  //2의 제곱으로 나눠떨어지지 않을 경우, 가장 작은 2의 제곱수 (ex) 6-2^2 = 2.
  // 주어진 수에서 remain을 만드는 데, 몇 번이나 나눠야 하는가를 찾으면 됨.
  // answer, time 둘다 찾아야 하기 때문에 void 로 하고 static 변수를 바꿔준다.
  public void solution(int k){
    //2의 제곱이라면 0을 리턴
    boolean powerOfTwo = isPowerOfTwo(k);
    if(powerOfTwo){
      answer = k;
      time = 0;
    }
    //2의 제곱이 아닌 경우 우선 해당 수보다 큰 2의 제곱 수 중 가장 작은 수를 찾는다. 이것이 가장 작은 초콜릿의 크기.
//    System.out.println((isPowerOfTwo(k))); //정답확인
    if(!powerOfTwo){
      answer = smallestPowerOfTwo(k);
      //num이 size가 되도록. k를 기준으로 k가 0이 되면 exit이다.
      int answerC = answer; //바꿔줄 값이다.
      while(k>0){
        answerC = answerC/2;
        k -= answerC; //결국 k는 0이 될 것이다. answerC가 1이 되면, k가 0이다.
        time++;
      }
    }
  }

  public boolean isPowerOfTwo(int n) {
    //O(20-30)
    while (n > 1) {
      if (n == 1) {
        return true;
      } else if (n % 2 == 1) {
        return false;
      } else if (n % 2 == 0)
        n = n / 2;
        continue;
    }
    return true;
  }

  public int smallestPowerOfTwo(int n) {
    //O(20-30)
    int x = 1;
    while (n > x) {
      x = x * 2;
    }
    return x;
  }

  public static void main(String[] args) {
    bj2885 T = new bj2885();
    Scanner sc = new Scanner(System.in);
    int k = sc.nextInt();
    T.solution(k);
    System.out.print(answer+" " +time);
  }
}
