package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * n과 m은 각각 1 이상 100 이하의 자연수
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
    //목표점이 닫힌 경우 answer = -1 리턴(길이가 가로 세로 2이상이어야 함)
    if (mapsX - 2>=0 && mapsY - 2>=0&& maps[mapsX - 2][mapsY - 1] == 0 && maps[mapsX - 1][mapsY - 2] == 0) {
      answer = -1;
      return answer;
    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0));
    //(0,0) 부터 시작하기 때문에 1로 마크해줌.
    ch[0][0] = 1;
    dis[0][0] = 1;

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + temp.x;
        int ny = dy[i] + temp.y;
        //ch 조건을 넣어줘야 루프를 돌지 않는다. 테두리를 벗어나지 않도록 0과 maps 길이를 벗어나지 않도록 조건 넣어주자.
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


