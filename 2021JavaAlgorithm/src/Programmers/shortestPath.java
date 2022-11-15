package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * n�� m�� ���� 1 �̻� 100 ������ �ڿ���
 *
 */

public class shortestPath {

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
  static int[][] ch;
  static int[][] dis;
  static int answer = 0;
  static int mapsX;
  static int mapsY;

  class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  public int solution(int[][] maps) {
    ch = new int[maps.length][maps[0].length];
    dis = new int[maps.length][maps[0].length];
    mapsX = maps.length;
    mapsY = maps[0].length;
    //��ǥ���� ���� ��� answer = -1 ����(���̰� ���� ���� 2�̻��̾�� ��)
    if (mapsX - 2>=0 && mapsY - 2>=0&& maps[mapsX - 2][mapsY - 1] == 0 && maps[mapsX - 1][mapsY - 2] == 0) {
      answer = -1;
      return answer;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0));
    //(0,0) ���� �����ϱ� ������ 1�� ��ũ����.
    ch[0][0] = 1;
    dis[0][0] = 1;

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + temp.x;
        int ny = dy[i] + temp.y;
        //ch ������ �־���� ������ ���� �ʴ´�. �׵θ��� ����� �ʵ��� 0�� maps ���̸� ����� �ʵ��� ���� �־�����.
        if (nx >= 0 && nx <= mapsX - 1 && ny >= 0 && ny <= mapsY - 1 && maps[nx][ny] == 1
            && ch[nx][ny] == 0) {
          queue.offer(new Node(nx, ny));
          ch[nx][ny] = 1;
          dis[nx][ny] = dis[temp.x][temp.y] + 1;
          if (nx == mapsX - 1 && ny == mapsY - 1) {
            return dis[nx][ny];
          }
        }

      }
    }
    return answer;
  }


  public static void main(String[] args) {
    shortestPath T = new shortestPath();
//    System.out.println(T.solution(
//        new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
//            {0, 0, 0, 0, 1}}));

    System.out.println(T.solution(new int[][]{{1, 1, 1, 1, 1}}));

  }
}


