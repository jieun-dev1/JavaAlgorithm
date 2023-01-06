package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * 1�ð� �ȿ� ��ǰ.
 */
public class bj2885 {

  static int answer = 0;
  static int time = 0;
  //2�� �������� ������������ ���� ���, ���� ���� 2�� ������ (ex) 6-2^2 = 2.
  // �־��� ������ remain�� ����� ��, �� ���̳� ������ �ϴ°��� ã���� ��.
  // answer, time �Ѵ� ã�ƾ� �ϱ� ������ void �� �ϰ� static ������ �ٲ��ش�.
  public void solution(int k){
    //2�� �����̶�� 0�� ����
    boolean powerOfTwo = isPowerOfTwo(k);
    if(powerOfTwo){
      answer = k;
      time = 0;
    }
    //2�� ������ �ƴ� ��� �켱 �ش� ������ ū 2�� ���� �� �� ���� ���� ���� ã�´�. �̰��� ���� ���� ���ݸ��� ũ��.
//    System.out.println((isPowerOfTwo(k))); //����Ȯ��
    if(!powerOfTwo){
      answer = smallestPowerOfTwo(k);
      //num�� size�� �ǵ���. k�� �������� k�� 0�� �Ǹ� exit�̴�.
      int answerC = answer; //�ٲ��� ���̴�.
      while(k>0){
        answerC = answerC/2;
        k -= answerC; //�ᱹ k�� 0�� �� ���̴�. answerC�� 1�� �Ǹ�, k�� 0�̴�.
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
