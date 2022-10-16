package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 어디서 answer가 ++ 되어야 하는지?
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
    int answer = 1;
    Queue<Unit> queue = new LinkedList<>();
    for(int i=0;i<priorities.length;i++) {
      queue.offer(new Unit(i, priorities[i]));
    }

    while(queue.isEmpty()) {
      Unit temp = queue.poll();
      for (Unit unit: queue) {
        if (unit.priority > temp.priority) {
          queue.offer(temp);
        }
      }
      if(temp.id == location) {
        return answer;
      }
      answer++;
    }
    return answer;
  }
}
