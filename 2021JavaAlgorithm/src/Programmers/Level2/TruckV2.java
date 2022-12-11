package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 소요시간: 2시간 로직 (1) exit: truck_weights (주어진 트럭의 길이) == passedQueue (길을 건넌 트럭의 수) (2) 사이즈가
 * bridge_length 인 queue에서 빠져나와서, passed_queue에 truck_weights만큼 쌓여야 통과한 것. (3) 0이 아닌 숫자 (트럭)만
 * PassedQueue에 넣기
 */
public class TruckV2 {

  /**
   * waited: 대기 중인 트럭 bridgeQueue: 다리 passedQueue 다리를 지나는 트럭
   */
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int sum = 0;
    Queue<Integer> waited = new LinkedList<>();
    Queue<Integer> bridgeQueue = new LinkedList<>();
    Queue<Integer> passedQueue = new LinkedList<>();

    //O(N) - offer는 O(1) //
    for (int i = 0; i < truck_weights.length; i++) {
      waited.offer(truck_weights[i]);
    }

    //두 조건이 모두 false여야 while 문 탈출 - waited 가 비워지거나, bridge가 비워졌을 때.
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