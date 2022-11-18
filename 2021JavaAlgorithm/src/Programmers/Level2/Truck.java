package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �� ��° ���õ� Ǯ����, 0�� �̸� �־�δ� �� �ƴ϶� �����ϸ鼭 0�� ť�� �־�� �Ѵ�. �׸��� queue.size�� bridge_length�� ��������
 *
 */
public class Truck {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;

    Queue<Integer> waitList = new LinkedList<>();
    for (int i = 0; i < truck_weights.length; i++) {
      waitList.offer(truck_weights[i]);
    }

    Queue<Integer> bridge = new LinkedList<>(); // bridge �� ����� ������ �ִ� Queue��.
    int currentSum = 0;
    //�ѹ��� 2ȸ�� ȸ���� �� ����.

    for (int i = 0; i < bridge_length; i++) {
      bridge.offer(0); //bridge_length���� 1ª�� ��ŭ,
    }

    while (!waitList.isEmpty()) {
      int temp = waitList.poll();
      for (int i = 0; i < bridge_length; i++) {
        //�� ó���� ��� (0�� ä���� ����)
        if (currentSum == 0 && bridge.size() == bridge_length) {
          bridge.poll();
          bridge.offer(temp);
          answer++;
        }

        //�� �κ��� �߸� �� �� ����.
        else if (currentSum < weight && bridge.size() == bridge_length) {
          if (currentSum + waitList.peek() > weight) {
            currentSum -= bridge.poll();
            bridge.offer(0);
            answer++;
          } else if (currentSum + waitList.peek() <= weight) {
            currentSum -= bridge.poll();
            bridge.offer(waitList.poll()); //���� �׷��ٸ� 0�� �ִ´�.
            currentSum += temp;
            answer++;
          } else if (waitList.isEmpty()) {
            answer++;
            return answer;
          }
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    Truck T = new Truck();
//    System.out.println(T.solution(2,10, new int[]{7,4,5,6}));
    System.out.println(T.solution(100, 100, new int[]{10}));
//    System.out.println(T.solution(100,100, new int[]{10,10,10,10,10,10,10,10,10,10}));
  }
}
