package Programmers.Level2.Kakao;

import java.util.Scanner;

/**
 n�� k������ �ٲٷ��� n�� k�� ���� ������. (���ڸ����� ä����)
0�� �������� split �ϰ� �ϳ��� for�� ���鼭 �Ҽ����� Ȯ��.

 Integer.parseInt(). numberformatexception
 ���� ����: n�� ũ�� 2,3���� ���� ��츸 �����ص� �� �������.
 �̷� �� n�� �����÷ο� �� �� ������, int�� long ������ �ٲ�����.

 �ҿ�ð�: 2�ð�.
 */
public class PrimeCount {
  public int solution(int n, int k) {
    int answer = 0;
    String str = "";
    while(n>k){
      str+=String.valueOf(n%k); //������ ���ں��� ���ϰ�.
      n = n/k;
    }
    str+=String.valueOf(n);
    String reversed = new StringBuffer(str).reverse().toString(); //�ٽ� reverse
    String[] arr = reversed.split("([0])+");
    long[] longArr = new long[arr.length];

    for(int i=0;i<arr.length;i++){
      longArr[i] = Long.parseLong(arr[i]); // lng���� parse ����.
    }

    for(int i=0;i<longArr.length;i++){
      if(longArr[i]!=1&&ifPrime(longArr[i])){
        answer++;
      }
    }
    return answer;
  }

  /**
   * 2-n�� ��ȸ�ϸ鼭 �������� �κп��� �׽�Ʈ ���̽� 1 �ð� �ʰ�.
   * @param n
   * @return
   */

  public boolean ifPrime(long n){
    for(long i=2;i<=Math.sqrt(n);i++){
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
