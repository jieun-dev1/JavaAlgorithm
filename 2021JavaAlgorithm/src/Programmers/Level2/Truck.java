package Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 두 번째 예시도 풀려면, 0을 미리 넣어두는 게 아니라 진행하면서 0을 큐에 넣어야 한다. 그리고 queue.size와 bridge_length가 같아지면
 *
 */
public class Truck {

  public int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;

    Queue<Integer> waitList = new LinkedList<>();
    for (int i = 0; i < truck_weights.length; i++) {
      waitList.offer(truck_weights[i]);
    }

    Queue<Integer> bridge = new LinkedList<>(); // bridge 는 사이즈가 정해져 있는 Queue임.
    int currentSum = 0;
    //한버에 2회만 회전할 수 있음.

    for (int i = 0; i < bridge_length; i++) {
      bridge.offer(0); //bridge_length보다 1짧은 만큼,
    }

    while (!waitList.isEmpty()) {
      int temp = waitList.poll();
      for (int i = 0; i < bridge_length; i++) {
        //맨 처음일 경우 (0만 채워진 상태)
        if (currentSum == 0 && bridge.size() == bridge_length) {
          bridge.poll();
          bridge.offer(temp);
          answer++;
        }

        //이 부분이 잘못 된 것 같다.
        else if (currentSum < weight && bridge.size() == bridge_length) {
          if (currentSum + waitList.peek() > weight) {
            currentSum -= bridge.poll();
            bridge.offer(0);
            answer++;
          } else if (currentSum + waitList.peek() <= weight) {
            currentSum -= bridge.poll();
            bridge.offer(waitList.poll()); //만약 그렇다면 0을 넣는다.
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
