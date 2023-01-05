package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//ù ��° �ٿ� �ڿ��� N(1<=N<=10,000)�� �־�����,
// ���� N���� �ٿ� M(1<=M<=10,000)�� D(1<=D<=10,000)�� ���ʷ� �־�����.

class Lecture implements Comparable<Lecture> {

  int amount;
  int day;

  Lecture(int amount, int day) {
    this.amount = amount;
    this.day = day;
  }

  @Override
  public int compareTo(Lecture o) {
    if (o.day == this.day) {
      //��¥�� ���ٸ� ������ ������ ������, ��¥�� �ٸ��ٸ� ��¥�� ������������
      return o.amount - this.amount;
    } else {
      return o.day - this.day;
    }
  }
}

public class MaxIncome {

  public int solution(ArrayList<Lecture> list, int maxDay) {
// ���� �� �Ǿ����� Ȯ��.
//    for(int i=0;i<list.size();i++){
//      System.out.println(list.get(i).amount);
//      System.out.println(list.get(i).day);
//    }
    int answer = 0;
    //maxDay�� 10000���� �� �� ����. list�� ������ 10000. �����ᵵ 10000.
    //���� for �� ���Ƶ� 1����
    // ������ �ִ� 1��. int ����.
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    //���� �ݺ����� �� �򰥸��� ��, ���Ҵ� n ���� Ŭ ������ �����ϴ� ��.
    //���� �κ�. for������ ��� j�� ���� �ε����� �����ְ� ����? ���� j�� �ۿ��� �����ϸ� ��.

    int j = 0;
    //i�� ���� �� ��, j�� �þ�鼭 ��ȸ�ؾ� �ϹǷ� i�ȿ� j�� �����.
    for (int i = maxDay; i >= 1; i--) {
      for (; j < list.size(); j++) {
        if (list.get(j).day != i) {
          break;
        }
        queue.add(list.get(j).amount);
      }
      answer += queue.poll();
    }
    return answer;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    MaxIncome T = new MaxIncome();
    int cnt = sc.nextInt();
    //Lecture�� �̷���� List�� �����.
    //Lecture�� �켱������ �������� �� �� �ִ�, �켱������ ���ٸ� amount�� ��������
    ArrayList<Lecture> list = new ArrayList<>();
    //maxDay�� �˾ƾ�, �� ������ ��ȸ�� ����. 6�� ���Ҹ� ��� ��ȸ�ϸ鼭,math.max �� maxDay�߰�.
    int maxDay = Integer.MIN_VALUE;
    for (int i = 0; i < cnt; i++) {
      int amount = sc.nextInt();
      int day = sc.nextInt();
      list.add(new Lecture(amount, day));
      maxDay = Math.max(maxDay, day);
    }

    Collections.sort(list);//sort�� �ؾ� ������ ��� ������ �ȴ�.
    System.out.println(T.solution(list, maxDay));
  }
}
