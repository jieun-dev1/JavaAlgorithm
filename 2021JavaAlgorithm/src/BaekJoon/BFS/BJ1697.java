package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * n==m일때의 처리
 *
 *  0 100000 하면 힙 에러가 나는 것 같다 - 원인 파악 필요
 */
public class BJ1697 {

  static int answer = 0;
  static int startP;
  static int destP;
  static int[] dis;
  static int[] ch;

  class Node {

    int start;
    int destination;
    int level;

    public Node(int start, int destination, int level) {
      this.start = start;
      this.destination = destination;
      this.level = level;
    }
  }

  public int solution(int start, int destination, int level) {
    Queue<Node> queue = new LinkedList<>();
    ch = new int[200001]; //동생에게 가기까지의 배열

    startP = start;
    destP = destination;
    dis = new int[]{startP, 1, -1};
    Node current = new Node(startP, destP, level);
    queue.offer(current);

    while (!queue.isEmpty()) {
      Node temp = queue.poll();

      if (temp.start == destP) {
        return answer;
      }
      for (int i = 0; i < dis.length; i++) {
        int nx = temp.start + dis[i];
        if (nx > 200000 || nx<0) {
          continue;
        }

        if (nx == destination) {
          temp.level += 1;
          return temp.level;
        }
        queue.offer(new Node(nx, destination, temp.level + 1));
        ch[nx] = 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    BJ1697 T = new BJ1697();
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println(T.solution(a, b, 0));
    //5,0 5 - 정답
  }
}
