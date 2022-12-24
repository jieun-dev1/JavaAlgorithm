package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * i--�� �� ���� �� i>=0�̴�. �Ǽ����� ����
 * answer�� ���� �����̴�.
 * �ҿ�ð�: 1�ð�
 *
 * ���ϴ� ���� balance�ε�, tatget���� �߸� ��Ī��.
 * ������ ���ϴ� ���̰� 0���� �Ǵ��� ������ ��.
 *
 * ó������ target�� �ܾ��� ��� ������, �ܾ��� 0�� ��ǥ�� �̰� target�̱� ������,
 * ������ �ʿ����� �ʴ�.
 */
public class BJ5585 {
  int[] dis = new int[]{500, 100, 50, 10, 5, 1};
  static int answer = 0;
  public int solution(int balance){
    if(balance==0){
      return answer;
    }
    for(int i=0;i<dis.length;i++){
      if(dis[i]<=balance){
        balance = balance-dis[i];
        answer++;
        break;
      }
    }
    solution(balance);
    return answer;
  }


  public static void main(String[] args) {
    BJ5585 T = new BJ5585();
    Scanner sc = new Scanner(System.in);
    int money = sc.nextInt();
    System.out.println(T.solution(1000-money));
  }
}
