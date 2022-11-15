package Programmers;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n과 m은 각각 1 이상 100 이하의 자연수
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
    //인덱스가 0부터 시작하기 때문에 1을 빼줌. 목표지점.
    mapsX = maps.length-1;
    mapsY = maps[0].length-1;

    //목표점이 양 옆으로 닫힌 경우 최소 1,1 이상임. answer = -1 리턴(길이가 가로 세로 2이상이어야 함) 아래 코드도 없어도 됨.
//    if (mapsX >=1  && mapsY >= 1 && maps[mapsX - 1][mapsY] == 0 && maps[mapsX][mapsY - 1] == 0) {
//      answer = -1;
//      return answer;
//    }

    Queue<Node> queue = new LinkedList<>();
    queue.offer(new Node(0, 0));
    //(0,0) 부터 시작하기 때문에 1로 마크해줌.
    dis[0][0] = 1;

    while (!queue.isEmpty()) {
      Node temp = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + temp.x;
        int ny = dy[i] + temp.y;
        //ch 조건을 넣어줘야 루프를 돌지 않는다. 테두리를 벗어나지 않도록 0과 maps 길이를 벗어나지 않도록 조건 넣어주자.
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

    //아래 코드 붙이지 않으면 정확성 3개 틀림. BFS 탐색 시 QUEUE 가 다 빈 상태에서 (할 수 있는 탐색 끝냈을 때) DIS[목표지점]이 0이라면 도달할 수 없었다는 뜻
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


