package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//첫 번째 줄에 자연수 N(1<=N<=10,000)이 주어지고,
// 다음 N개의 줄에 M(1<=M<=10,000)과 D(1<=D<=10,000)가 차례로 주어진다.

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
      //날짜가 같다면 점수를 내림차 순으로, 날짜가 다르다면 날짜를 내림차순으로
      return o.amount - this.amount;
    } else {
      return o.day - this.day;
    }
  }
}

public class MaxIncome {

  public int solution(ArrayList<Lecture> list, int maxDay) {
// 정렬 잘 되었음을 확인.
//    for(int i=0;i<list.size();i++){
//      System.out.println(list.get(i).amount);
//      System.out.println(list.get(i).day);
//    }
    int answer = 0;
    //maxDay가 10000까지 갈 수 있음. list의 사이즈 10000. 강연료도 10000.
    //이중 for 문 돌아도 1억임
    // 강연료 최대 1억. int 범위.
    PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
    //감소 반복문을 잘 헷갈리는 데, 감소는 n 보다 클 때까지 진행하는 것.
    //막힌 부분. for문에서 어떻게 j가 현재 인덱스에 멈춰있게 하지? 답은 j를 밖에서 정의하면 됨.

    int j = 0;
    //i가 동일 할 때, j가 늘어나면서 순회해야 하므로 i안에 j를 숨긴다.
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
    //Lecture로 이루어진 List를 만든다.
    //Lecture가 우선순위로 내림차순 될 수 있는, 우선순위가 같다면 amount로 내림차순
    ArrayList<Lecture> list = new ArrayList<>();
    //maxDay를 알아야, 이 날부터 순회가 가능. 6개 원소를 모두 순회하면서,math.max 로 maxDay발견.
    int maxDay = Integer.MIN_VALUE;
    for (int i = 0; i < cnt; i++) {
      int amount = sc.nextInt();
      int day = sc.nextInt();
      list.add(new Lecture(amount, day));
      maxDay = Math.max(maxDay, day);
    }

    Collections.sort(list);//sort를 해야 정의한 대로 정렬이 된다.
    System.out.println(T.solution(list, maxDay));
  }
}
