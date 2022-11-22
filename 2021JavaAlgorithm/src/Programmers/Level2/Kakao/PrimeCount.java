package Programmers.Level2.Kakao;

import java.util.Scanner;

/**
 n을 k진수로 바꾸려면 n을 k로 나눈 나머지. (끝자리부터 채워짐)
0을 기준으로 split 하고 하나씩 for문 돌면서 소수인지 확인.

 Integer.parseInt(). numberformatexception
 예상 원인: n이 크면 진수가 길 수 밖에없음.
 */
public class PrimeCount {
  public int solution(int n, int k) {
    int answer = 0;
    String str = "";
    while(n>k){
      str+=String.valueOf(n%k); //마지막 숫자부터 더하고.
      n = n/k;
    }
    str+=String.valueOf(n);
    String reversed = new StringBuffer(str).reverse().toString(); //다시 reverse

    String[] arr = reversed.split("([0])+");
    long[] longArr = new long[arr.length];

    for(int i=0;i<arr.length;i++){
      longArr[i] = Long.parseLong(arr[i]);
    }

    for(int i=0;i<longArr.length;i++){
      if(longArr[i]!=1&&ifPrime(longArr[i])){
        answer++;
      }
    }
    return answer;
  }

  /**
   * 2-n을 순회하면서 나눠지는 부분에서 테스트 케이스 1 시간 초과.
   * @param n
   * @return
   */

  public boolean ifPrime(long n){
    for(long i=2;i<n;i++){
      if((n%i)==0){
        return false;
      } else {
        continue;
      }
    }
    return true;
  }

  public static void main(String[] args) {
  PrimeCount T = new PrimeCount();
//    System.out.println(T.solution(437674, 3));
    System.out.println(T.solution(110011, 10));

  }
}
