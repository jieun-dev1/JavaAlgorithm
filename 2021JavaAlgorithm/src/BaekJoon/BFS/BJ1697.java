package BaekJoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * n==m�϶��� ó��
 * �ҿ�ð� 2�ð�.
 * ���� ����: �� �������� 2���ε�, ù���� ��������� 2��� �߸� ������ (���� ���� �Ĳ��� �б�)
 * check �迭�� �־��� m���� ��������.
 */
public class BJ1697 {

  static int answer = 0;
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
    ch = new int[100001]; //�������� ��������� �迭

    int[] dis = new int[]{start, 1, -1};
    Node current = new Node(start, destination, level);
    queue.offer(current);

    //
    while (!queue.isEmpty()) {
      Node temp = queue.poll();

      if (temp.start == destination) {
        return answer;
      }
      for (int i = 0; i < dis.length; i++) {
        dis[0] = temp.start;
        int nx = temp.start + dis[i];
        if (nx > 100000 || nx<0 || ch[nx]!=0) {
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
    //5,0 5 - ����
    //5,17,4 - ����
    //0,100000,100000 - ����
    }
}
