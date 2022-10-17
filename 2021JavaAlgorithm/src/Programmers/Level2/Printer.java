package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��� answer�� ++ �Ǿ�� �ϴ���? �ð� ���⵵:
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
          //���Ҹ� ��� �� �ʿ� ����, �ϳ��� ū �� ������ �ݺ������� �������� ���� poll()�� �Ѵ�.
          temp = null;
          break;
        }
      }
      //if ���� ������Ű�� ���� ���̽� ���� �ʿ� temp!=null �� ���� �����ϴ�.
      //if �� ������Ű�� ���� ��쿡�� temp�� ������ null�� �ƴϴ�.
      //���� ��û�ϴ� ���̵� �� ��°�� �μ�Ǵ��� ���� ������, null �� �ƴ� �� (�μ� ������ ��) + ��û�� ���̵������� Ȯ���ؾ� ��.
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
