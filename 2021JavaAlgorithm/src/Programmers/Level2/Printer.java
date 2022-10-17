package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 어디서 answer가 ++ 되어야 하는지? 시간 복잡도:
 */
class Unit {

  int id;
  int priority;

  public Unit(int i, int priority) {
    this.id = i;
    this.priority = priority;
  }
}

class Printer {

  public int solution(int[] priorities, int location) {
    int answer = 0;
    Queue<Unit> queue = new LinkedList<>();
    for (int i = 0; i < priorities.length; i++) {
      queue.offer(new Unit(i, priorities[i]));
    }

    while (!queue.isEmpty()) {
      Unit temp = queue.poll();

      for (Unit unit : queue) {
        if (unit.priority > temp.priority) {
          queue.offer(temp);
          //원소를 모두 돌 필요 없고, 하나라도 큰 게 있으면 반복문에서 빠져나와 다음 poll()을 한다.
          temp = null;
          break;
        }
      }
      //if 문을 충족시키지 않은 케이스 구분 필요 temp!=null 로 구분 가능하다.
      //if 를 충족시키지 않을 경우에는 temp가 여전히 null이 아니다.
      //내가 요청하는 아이디가 몇 번째로 인쇄되는지 묻기 때문에, null 이 아닐 떄 (인쇄 가능할 때) + 요청한 아이디인지를 확인해야 함.
      if (temp != null) {
        answer++;

        if (temp.id == location) {
          return answer;
        }
      }
    }
    return answer;
  }
}
