package Inflearn.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Comparable 을 할 때는 제네릭을 안에 넣어줘야 함.
 *
 * 1. 시간을 오름차 순으로 정렬합니다. (TIme 클래스 만들고, 정렬 구현합니다)
 * 2. type은 알파벳순으로 e가 s 보다 먼저 옵니다 (구현 확인)
 *
 * 오답노트
 * start:5 / end:30이라면. start - end 까지 차례로 순회하도록 했는데, 이렇게 하면 get(i)를 하면 안된다.
 * start - end 는 25인데, list의 사이즈는 10개이기 때문이다.
 *
 * 유의
 * sc.next()는 String이므로, char를 구하고 싶다면 charAt(0)으로 첫글자 가져옴.
 * int -> Integer는 AutoBoxing이 이루어짐.
 *
 */
class Time implements Comparable<Time> {

  int num;
  char type;

  public Time(int num, char type) {
    this.num = num;
    this.type = type;
  }

  //num이 같은 상황에는 type을 알파벳 오름차순으로 정렬
  @Override
  public int compareTo(Time o) {
    if(this.num == o.num) return this.type - o.type;
    else return this.num - o.num;
  }
}

class WeddingV2 {
  public int solution(ArrayList<Time> list, int n){
    int count = 0;
    int listSize = list.size();
    Collections.sort(list);
    int answer = Integer.MIN_VALUE;
    //각 지점마다 겹치는 사람 수를 기록하는 Arr. 추후 sort하여 최대 값을 찾는다.
    for(int i=0;i<listSize;i++){
      //같은 시점에서 s를 먼저 더하면 착오가 될 수 있음 (e가 있다면 빠지는 게 먼저임)
      if(list.get(i).type=='e'){
        count--;
        answer = Math.max(answer, count);
        continue;
      }

      if(list.get(i).type=='s'){
        count++;
        answer = Math.max(answer, count);
        continue;
      }

    }
    return answer;
  }

  public static void main(String[] args) {
    WeddingV2 T = new WeddingV2();
    Scanner sc = new Scanner(System.in);
    ArrayList<Time> list = new ArrayList<>();
    int n = sc.nextInt();
    for(int i=0;i<n;i++){
      list.add(new Time(sc.nextInt(), 's'));
      list.add(new Time(sc.nextInt(), 'e'));
    }
    System.out.println(T.solution(list, n));
  }
}
