package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n�� m�� ���� 1 �̻� 100 ������ �ڿ���
 */

public class shortestPath {

  static int[] dx = {-1, 0, 1, 0};
  static int[] dy = {0, 1, 0, -1};
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

    dis = new int[maps.length][maps[0].length];
    //�ε����� 0���� �����ϱ� ������ 1�� ����. ��ǥ����.
    mapsX = maps.length-1;
    mapsY = maps[0].length-1;

    //��ǥ���� �� ������ ���� ��� �ּ� 1,1 �̻���. answer = -1 ����(���̰� ���� ���� 2�̻��̾�� ��) �Ʒ� �ڵ嵵 ��� ��.
//    if (mapsX >=1  && mapsY >= 1 && maps[mapsX - 1][mapsY] == 0 && maps[mapsX][mapsY - 1] == 0) {
//      answer = -1;
//      return answer;
//    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0));
    //(0,0) ���� �����ϱ� ������ 1�� ��ũ����.
    dis[0][0] = 1;

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + temp.x;
        int ny = dy[i] + temp.y;
        //ch ������ �־���� ������ ���� �ʴ´�. �׵θ��� ����� �ʵ��� 0�� maps ���̸� ����� �ʵ��� ���� �־�����.
        if(nx < 0 || nx > mapsX || ny < 0 || ny > mapsY){
          continue;
        }

        if (dis[nx][ny] == 0 && maps[nx][ny] == 1) {
          queue.offer(new Node(nx, ny));
          dis[nx][ny] = dis[temp.x][temp.y] + 1;
          if (nx == mapsX && ny == mapsY) {
            return dis[nx][ny];
          }
        }
      }
    }

    //�Ʒ� �ڵ� ������ ������ ��Ȯ�� 3�� Ʋ��. BFS Ž�� �� QUEUE �� �� �� ���¿��� (�� �� �ִ� Ž�� ������ ��) DIS[��ǥ����]�� 0�̶�� ������ �� �����ٴ� ��
    if (dis[mapsX][mapsY]==0) {
      answer = -1;
      return answer;
    }

    return answer;
  }


  public static void main(String[] args) {
    shortestPath T = new shortestPath();
//    System.out.println(T.solution(
//        new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1},
//            {0, 0, 0, 0, 1}}));

//    System.out.println(T.solution(new int[][]{{1, 1, 1, 1, 1}}));
//    System.out.println(T.solution(new int[][]{{1, 1, 1, 0, 1}}));
//    System.out.println(T.solution(new int[][]{{0, 1, 1, 0, 1}}));
//    System.out.println(T.solution(new int[][]{{1}, {1}, {0}, {0}, {1}}));
  }
}


