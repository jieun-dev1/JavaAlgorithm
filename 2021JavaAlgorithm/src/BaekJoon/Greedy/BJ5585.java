package BaekJoon.Greedy;

import java.util.Scanner;

/**
 * i--를 할 때는 꼭 i>=0이다. 실수하지 말기
 * answer가 전역 변수이다.
 * 소요시간: 1시간
 *
 * 변하는 값은 balance인데, tatget으로 잘못 지칭함.
 * 무엇이 변하는 값이고 0으로 되는지 추적할 것.
 *
 * 처음에는 target과 잔액을 모두 줬지만, 잔액이 0이 목표고 이게 target이기 때문에,
 * 별도로 필요하지 않다.
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
