package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �ҿ�ð�: 2�ð� ���� (1) exit: truck_weights (�־��� Ʈ���� ����) == passedQueue (���� �ǳ� Ʈ���� ��) (2) �����
 * bridge_length �� queue���� �������ͼ�, passed_queue�� truck_weights��ŭ �׿��� ����� ��. (3) 0�� �ƴ� ���� (Ʈ��)��
 * PassedQueue�� �ֱ�
 */
public class TruckV2 {

  /**
   * waited: ��� ���� Ʈ�� bridgeQueue: �ٸ� passedQueue �ٸ��� ������ Ʈ��
   */
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int sum = 0;
    Queue<Integer> waited = new LinkedList<>();
    Queue<Integer> bridgeQueue = new LinkedList<>();
    Queue<Integer> passedQueue = new LinkedList<>();

    //O(N) - offer�� O(1) //
    for (int i = 0; i < truck_weights.length; i++) {
      waited.offer(truck_weights[i]);
    }

    //�� ������ ��� false���� while �� Ż�� - waited �� ������ų�, bridge�� ������� ��.
    while (!waited.isEmpty() || !bridgeQueue.isEmpty()) {
      if (passedQueue.size() == truck_weights.length) {
        return answer;
      }
      if (bridgeQueue.size() == bridge_length) {
        int temp = bridgeQueue.peek();
        if (temp != 0) {
          passedQueue.offer(bridgeQueue.poll());
        } else {
          bridgeQueue.poll();
        }
        sum -= temp;
      }

      if (!waited.isEmpty() && sum + waited.peek() <= weight) {
        int temp = waited.poll();
        sum += temp;
        bridgeQueue.offer(temp);
      } else {
        bridgeQueue.offer(0);
      }
      answer++;
    }

    return answer;
  }

  public static void main(String[] args) {
    TruckV2 T = new TruckV2();
//    System.out.println(T.solution(2, 10, new int[]{7,4,5,6}));
//    System.out.println(T.solution(100, 100, new int[]{10}));
    System.out.println(T.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));

  }
}